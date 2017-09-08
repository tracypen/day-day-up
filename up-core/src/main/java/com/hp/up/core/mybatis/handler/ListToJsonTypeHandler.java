package com.hp.up.core.mybatis.handler;

import com.alibaba.fastjson.JSONArray;
import com.hp.up.core.temp.Tags;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author haopeng
 * @Date 2017/9/8 15:15
 */
public class ListToJsonTypeHandler implements TypeHandler<Tags> {

    public void setParameter(PreparedStatement ps, int i, Tags parameter, JdbcType jdbcType) throws SQLException {
        if (parameter != null && parameter.getNames() != null && parameter.getNames().size() > 0) {
            ps.setString(i, JSONArray.toJSONString(parameter.getNames()));
        } else {
            ps.setString(i, null);
        }
    }

    public Tags getResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        if (StringUtils.isNotBlank(str)) {
            JSONArray jsonArray = JSONArray.parseArray(str);
            ArrayList<String> names = new ArrayList<String>();
            for (Object string : jsonArray) {
                names.add((String) string);
            }
            return new Tags(names);
        }
        return null;
    }

    public Tags getResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        if (StringUtils.isNotBlank(str)) {
            JSONArray jsonArray = JSONArray.parseArray(str);
            ArrayList<String> names = new ArrayList<String>();
            for (Object string : jsonArray) {
                names.add((String) string);
            }
            return new Tags(names);
        }
        return null;
    }

    public Tags getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        if (StringUtils.isNotBlank(result)) {
            JSONArray jsonArray = JSONArray.parseArray(result);
            ArrayList<String> names = new ArrayList<String>();
            for (Object string : jsonArray) {
                names.add((String) string);
            }
            return new Tags(names);
        }
        return null;
    }

}
