package com.example.superheroes.dao.mapper;

import com.example.superheroes.dto.Hero;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HeroMapper implements RowMapper<Hero> {
  @Override
  public Hero mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Hero (
            rs.getInt("heroId"),
            rs.getString("heroName"),
            rs.getString("heroDesc"),
            rs.getString("superpower")
    );
  }
}
