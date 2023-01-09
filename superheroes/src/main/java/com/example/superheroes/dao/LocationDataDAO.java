package com.example.superheroes.dao;

import com.example.superheroes.dao.mapper.CordinateMapper;
import com.example.superheroes.dao.mapper.SightingMapper;
import com.example.superheroes.dao.mapper.LocationMapper;
import com.example.superheroes.dto.Location;
import com.example.superheroes.dto.Sighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * This class defines all the database interactions
 *  * involving superhero location and sightings.
 *
 * @author david
 */
public class LocationDataDAO implements LocationData {

  @Autowired
  private final JdbcTemplate jdbcTemplate;

  public LocationDataDAO(JdbcTemplate temp) {
    this.jdbcTemplate = temp;
  }

  /**
   * This method adds a superhero sighting to the database.
   *
   * @param sighting a sighting object
   * @return whether the database update was successful
   */
  @Override
  public boolean addSighting(Sighting sighting) {
    final String sql = "INSERT INTO Sighting (coordinates, sightingDate, heroId) " +
            "VALUES (?,?,?)";

    return jdbcTemplate.update(sql,
            sighting.getCoordinates(),
            sighting.getSightingDate(),
            sighting.getHeroID()) > 0;
  }


  /**
   * This method adds a location sighting to the database.
   *
   * @return whether the database update was successful
   */
  @Override
  public boolean addLocation(Location location) {
    final String sql = "INSERT INTO Location (locationName, addressInfo, locationDesc, coordinates) " +
                        "VALUES (?,?,?,?)";

    return jdbcTemplate.update(sql, location.getName(),
            location.getInfo(),
            location.getDesc(),
            location.getCoordinates()) > 0;
  }

  /**
   * This method gets all the sightings of different superheros.
   *
   * @return a list of superhero sightings
   */
  @Override
  public List<Sighting> getAllSightings() {
    final String sql = "SELECT * FROM Sighting";
    return jdbcTemplate.query(sql, new SightingMapper());
  }

  /**
   * This method gets a list of locations where superheros/villans have been sighted.
   *
   * @return a list of locations
   */
  @Override
  public List<Location> getAllLocations() {
    final String sql = "SELECT * FROM Location";
    return jdbcTemplate.query(sql, new LocationMapper());
  }

  /**
   * This method all location coordinates of sightings.
   *
   * @return a list of coordinates referring to locations
   */
  @Override
  public List<String> getCoordinates() {
    final String sql = "SELECT coordinates FROM Location";
    return jdbcTemplate.query(sql, new CordinateMapper());
  }

  /**
   * This method gets a specific sighting from the database.
   *
   * @param id the sighting ID of the sighting
   * @return the desired sighting object
   */
  @Override
  public Sighting getSightingById(int id) {
    final String sql = "SELECT * FROM Sighting WHERE sightingID = " + id;
    return jdbcTemplate.queryForObject(sql, new SightingMapper());
  }

  /**
   * This method gets a specific location from the database.
   *
   * @param coordinates the coordinates of the location
   * @return the desired location object
   */
  @Override
  public Location getLocationById(String coordinates) {
    final String sql = "SELECT * FROM Location WHERE coordinates = ?";

    return jdbcTemplate.queryForObject(sql, new LocationMapper(), coordinates);
  }

  /**
   * This method updates a sighting entry in the database.
   *
   * @param sighting the sighting subject to updating
   * @return whether the update was successful
   */
  @Override
  public boolean updateSighting(Sighting sighting) {
    final String sql = "UPDATE Sighting " +
                       "SET coordinates = ? " +
            ", sightingDate = ? " +
            ", heroId = ? " +
            "WHERE coordinates = ?";

    return jdbcTemplate.update(sql,
            sighting.getCoordinates(),
            sighting.getSightingDate(),
            sighting.getHeroID(),
            sighting.getCoordinates()) > 0;
  }

  /**
   * This method updates a location entry in the database.
   *
   * @param location the location object subject to updating
   * @return whether the update was successful
   */
  @Override
  public boolean updateLocation(Location location) {
    final String sql = "UPDATE Location " +
            "SET locationName = ? " +
            ", addressInfo = ? " +
            ", locationDesc = ? " +
            "WHERE coordinates = ?";

    return jdbcTemplate.update(sql,
            location.getName(),
            location.getInfo(),
            location.getDesc(),
            location.getCoordinates()) > 0;
  }

  /**
   * This method deletes a sighting entry from the database.
   *
   * @param id the id of the sighting
   * @return whether the database update was successful
   */
  @Override
  public boolean deleteSighting(int id) {
    final String sql = "DELETE FROM Sighting WHERE sightingID = ?";
    return jdbcTemplate.update(sql, id) > 0;
  }

  /**
   * This method deletes a location entry from the database.
   *
   * @param coordinates the coordinates of the location
   * @return whether the database update was successful
   */
  @Override
  public boolean deleteLocation(String coordinates) {
    final String sql = "DELETE FROM Location WHERE coordinates = ?";
    return jdbcTemplate.update(sql, coordinates) > 0;
  }
}
