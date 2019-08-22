package cn.${package}.service.${lowerClassName};

import cn.${package}.mapper.${lowerClassName}.${table.className}Mapper;
import cn.${package}.pojo.${table.className};
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.itrip.common.Constants;

@Service
public class ${table.className}ServiceImpl implements ${table.className}Service {

    @Resource
    private ${table.className}Mapper ${lowerClassName}Mapper;

    public ${table.className} get${table.className}ById(Long id)throws Exception{
        return ${lowerClassName}Mapper.get${table.className}ById(id);
    }

    public List<${table.className}>	get${table.className}ListByMap(Map<String,Object> param)throws Exception{
        return ${lowerClassName}Mapper.get${table.className}ListByMap(param);
    }

    public Integer get${table.className}CountByMap(Map<String,Object> param)throws Exception{
        return ${lowerClassName}Mapper.get${table.className}CountByMap(param);
    }

    public Integer itriptxAdd${table.className}(${table.className} ${lowerClassName})throws Exception{
            ${lowerClassName}.setCreationDate(new Date());
            return ${lowerClassName}Mapper.insert${table.className}(${lowerClassName});
    }

    public Integer itriptxModify${table.className}(${table.className} ${lowerClassName})throws Exception{
        ${lowerClassName}.setModifyDate(new Date());
        return ${lowerClassName}Mapper.update${table.className}(${lowerClassName});
    }

    public Integer itriptxDelete${table.className}ById(Long id)throws Exception{
        return ${lowerClassName}Mapper.delete${table.className}ById(id);
    }

    public Page<${table.className}> query${table.className}PageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = ${lowerClassName}Mapper.get${table.className}CountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<${table.className}> ${lowerClassName}List = ${lowerClassName}Mapper.get${table.className}ListByMap(param);
        page.setRows(${lowerClassName}List);
        return page;
    }

}
