/*
 * <一句话功能简述>
 * @author ${author_dir}
 */
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishstack.common.mapper.BaseMapper;
import com.wishstack.common.service.BaseServiceImpl;
import ${basepackage}.${subpackage}.bean.${className};
import ${basepackage}.${subpackage}.mapper.${className}Mapper;

import lombok.extern.slf4j.Slf4j;

/**
 * <一句话功能简述>
 * @author ${author_dir}
 */
@Slf4j
@Service
public class ${className}Service extends BaseServiceImpl<${className}> {
    
    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    protected BaseMapper<${className}> getBaseMapper() {
        return ${classNameLower}Mapper;
    }
}
