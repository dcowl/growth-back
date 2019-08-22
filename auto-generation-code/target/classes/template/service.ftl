package cn.${package}.service.${lowerClassName};
import cn.${package}.pojo.${table.className};
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ${table.className}Service {

    public ${table.className} get${table.className}ById(Long id)throws Exception;

    public List<${table.className}>	get${table.className}ListByMap(Map<String,Object> param)throws Exception;

    public Integer get${table.className}CountByMap(Map<String,Object> param)throws Exception;

    public Integer itriptxAdd${table.className}(${table.className} ${lowerClassName})throws Exception;

    public Integer itriptxModify${table.className}(${table.className} ${lowerClassName})throws Exception;

    public Integer itriptxDelete${table.className}ById(Long id)throws Exception;

    public Page<${table.className}> query${table.className}PageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
