package com.apigcc.hub.web;

import com.apigcc.hub.common.Response;
import com.apigcc.hub.entity.SystemProperty;
import com.apigcc.hub.service.SystemPropertyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/system")
public class SystemPropertyController {

    @Resource
    SystemPropertyService systemPropertyService;

    @GetMapping("/{key}")
    public Response get(@PathVariable String key) {
        return Response.success(systemPropertyService.get(key));
    }

    @PutMapping
    public Response put(@RequestBody List<SystemProperty> list) {
        for (SystemProperty systemProperty : list) {
            systemPropertyService.save(systemProperty);
        }
        return Response.success();
    }

}
