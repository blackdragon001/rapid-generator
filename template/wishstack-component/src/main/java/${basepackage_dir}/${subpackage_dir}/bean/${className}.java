<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign ignoreFieldArr = [
'id','create_user','create_date','modify_user','modify_date','is_del',
'delete_user','delete_date'
]>
package ${basepackage}.${subpackage}.bean;

import java.util.Date;

import com.wishstack.common.bean.BaseBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <一句话功能简述>
 * @author ${author_dir}
 */
@Data
@ApiModel(value = "${classNameLower}Model")
public class ${className} extends BaseBean {

    <#list table.columns as column>
	<#if !ignoreFieldArr?seq_contains(column.sqlName)>
    /**
     * ${column.columnAlias}
     */
    @ApiModelProperty(value = "${column.columnAlias}",example = "")
    private ${column.simpleJavaType} ${column.columnNameLower};
	</#if>
    </#list>
        
}
