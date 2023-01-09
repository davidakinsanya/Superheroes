package com.example.superheroes.dao.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class IDMapper implements RowMapper<Integer> {
  @Override
  public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
    return rs.getInt("heroId");
  }
}
