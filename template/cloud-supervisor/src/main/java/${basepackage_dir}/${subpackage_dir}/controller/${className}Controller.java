<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.controller;

import com.wishstack.bean.UserInfo;
import com.wishstack.supervisor.bean.ApiResponse;
import com.wishstack.supervisor.bean.PageResponse;
import com.wishstack.supervisor.controller.UserController;

import ${basepackage}.${subpackage}.entity.${className}Entity;
import ${basepackage}.${subpackage}.service.${className}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author ${author_dir}
 * 注意：Controller中方法级的注释用swagger写，不用javadoc写。
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/${subpackage}/${classNameLower}")
@Api(value = "TODO", tags = {"TODO"})
public class ${className}Controller {
    
    @Autowired
    private ${className}Service ${classNameLower}Service;

    @ApiOperation(value = "获取分页数据", tags = {"TODO"})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ApiResponse<PageResponse<${className}Entity>> listPage(
    		@ApiParam(name = "page", value = "第几页") @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
    		@ApiParam(name = "pageSize", value = "每页记录数") @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
        log.info("接收请求:");
        return new ApiResponse<>(${classNameLower}Service.listPage(page, pageSize));
    }

    @ApiOperation(value = "根据id，获取记录信息",tags = {"Internal"},produces="application/json;charset=utf-8")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResponse<${className}Entity> get${className}ById(
    		@ApiParam(name = "id", value = "主键ID", required = true) @PathVariable String id) throws Exception {
    	${className}Entity ${classNameLower} = ${classNameLower}Service.getById(id);
        if(${classNameLower} == null) {
            return new ApiResponse<>("000001","该记录不存在");
        }
        ApiResponse<${className}Entity> response = new ApiResponse<>(${classNameLower});
        return response;
    }
}
