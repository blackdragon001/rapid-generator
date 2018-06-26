<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.controller;

import java.util.*;

import com.wishstack.supervisor.bean.ApiResponse;
import com.wishstack.supervisor.bean.PageResponse;
import com.wishstack.supervisor.controller.UserController;

import ${basepackage}.${subpackage}.entity.${className}Entity;
import ${basepackage}.${subpackage}.service.${className}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author TODO
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/${subpackage}/${classNameLower}")
@Api(value = "TODO", tags = {"TODO"})
public class ${className}Controller {
    
    @Autowired
    private ${className}Service ${classNameLower}Service;

    /**
     * 获分页列表数据
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "TODO", tags = {"TODO"})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ApiResponse<PageResponse<List<${className}Entity>>> listPage(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
        log.info("接收请求:");
        return new ApiResponse<>(${classNameLower}Service.listPage(page, pageSize));
    }

}
