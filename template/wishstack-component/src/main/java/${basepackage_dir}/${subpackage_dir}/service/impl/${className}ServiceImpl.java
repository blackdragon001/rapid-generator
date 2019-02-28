import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

<#include"/java_copyright.include">
<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
<#assign shortName=table.shortName>
        package ${basepackage}.${subpackage}.service.impl;
        {basepackage}.${subpackage}.bean.${className};
        {basepackage}.${subpackage}.mapper.${className}Mapper;

<#include "/java_class_comment.include">
@Slf4j
@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className}> implements ${className}Service {
    
    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    protected BaseMapper<${className}> getBaseMapper() {
        return ${classNameLower}Mapper;
    }
}
