package com.hp.up.core.mybatis.handler;

import com.hp.up.core.enums.EnumIntegerValue;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author haopeng
 * @Date 2017/9/8 15:12
 */
public class EnumIntegerTypeHandler<E extends EnumIntegerValue> extends BaseTypeHandler<E> {

    private static final Logger logger = LoggerFactory.getLogger(EnumIntegerTypeHandler.class);

    private Class<E> type;
    private E[] enums;

    public EnumIntegerTypeHandler(Class<E> type) {
        logger.debug(type.toString());
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            try {
                return getEnum(value);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot convert " + value + " to " + type.getSimpleName() + " by value.", e);
            }
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            try {
                return getEnum(value);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot convert " + value + " to " + type.getSimpleName() + " by value.", e);
            }
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            try {
                return getEnum(value);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot convert " + value + " to " + type.getSimpleName() + " by value.", e);
            }
        }
    }

    private E getEnum(int value) throws IllegalArgumentException {
        for (E e : enums) {
            if (e.getValue() == value) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }

    



}
