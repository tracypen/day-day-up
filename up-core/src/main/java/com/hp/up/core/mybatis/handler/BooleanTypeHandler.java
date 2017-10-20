package com.hp.up.core.mybatis.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class BooleanTypeHandler implements TypeHandler<Boolean> {

	@Override
	public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, parameter ? "1" : "0");
	}

	@Override
	public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
		String str = rs.getString(columnName);
		Boolean result = Boolean.FALSE;
		if (StringUtils.equals(str, "1")) {
			result = Boolean.TRUE;
		}
		return result;
	}

	@Override
	public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
		String str = rs.getString(columnIndex);
		Boolean result = Boolean.FALSE;
		if (StringUtils.equals(str, "1")) {
			result = Boolean.TRUE;
		}
		return result;
	}

	@Override
	public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getBoolean(columnIndex);
	}


}
