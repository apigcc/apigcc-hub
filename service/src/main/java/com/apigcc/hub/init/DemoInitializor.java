package com.apigcc.hub.init;

import com.apigcc.hub.dto.ProjectDTO;
import com.apigcc.hub.entity.Project;
import com.apigcc.hub.entity.SystemProperty;
import com.apigcc.hub.service.ProjectService;
import com.apigcc.hub.service.SystemPropertyService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Component
public class DemoInitializor {

    public static final String INITIALIZED = "initialized";
    public static final String id = "demo-spring";
    public static final String url = "https://github.com/apigcc/apigcc-demo-spring";

    @Resource
    ProjectService projectService;

    @Resource
    SystemPropertyService systemPropertyService;

    @EventListener
    public void init(ApplicationReadyEvent readyEvent) {
        Optional<SystemProperty> optional = systemPropertyService.get(INITIALIZED);
        if (optional.isPresent() && Objects.equals("true",optional.get().getValue())) {
            return;
        }
        systemPropertyService.save(new SystemProperty(INITIALIZED,"true"));
        ProjectDTO demo = new ProjectDTO();
        demo.setId(id);
        demo.setTitle(id);
        demo.setGit(url);
        demo.setBranch("master");
        projectService.create(demo);
    }

}
