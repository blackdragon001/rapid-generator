import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<#include"/java_copyright.include">
<#assign className=table.className>
<#assign remarks=table.remarks>
<#assign classNameLower=className?uncap_first>
<#assign shortName=table.shortName>
<#macro mapperEl value>${r"#{"}${value}}</#macro>
        package ${basepackage}.${subpackage}.controller;
        {basepackage}.${subpackage}.bean.${className};
        {basepackage}.${subpackage}.service.${className}Service;

<#include "/java_class_comment.include">
@RestController
@RequestMapping("/${subpackage}/${classNameLower}")
@Api(value = "${classNameLower}", tags = {"模块功能简述"})
public class ${className}Controller {
    
    @Autowired
    private ${className}Service ${classNameLower}Service;

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
    
    @ApiOperation(value = "获取分页数据")
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public ApiResponse<PageResponse<${className}>> listPage(@Valid @RequestBody ${className} ${classNameLower}) {

        PageResponse<${className}> pageResponse = ${classNameLower}Service.getPageResponse(${classNameLower});
        
        return ApiResponse.response(pageResponse, ErrorCode.SUCCEED);
    }

    @ApiOperation(value = "获取全部数据")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public ApiResponse<PageResponse<${className}>> listAll() {
        ${className} ${classNameLower} = new ${className}();
        PageResponse<${className}> allResponse = ${classNameLower}Service.getPageResponse(${classNameLower});
        return ApiResponse.response(allResponse, ErrorCode.SUCCEED);
    }

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
