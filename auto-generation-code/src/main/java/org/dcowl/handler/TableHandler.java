package org.dcowl.handler;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dcowl.entity.Cloumn;
import org.dcowl.entity.Table;
import org.dcowl.utils.PropertiesUtils;

public class TableHandler {
	
	private List<String> tableExceptList = new ArrayList<String>();

	private static String DBDRIVER = PropertiesUtils.get("database.properties", "driver");

	private static String DBURL = PropertiesUtils.get("database.properties", "url");

	private static String DBUSER = PropertiesUtils.get("database.properties", "user");

	private static String DBPASS = PropertiesUtils.get("database.properties", "user");

	public void addExceptTable(String tableName) {
		tableExceptList.add(tableName);
	}

	private List<Table> queryDataTables() {
		Connection conn = null;
		List<Table> tables = new ArrayList<Table>();
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSet resultSet = dbmd.getTables(null, null, null, new String[] { "TABLE" });
			while (resultSet.next()) {
				Table table = new Table();
				table.setCloumns(new ArrayList<Cloumn>());
				String tableName = resultSet.getString("TABLE_NAME");
				String remarkes = getCommentByTableName(tableName);
				table.setTableName(tableName);
				table.setComment(remarkes);
				ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
				while (rs.next()) {
					Cloumn cloumn = new Cloumn();
					cloumn.setCloumnName(rs.getString("COLUMN_NAME"));
					cloumn.setComment(rs.getString("REMARKS"));
					cloumn.setCloumnType(rs.getString("TYPE_NAME"));
					table.getCloumns().add(cloumn);
				}
				tables.add(table);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tables;
	}

	public List<Table> getTables() {
		List<Table> dataTableList = queryDataTables();
		if (null != dataTableList && dataTableList.size() != 0) {
			if (null != tableExceptList && tableExceptList.size() == 0) {
				for (String tableName : tableExceptList) {
					Iterator<Table> it = dataTableList.iterator();
					while (it.hasNext()) {
						Table x = it.next();
						if (x.getTableName().equals(tableName)) {
							it.remove();
						}
					}
				}
			}
		}
		return dataTableList;
	}

	private static String getCommentByTableName(String tableName) throws Exception {
		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + tableName);
		String comment = null;
		if (rs != null && rs.next()) {
			comment = parse(rs.getString(2));
		}
		rs.close();
		stmt.close();
		conn.close();
		return comment;
	}

	/**
	 * 返回注释信息
	 *
	 * @param all
	 * @return
	 */
	private static String parse(String all) {
		String comment = null;
		int index = all.indexOf("COMMENT='");
		if (index < 0) {
			return "";
		}
		comment = all.substring(index + 9);
		comment = comment.substring(0, comment.length() - 1);
		return comment;
	}
}
