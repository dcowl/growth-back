package org.dcowl.entity;

import java.util.List;

import org.dcowl.utils.StringUtils;

import lombok.Data;

@Data
public class Table {

	private String tableName;

	private String comment;

	private List<Cloumn> cloumns;

	public String getClassName() {
		return StringUtils.captureName(StringUtils.putOffUnderline(this.tableName));
	}
}
