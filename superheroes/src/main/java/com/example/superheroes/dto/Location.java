package com.example.superheroes.dto;

/**
 * This class stores information on locations a superhero has been found.
 *
 * @author david
 */
public class Location {
  private String name;
  private String info;
  private String desc;
  private String coordinates;

  public Location(String name, String coordinates) {
    this.name = name;
    this.coordinates = coordinates;
  }

  public Location(String name, String info, String desc, String coordinates) {
    this.name = name;
    this.info = info;
    this.desc = desc;
    this.coordinates = coordinates;
  }

  /**
   * This method gets the name of the location.
   *
   * @return the location name
   */
  public String getName() {
    return name;
  }

  /**
   * This method updates the name of the location
   *
   * @param name an updated location name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This method gets the address information of the location.
   *
   * @return the address information of the location
   */
  public String getInfo() {
    return info;
  }

  /**
   * This method updates the address information of the location.
   *
   * @param info an updated version of address information
   */
  public void setInfo(String info) {
    this.info = info;
  }

  /**
   * This method gets a description of the location.
   *
   * @return the description of the location
   */
  public String getDesc() {
    return desc;
  }

  /**
   * This method updates the description of the location.
   *
   * @param desc an updated description of the location
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }

  /**
   * This method gets the coordinates of the location.
   *
   * @return the locations coordinate
   */
  public String getCoordinates() {
    return coordinates;
  }

  /**
   * This method updates the coordinates of the location.
   *
   * @param coordinates the updated location coordinate
   */
  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }
}
