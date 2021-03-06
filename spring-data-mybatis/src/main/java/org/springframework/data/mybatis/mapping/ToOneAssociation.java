package org.springframework.data.mybatis.mapping;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.BeanUtils;

/**
 * @author Jarvis Song
 */
@Getter
@Setter
public abstract class ToOneAssociation extends Association {

	protected AssociationTable inverseJoinTable;
	protected MyBatisPersistentProperty joinProperty;

	public ToOneAssociation(Table table, Table targetTable, MyBatisPersistentProperty property) {
		super(table);
		this.joinProperty = property;
		this.inverseJoinTable = new AssociationTable();
		BeanUtils.copyProperties(targetTable, this.inverseJoinTable);
		this.inverseJoinTable.setAlias(table.getAlias() + '.' + property.getName());
	}
}
