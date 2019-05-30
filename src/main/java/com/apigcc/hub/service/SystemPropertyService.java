package com.apigcc.hub.service;

import com.apigcc.hub.entity.SystemProperty;
import com.apigcc.hub.repository.SystemPropertyRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@Service
public class SystemPropertyService {

    public static final String KEY_SOURCES = "sources";
    public static final String KEY_BUILD = "build";
    public static final String KEY_HOST = "host";

    public static final String DEFAULT_SOURCES = "sources";
    public static final String DEFAULT_BUILD = "build";

    @Resource
    Environment environment;

    @Resource
    SystemPropertyRepository systemPropertyRepository;

    public Optional<SystemProperty> get(String key){
        return systemPropertyRepository.findById(key);
    }

    public synchronized void save(SystemProperty systemProperty){
        systemPropertyRepository.save(systemProperty);
    }

    public String get(String key, String def){
        Optional<SystemProperty> optional = get(key);
        if(!optional.isPresent() || !StringUtils.hasText(optional.get().getValue())){
            return def;
        }
        return optional.get().getValue();
    }

    public String getSources(){
        return get(KEY_SOURCES,DEFAULT_SOURCES);
    }

    public String getBuild(){
        return get(KEY_BUILD,DEFAULT_BUILD);
    }

    public String getHost(){
        return get(KEY_HOST,defaultHost());
    }

    public String defaultHost(){
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = environment.getProperty("local.server.port");
            return "http://"+ip+":"+port;
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
