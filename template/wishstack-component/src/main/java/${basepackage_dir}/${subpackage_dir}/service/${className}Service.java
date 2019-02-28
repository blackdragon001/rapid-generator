<#include"/java_copyright.include">
<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
<#assign shortName=table.shortName>
        package ${basepackage}.${subpackage}.service;{basepackage}.${subpackage}.bean.${className};

<#include "/java_class_comment.include">
public interface ${className}Service extends BaseService<${className}> {

}
