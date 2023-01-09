package com.example.superheroes.dao;

import com.example.superheroes.dto.Location;
import com.example.superheroes.dto.Sighting;

import java.util.List;

/**
 * This interface outlines all the database interactions
 * involving superhero location and sightings.
 *
 * @author david
 */
public interface LocationData {

  /**
   * This method adds a superhero sighting to the database.
   *
   * @return whether the database update was successful
   */
  boolean addSighting(Sighting sighting);


  /**
   * This method adds a location sighting to the database.
   *
   * @return whether the database update was successful
   */
  boolean addLocation(Location location);

  /**
   * This method gets all the sightings of different superheros.
   *
   * @return a list of superhero sightings
   */
  List<Sighting> getAllSightings();

  /**
   * This method gets a list of locations where superheros/villans have been sighted.
   *
   * @return a list of locations
   */
  List<Location> getAllLocations();

  /**
   * This method all location coordinates of sightings.
   *
   * @return a list of coordinates referring to locations
   */
  List<String> getCoordinates();

  /**
   * This method gets a specific sighting from the database.
   *
   * @param id the sighting ID of the sighting
   * @return the desired sighting object
   */
  Sighting getSightingById(int id);

  /**
   * This method gets a specific location from the database.
   *
   * @param coordinates the coordinates of the location
   * @return the desired location object
   */
  Location getLocationById(String coordinates);

  /**
   * This method updates a sighting entry in the database.
   *
   * @param sighting the sighting subject to updating
   * @return whether the update was successful
   */
  boolean updateSighting(Sighting sighting);

  /**
   * This method updates a location entry in the database.
   *
   * @param location the location object subject to updating
   * @return whether the update was successful
   */
  boolean updateLocation(Location location);

  /**
   * This method deletes a sighting entry from the database.
   *
   * @param id the id of the sighting
   * @return whether the database update was successful
   */
  boolean deleteSighting(int id);

  /**
   * This method deletes a location entry from the database.
   *
   * @param coordinates the coordinates of the location
   * @return whether the database update was successful
   */
  boolean deleteLocation(String coordinates);
}
