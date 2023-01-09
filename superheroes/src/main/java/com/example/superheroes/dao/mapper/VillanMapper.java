package com.example.superheroes.dao.mapper;

import com.example.superheroes.dto.Villan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VillanMapper implements RowMapper<Villan> {
  @Override
  public Villan mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Villan(rs.getInt("villanId"),
            rs.getString("villanName"),
            rs.getString("villanDesc"),
            rs.getString("superpower"),
            rs.getInt("heroId"));
  }
}
