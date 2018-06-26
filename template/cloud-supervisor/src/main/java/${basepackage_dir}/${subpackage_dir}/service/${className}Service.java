/*
 * 文 件 名:  ${table.className}Service.java
 * 创 建 人:  
 * 创建时间:  
 */
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wishstack.supervisor.bean.PageResponse;
import com.wishstack.supervisor.entity.${className}Entity;
import com.wishstack.supervisor.mapper.${className}Mapper;
import com.wishstack.supervisor.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * <一句话功能简述>
 * @author TODO
 */
@Slf4j
@Service
@Transactional(value = "primaryTransactionManager")
public class ${className}Service {
	
    @Autowired
    private ${className}Mapper ${classNameLower}Mapper;

    /**
     * 新增记录
     * @param userEntity
     * @return
     */
	public int add(${className}Entity ${classNameLower}Entity) {
		if(null == ${classNameLower}Entity){
			return 0;
		}
        int rows = ${classNameLower}Mapper.insert(${classNameLower}Entity);
        return rows;
	}

    /**
     * 更新记录
     * @param userEntity
     * @return
     */
    public int update(${className}Entity ${classNameLower}Entity) {
		if(null == ${classNameLower}Entity){
			return 0;
		}
        int rows = ${classNameLower}Mapper.update(${classNameLower}Entity);
        return rows;
    }
    
    /**
     * 删除记录
     * @param id
     * @return
     */
    public int delete(String id) {
		if(null == id){
			return 0;
		}
        int rows = ${classNameLower}Mapper.deleteById(id);
        return rows;
    }
    
    /**
     * 根据ID获取记录
     * @param id
     * @return
     */
    public ${className}Entity getById(String id) {
		if(null == id){
			return null;
		}
		${className}Entity ${classNameLower}Entity = ${classNameLower}Mapper.getById(id);
		//
        return ${classNameLower}Entity;
    }

	/**
	 * 根据指定条件获取记录数
	 * @param params
	 * @return
	 */
	public Integer countBy(Map<String, Object> params){
		Integer rows = ${classNameLower}Mapper.countBy(params);
		return rows;
	}

	/**
	 * 分页查询
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageResponse<List<${className}Entity>> listPage(Integer page, Integer pageSize){
        PageHelper.startPage(page, pageSize);
        
        Page<${className}Entity> list = ${classNameLower}Mapper.list();
		
        return new PageResponse<>(list.getTotal(), page, pageSize, list.getResult());
	}
}
