<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.mapper;

import com.wishstack.common.mapper.BaseMapper;
import ${basepackage}.${subpackage}.bean.${className};

/**
 * <一句话功能简述>
 * @author ${author_dir}
 */
public interface ${className}Mapper extends BaseMapper<${className}> {
    
}