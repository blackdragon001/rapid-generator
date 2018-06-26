<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wishstack.supervisor.entity.UserEntity;

import ${basepackage}.${subpackage}.model.${className};

//@Mapper
public interface ${className}Mapper {
    
    ${className}Entity getById(String id);
    
    int countBy(Map<String, Object> params);

    Page<${className}Entity> listPage(@Param("page")Integer page, @Param("pageSize")Integer pageSize);
    
    int insert(${className}Entity ${classNameLower});
    
    int batchInsert(@Param("${classNameLower}s") List<${className}Entity> ${classNameLower}s);
    
    int update(${className}Entity ${classNameLower});
    
    int deleteById(String id);
}