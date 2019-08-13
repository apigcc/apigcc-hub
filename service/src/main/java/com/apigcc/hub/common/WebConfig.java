package com.apigcc.hub.common;

import com.apigcc.hub.service.SystemPropertyService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 配置构建文件输出目录，提供构建资源文件访问能力
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    SystemPropertyService systemProperty;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/books/**")
                .addResourceLocations(fileLocation())
                .setCacheControl(CacheControl.noCache());
    }

    private String fileLocation(){
        Path path = Paths.get(systemProperty.getBuild()).toAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder("file:");
        stringBuilder.append(path.toString());
        if(!path.endsWith(File.separator)){
            stringBuilder.append(File.separator);
        }
        return stringBuilder.toString();
    }

}
