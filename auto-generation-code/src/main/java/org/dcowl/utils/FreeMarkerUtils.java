package org.dcowl.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import java.io.*;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-6-5.
 */
public class FreeMarkerUtils {

	private static Template getTemplate(String template_path, String templateFileName) {
		Configuration configuration = new Configuration();
		Template template = null;
		try {
			configuration.setDirectoryForTemplateLoading(new File(template_path));
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			configuration.setDefaultEncoding("UTF-8"); // 设置编码
			// 模板文件
			template = configuration.getTemplate(templateFileName + ".ftl");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return template;
	}

	public static void genteratorFile(Map<String, Object> input, String templatePath, String templateFileName,
			String savePath, String fileName) {
		Template template = getTemplate(templatePath, templateFileName);
		File file = new File(savePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(savePath + "\\" + fileName), "UTF-8");
			template.process(input, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
