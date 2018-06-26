<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ${table.tableAlias}
 * @version 1.0
 * @author
 */
@Data
public class ${className}Entity implements Serializable {

	<#list table.columns as column>
	// ${column.columnAlias}
	private ${column.simpleJavaType} ${column.columnNameLower};
	</#list>
		
}
