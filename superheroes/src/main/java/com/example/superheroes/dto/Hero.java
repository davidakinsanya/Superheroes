package com.example.superheroes.dto;

/**
 * This class stores important information on superheroes.
 *
 * @author david
 */
public class Hero {

  private int heroId;
  private String name;
  private String desc;

  private String superpower;

  public Hero(String name, String desc, String power) {
    this.name = name;
    this.desc = desc;
    this.superpower = power;
  }

  public Hero(int hero, String name, String desc, String power) {
    this.heroId = hero;
    this.name = name;
    this.desc = desc;
    this.superpower = power;
  }

  /**
   * This method gets the ID of the superhero.
   *
   * @return the hero's ID
   */
  public int getHeroId() { return heroId; }

  /**
   * This method sets the ID of the superhero.
   *
   * @param heroId the hero's ID
   */
  public void setHeroId(int heroId) { this.heroId = heroId; }

  /**
   * This method retrieves the name of the superhero.
   *
   * @return the superheroes name
   */
  public String getName() {
    return name;
  }

  /**
   * This method updates the name of the superhero.
   *
   * @param name the updated superhero name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This method gets the description of the superhero.
   *
   * @return the superheroes description
   */
  public String getDesc() {
    return desc;
  }

  /**
   * This method updates the description of the superhero.
   *
   * @param desc the updated description of the superhero
   */
  public void setDesc(String desc) {
    this.desc = desc;
  }

  /**
   * This method gets the superpower of the superhero.
   *
   * @return the superpower of the superhero
   */
  public String getSuperPower() {
    return superpower;
  }

  /**
   * This method updates the superpower of the superhero.
   *
   * @param superpower the updated superpower of the superhero
   */
  public void setSuperPower(String superpower) {
    this.superpower = superpower;
  }
}
