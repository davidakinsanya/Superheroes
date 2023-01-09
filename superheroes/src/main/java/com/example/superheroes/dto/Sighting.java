package com.example.superheroes.dto;

/**
 * This method stores information on specific superhero sightings.
 *
 * @author david
 */
public class Sighting {
  private int sightingID;
  private int heroId;

  private String sightingDate;
  private String coordinates;

  public Sighting(int heroId, String date, String coordinate) {
    this.heroId = heroId;
    this.sightingDate = date;
    this.coordinates = coordinate;
  }
  public Sighting (int id, int heroId, String date, String coordinate) {
    this.sightingID = id;
    this.heroId = heroId;
    this.sightingDate = date;
    this.coordinates = coordinate;
  }

  /**
   * This method gets a sightings ID number
   *
   * @return the id number of a sighting
   */
  public int getSightingID() {
    return sightingID;
  }

  /**
   * This method gets the superhero sighted.
   *
   * @return the superhero sighted
   */
  public int getHeroID() {
    return heroId;
  }

  /**
   * This method gets the date of the superhero sighting.
   *
   * @return the date of the superhero sighting
   */
  public String getSightingDate() { return sightingDate; }

  /**
   * This method gets the location of the sighting.
   *
   * @return the location of the sighting
   */
  public String getCoordinates() {
    return coordinates;
  }

  public void setHeroId(int heroId) { this.heroId = heroId; }

  public void setSightingDate(String sightingDate) { this.sightingDate = sightingDate; }

  public void setCoordinates(String coordinates) { this.coordinates = coordinates; }
}
