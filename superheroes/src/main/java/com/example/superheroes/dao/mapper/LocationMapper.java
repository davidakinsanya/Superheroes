package com.example.superheroes.dao.mapper;

import com.example.superheroes.dto.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {
  @Override
  public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Location(
     rs.getString("locationName"),
     rs.getString("addressInfo"),
     rs.getString("locationDesc"),
     rs.getString("coordinates")
    );
  }
}
