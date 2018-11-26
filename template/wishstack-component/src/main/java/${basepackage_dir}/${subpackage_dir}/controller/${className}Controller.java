<#include "/java_copyright.include">
<#assign className = table.className>
<#assign remarks = table.remarks>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.controller;

import java.util.Date;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wishstack.common.bean.ApiResponse;
import com.wishstack.common.bean.LoginUser;
import com.wishstack.common.bean.PageResponse;
import com.wishstack.common.util.ErrorCode;
import ${basepackage}.${subpackage}.bean.${className};
import ${basepackage}.${subpackage}.service.${className}Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <一句话功能简述>
 * @author ${author_dir}
 * ${remarks}
 */
@RestController
@RequestMapping("/${subpackage}/${classNameLower}")
@Api(value = "${classNameLower}API", tags = {"模块功能简述"})
public class ${className}Controller {
    
    @Autowired
    private ${className}Service ${classNameLower}Service;
    
    /**
     * 新增记录
     * @param contact
     * @return
     */
    @ApiOperation(value="新增")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ApiResponse<${className}> add(@Valid @RequestBody ${className} ${classNameLower}, LoginUser user){

    	${classNameLower}.setId(UUID.randomUUID().toString());
        ${classNameLower}.setCreateUser(user.getId());
        ${classNameLower}.setCreateDate(new Date());
        boolean isSuccess = ${classNameLower}Service.save(${classNameLower});
        return isSuccess ? ApiResponse.response(${classNameLower}, ErrorCode.SUCCEED) 
                : ApiResponse.response(${classNameLower}, ErrorCode.FAILURE_ADD);
    }

    /**
     * 批量逻辑删除
     * 将数据库中的is_del字段设置为false
     * 记录逻辑删除时间
     * @param id
     * @return
     */
    @ApiOperation(value="逻辑删除")
    @RequestMapping(value = "/logicBatchDelete", method = RequestMethod.DELETE)
    public ApiResponse<${className}> logicBatchDelete(
            @RequestParam(value = "ids", required = true) String[] ids, LoginUser user) {

        ${className} ${classNameLower} = new ${className}();
        ${classNameLower}.setDeleteIds(ids);
        ${classNameLower}.setDeleteUser(user.getId());
        ${classNameLower}.setDeleteDate(new Date());
        int delCount = ${classNameLower}Service.logicDeleteBatch(${classNameLower});
        
        if (delCount > 0 ) {
            return ApiResponse.response(${classNameLower}, ErrorCode.SUCCEED);
        }else{
            return ApiResponse.response(${classNameLower}, ErrorCode.FAILURE_LOGIC_DELETE);
        }
    }
    
    /**
     * 删除数据，物理删除
     * @param id
     * @return
     */
    @ApiOperation(value="物理删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ApiResponse<${className}> delete(@PathVariable String id) {
        
        boolean res = ${classNameLower}Service.delete(id);
        if (res) {
            return ApiResponse.response(null, ErrorCode.SUCCEED);
        }else{
            return ApiResponse.response(null, ErrorCode.FAILURE_DELETE);
        }
    }

    /**
     * 更新数据
     * @param id
     * @return
     */
    @ApiOperation(value="更新")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ApiResponse<${className}> update(@Valid @RequestBody ${className} ${classNameLower}, LoginUser user) {

        ${classNameLower}.setModifyUser(user.getId());
        ${classNameLower}.setModifyDate(new Date());
        boolean res = ${classNameLower}Service.update(${classNameLower});
        if (res) {
            return ApiResponse.response(${classNameLower}, ErrorCode.SUCCEED);
        }else{
            return ApiResponse.response(${classNameLower}, ErrorCode.FAILURE_UPDATE);
        }
    }
    
    /**
     * 获取分页数据
     * @param page
     * @param pageSize
     * @param orderField
     * @param orderFieldType
     * @param user
     * @return
     */
    @ApiOperation(value = "获取分页数据")
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public ApiResponse<PageResponse<${className}>> listPage(
            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(value = "page", required = false, defaultValue = "1") String page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") String pageSize,
            @RequestParam(value = "orderField", required = false) String orderField,
            @RequestParam(value = "orderFieldType", required = false) String orderFieldType,
            LoginUser user) {
        
        ${className} ${classNameLower} = new ${className}();
        ${classNameLower}.setPage(Integer.parseInt(page));
        ${classNameLower}.setPagesize(Integer.parseInt(pageSize));
        ${classNameLower}.setOrderField(orderFieldType);
        ${classNameLower}.setOrderFieldType(orderFieldType);
        ${classNameLower}.setKeyword(keyword);
        
        PageResponse<${className}> pageResponse = ${classNameLower}Service.getPageResponse(${classNameLower});
        
        return ApiResponse.response(pageResponse, ErrorCode.SUCCEED);
    }
    
    /**
     * 获取全部数据
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "获取全部数据")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public ApiResponse<PageResponse<${className}>> listAll() {
        ${className} ${classNameLower} = new ${className}();
        PageResponse<${className}> allResponse = ${classNameLower}Service.getPageResponse(${classNameLower});
        return ApiResponse.response(allResponse, ErrorCode.SUCCEED);
    }

    /**
     * 获取详细信息
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "根据id，获取记录信息")
    @RequestMapping(value = "/get${className}Detail/{id}", method = RequestMethod.GET)
    public ApiResponse<${className}> get${className}DetailById(
            @ApiParam(name = "id", value = "主键ID", required = true) @PathVariable String id) {
        
        ${className} ${classNameLower} = ${classNameLower}Service.getEntity(id);
        if(${classNameLower} == null) {
            return ApiResponse.response(${classNameLower}, ErrorCode.FAILURE_NO_EXISTED);
        }
        return ApiResponse.response(${classNameLower}, ErrorCode.SUCCEED);
    }
}
