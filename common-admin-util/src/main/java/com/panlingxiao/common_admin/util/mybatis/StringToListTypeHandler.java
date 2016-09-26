package com.panlingxiao.common_admin.util.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by panlingxiao on 2016/9/25.
 * 完成字符串1，2，3到List<Integer>的转换过程
 */
public class StringToListTypeHandler extends BaseTypeHandler<List>{

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public List getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String strVal = rs.getString(columnName);
        if(strVal == null ){
            return null;
        }
        return Arrays.asList(strVal.split(","));
    }

    @Override
    public List getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String strVal = rs.getString(columnIndex);
        if(strVal == null ){
            return null;
        }
        return Arrays.asList(strVal.split(","));
    }

    @Override
    public List getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
