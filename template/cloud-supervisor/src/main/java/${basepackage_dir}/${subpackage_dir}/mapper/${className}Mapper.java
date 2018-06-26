<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import ${basepackage}.${subpackage}.entity.${className}Entity;

//@Mapper
public interface ${className}Mapper {

    /**
     * 根据ID获取记录
     * @param id
     * @return
     */
    ${className}Entity getById(String id);

    /**
     * 根据指定条件获取记录数
     * @param params
     * @return
     */
    int countBy(Map<String, Object> params);

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    Page<${className}Entity> list();

    /**
     * 插入记录
     * @param user
     * @return
     */
    int insert(${className}Entity ${classNameLower});

    /**
     * 批量插入记录
     * @param users
     * @return
     */
    int insertBatch(@Param("${classNameLower}s") List<${className}Entity> ${classNameLower}s);

    /**
     * 更新记录
     * @param user
     * @return
     */
    int update(${className}Entity ${classNameLower});

    /**
     * 根据指定ID删除记录
     * @param id
     * @return
     */
    int deleteById(String id);
}