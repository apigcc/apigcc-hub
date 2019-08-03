package com.apigcc.hub.common;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Spring BeanUtils的简单封装
 */
public class BeanHelper {

    public static <T> T copyProperties(Object source, T t) {
        try {
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T copyProperties(Object source, Class<T> clzz) {
        T t = BeanUtils.instantiateClass(clzz);
        return copyProperties(source, t);
    }

    public static <T, R> List<R> copyProperties(Iterable<T> sources, Class<R> clzz) {
        return StreamSupport.stream(sources.spliterator(), false).map(to(clzz)).collect(Collectors.toList());
    }

    public static <T, R> Function<T, R> to(Class<R> clzz) {
        return t -> copyProperties(t, clzz);
    }

    /**
     * Copy from spring BeanUtils copyProperties(Object source, Object target, @Nullable Class<?> editable, @Nullable String... ignoreProperties)
     * when source field is null, will not set to target
     *
     * @param source           the source bean
     * @param target           the target bean
     * @param ignoreProperties array of property names to ignore
     * @throws BeansException if the copying failed
     * @see BeanWrapper
     */
    public static <T> T merge(Object source, T target, @Nullable String... ignoreProperties) throws BeansException {

        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null &&
                            ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);
                            if (value != null) {
                                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                    writeMethod.setAccessible(true);
                                }
                                writeMethod.invoke(target, value);
                            }
                        } catch (Throwable ex) {
                            throw new FatalBeanException(
                                    "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                        }
                    }
                }
            }
        }

        return target;
    }

}
