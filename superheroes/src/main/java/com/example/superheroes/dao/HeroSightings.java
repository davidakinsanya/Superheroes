package com.example.superheroes.dao;

import com.example.superheroes.dto.Hero;
import com.example.superheroes.dto.Location;
import com.example.superheroes.dto.Sighting;
import com.example.superheroes.dto.Villan;

import java.util.List;

/**
 * This interface outlines the database interactions of the Superhero Sighting application.
 *
 * @author david
 */
public interface HeroSightings {

  /**
   * This method gets all superheroes from the database.
   *
   * @return a list of superheroes from the database
   */
  List<Hero> getAllHeroes();

  /**
   * This method gets all villans from the database.
   *
   * @return a list of supervillans from the database
   */
  List<Villan> getAllVillans();


  /**
   * This method gets a specific hero from the database.
   *
   * @param id the ID of the desired hero
   * @return a hero object
   */
  Hero getHeroById(int id);

  /**
   * This method gets a specific villan from the database.
   *
   * @param id the ID of the desired villan
   * @return a villan object
   */
  Villan getVillanById(int id);

  /**
   * This method adds a superhero to the database.
   *
   * @return whether the database update was successful
   */
  boolean addHero(Hero hero);

  /**
   * This method adds a supervillan to the database.
   *
   * @return whether the database update was successful
   */
  boolean addVillan(Villan villan);

  /**
   * This method gets all the superhero IDs.
   *
   * @return a list of all superhero IDs
   */
  List<Integer> getHeroIDs();

  /**
   * This method updates a specific villan in the database.
   *
   * @param villan a villan object
   * @return whether the update was successful.
   */
  public boolean updateVillan(Villan villan);

  /**
   * This method updates a specific hero in the database.
   *
   * @param hero a hero object
   * @return whether the update was successful
   */
  public boolean updateHero(Hero hero);

  /**
   * This method deletes a specific hero in the database.
   *
   * @param id the ID of the hero to be deleted
   * @return whether the database update was successful
   */
  public boolean deleteHero(int id);

  /**
   * This method deletes a specific villan in the database.
   *
   * @param id the ID of the villan to be deleted
   * @return whether the database update was successful
   */
  public boolean deleteVillan(int id);

}
