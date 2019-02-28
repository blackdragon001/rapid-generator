import io.swagger.annotations.ApiModel;
import lombok.Data;


<
#include"/macro.include"/>


<
#include"/java_copyright.include">


<
#assign className=table.className>


<
#assign classNameLower=className?uncap_first>


<
#assign ignoreFieldArr=[
        'id','create_user','create_date','modify_user','modify_date','is_del',
        'delete_user','delete_date'
        ]>
        package ${basepackage}.${subpackage}.bean;

<#include "/java_class_comment.include">
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
