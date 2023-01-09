package com.example.superheroes.dto;

/**
 * This method stores information on specific a supervillan.
 *
 * @author david
 */
public class Villan {
  private int villanId;

  private String name;
  private String desc;
  private String superpower;

  private int heroId;

  public Villan(int id, String name, String desc, String power, int hero) {
    this.villanId = id;
    this.name = name;
    this.desc = desc;
    this.superpower = power;
    this.heroId = hero;
  }

  public Villan(String name, String desc, String power, int hero) {
    this.name = name;
    this.desc = desc;
    this.superpower = power;
    this.heroId = hero;

  }

  /**
   * This method retrieves the ID of the supervillan.
   *
   * @return the supervillans ID
   */
  public int getVillanID() {
    return villanId;
  }

  /**
   * This method updates the id of the supervillan.
   *
   * @param id the updated supervillan id
   */
  public void setVillanID(int id) {
    this.villanId = id;
  }

  public String getName() { return name; }

  public void setName(String villanName) { this.name = villanName; }

  /**
   * This method gets the description of the supervillan.
   *
   * @return the supervillans description
   */
  public String getDesc() {
    return desc;
  }

  /**
   * This method updates the description of the supervillan.
   *
   * @param desc the updated description of the supervillan
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }

  /**
   * This method gets the superpower of the supervillan.
   *
   * @return the superpower of the supervillan
   */
  public String getSuperPower() {
    return superpower;
  }

  /**
   * This method updates the superpower of the supervillan.
   *
   * @param superpower the updated superpower of the supervillan
   */
  public void setSuperPower(String superpower) {
    this.superpower = superpower;
  }

  /**
   * This method gets the ID of the superhero associated with the supervillan.
   *
   * @return the associated hero's ID
   */
  public int getHeroId() { return heroId; }

  /**
   * This method sets the ID of the superhero associated with the supervillan.
   *
   * @param heroId the associated hero's ID
   */
  public void setHeroId(int heroId) { this.heroId = heroId; }
}
