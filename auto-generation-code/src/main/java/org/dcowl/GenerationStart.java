package org.dcowl;

import java.util.List;

import org.dcowl.entity.Table;
import org.dcowl.handler.MvcHandler;
import org.dcowl.handler.TableHandler;

/**
 * @author <a href="mailto:2867665887@qq.com">DCOWL</a>
 * @version 1.0
 * @since 1.8.0_131
 */
public class GenerationStart {
	
	public static void main(String[] args) {
		TableHandler tableHandler = new TableHandler();
        tableHandler.addExceptTable("");
        MvcHandler mvcHandler = new MvcHandler();
        List<Table> tableList = tableHandler.getTables();
        for (Table table : tableList) {
            mvcHandler.executeModule(table);
            mvcHandler.executeService(table);
            mvcHandler.executeServiceImpl(table);
            mvcHandler.executeMapper(table);
            mvcHandler.executeClazzMapper(table);
        }
	}
	
}
