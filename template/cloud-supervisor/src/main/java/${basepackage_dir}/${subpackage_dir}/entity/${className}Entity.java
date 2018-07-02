<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ${table.tableAlias}
 * @version 1.0
 * @author
 */
@Data
@ApiModel(value = "${table.tableAlias}")
public class ${className}Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	<#list table.columns as column>
    /**
     * ${column.columnAlias}
     */
	@ApiModelProperty(value = "${column.columnAlias}",example = "")
	private ${column.simpleJavaType} ${column.columnNameLower};
	</#list>
		
}
