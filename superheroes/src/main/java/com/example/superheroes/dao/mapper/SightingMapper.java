package com.example.superheroes.dao.mapper;


import com.example.superheroes.dto.Sighting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SightingMapper implements RowMapper<Sighting> {

  @Override
  public Sighting mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Sighting(
      rs.getInt("SightingID"),
      rs.getInt("heroId"),
      rs.getString("sightingDate"),
      rs.getString("coordinates")
    );
  }
}
