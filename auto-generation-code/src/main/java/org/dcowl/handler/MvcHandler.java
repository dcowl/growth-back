package org.dcowl.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dcowl.constant.Constant;
import org.dcowl.entity.Table;
import org.dcowl.utils.FreeMarkerUtils;
import org.dcowl.utils.PropertiesUtils;
import org.dcowl.utils.StringUtils;

/**
 * @author DC.Admin
 *
 */
public class MvcHandler {

	String templateFile = Constant.template_path;
	
	String packageName = PropertiesUtils.get("parma.properties", "package_name");
	
	/**
	 * 实体
	 * 
	 * @param table
	 */
	public void executeModule(Table table) {
		Map<String, Object> input = new ConcurrentHashMap<String, Object>();
		input.put("table", table);
		input.put("package", packageName);
		input.put("ClassName", StringUtils.lowerName(table.getClassName()));
		String fileName = table.getClassName() + ".java";
		String savePath = Constant.model_save_path;
		String templateName = "model";
		FreeMarkerUtils.genteratorFile(input, templateFile, templateName, savePath, fileName);
	}

	/**
	 * @param table
	 */
	public void executeService(Table table) {
		Map<String, Object> input = new ConcurrentHashMap<String, Object>();
		input.put("table", table);
		input.put("package", packageName);
		input.put("ClassName", StringUtils.lowerName(table.getClassName()));
		String fileName = table.getClassName() + "Service" + ".java";
		String savePath = Constant.service_save_path + "//" + StringUtils.lowerName(table.getClassName()) + "//";
		String templateName = "service";
		FreeMarkerUtils.genteratorFile(input, templateFile, templateName, savePath, fileName);
	}

	/**
	 * @param table
	 */
	public void executeServiceImpl(Table table) {
		Map<String, Object> input = new ConcurrentHashMap<String, Object>();
		input.put("table", table);
		input.put("package", packageName);
		input.put("ClassName", StringUtils.lowerName(table.getClassName()));
		String fileName = table.getClassName() + "ServiceImpl" + ".java";
		String savePath = Constant.servie_impl_save_path + "//" + StringUtils.lowerName(table.getClassName()) + "//";
		String templateName = "serviceImpl";
		FreeMarkerUtils.genteratorFile(input, templateFile, templateName, savePath, fileName);
	}

	/**
	 * @param table
	 */
	public void executeMapper(Table table) {
		Map<String, Object> input = new ConcurrentHashMap<String, Object>();
		input.put("table", table);
		input.put("package", packageName);
		input.put("ClassName", StringUtils.lowerName(table.getClassName()));
		String fileName = table.getClassName() + "Mapper" + ".xml";
		String savePath = Constant.mapper_save_path + "//" + StringUtils.lowerName(table.getClassName()) + "//";
		String templateName = "mapper";
		FreeMarkerUtils.genteratorFile(input, templateFile, templateName, savePath, fileName);
	}

	/**
	 * @param table
	 */
	public void executeClazzMapper(Table table) {
		Map<String, Object> input = new ConcurrentHashMap<String, Object>();
		input.put("table", table);
		input.put("package", packageName);
		input.put("ClassName", StringUtils.lowerName(table.getClassName()));
		String fileName = table.getClassName() + "Mapper" + ".java";
		String savePath = Constant.mapper_save_path + "//" + StringUtils.lowerName(table.getClassName()) + "//";
		String templateName = "clazzMapper";
		FreeMarkerUtils.genteratorFile(input, templateFile, templateName, savePath, fileName);
	}
}
