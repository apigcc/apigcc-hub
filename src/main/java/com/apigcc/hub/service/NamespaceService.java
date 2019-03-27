package com.apigcc.hub.service;

import com.apigcc.hub.common.Response;
import com.apigcc.hub.domain.Namespace;
import com.apigcc.hub.domain.Staff;
import com.apigcc.hub.repository.NamespaceRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/namespaces")
public class NamespaceService {

    @Resource
    NamespaceRepository namespaceRepository;

    /**
     * 创建namespace，并将自己添加进员工
     * @param dto
     * @return
     */
    @PostMapping
    @Transactional
    public Response post(Namespace dto){
        namespaceRepository.save(dto);
        return Response.success();
    }

    @PutMapping
    @Transactional
    public Response put(Namespace dto){
        namespaceRepository.save(dto);
        return Response.success();
    }

    /**
     * 移除命名空间，同时移除工作空间，移除项目，移除命名空间下的用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Transactional
    public Response delete(String id){
        namespaceRepository.deleteById(id);
        return Response.success();
    }

}
