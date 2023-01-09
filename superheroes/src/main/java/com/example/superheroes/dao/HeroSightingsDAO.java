package com.example.superheroes.dao;

import com.example.superheroes.dao.mapper.CordinateMapper;
import com.example.superheroes.dao.mapper.HeroMapper;
import com.example.superheroes.dao.mapper.IDMapper;
import com.example.superheroes.dao.mapper.VillanMapper;
import com.example.superheroes.dto.Hero;
import com.example.superheroes.dto.Location;
import com.example.superheroes.dto.Sighting;
import com.example.superheroes.dto.Villan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * This class implements the interactions with the heroSightings database
 * through jdbc template.
 *
 * @author david
 */
public class HeroSightingsDAO implements HeroSightings {

  @Autowired
  private final JdbcTemplate jdbcTemplate;

  public HeroSightingsDAO(JdbcTemplate temp) {
    this.jdbcTemplate = temp;
  }


  /**
   * This method gets all superheroes from the database.
   *
   * @return a list of superheroes from the database
   */
  @Override
  public List<Hero> getAllHeroes() {
    final String sql = "SELECT * FROM Hero";
    return jdbcTemplate.query(sql, new HeroMapper());
  }

  /**
   * This method gets all villans from the database.
   *
   * @return a list of supervillans from the database
   */
  @Override
  public List<Villan> getAllVillans() {
    final String sql = "SELECT * FROM Villan";

    return jdbcTemplate.query(sql, new VillanMapper());
  }

  /**
   * This method gets a specific hero from the database.
   *
   * @param id the ID of the desired hero
   * @return a hero object
   */
  @Override
  public Hero getHeroById(int id) {
    final String sql = "SELECT * FROM Hero WHERE HeroId = " + id;
    return jdbcTemplate.queryForObject(sql, new HeroMapper());
  }

  /**
   * This method gets a specific villan from the database.
   *
   * @param id the ID of the desired villan
   * @return a villan object
   */
  @Override
  public Villan getVillanById(int id) {
    final String sql = "SELECT * FROM Villan WHERE VillanId = " + id;
    return jdbcTemplate.queryForObject(sql, new VillanMapper());
  }

  /**
   * This method adds a superhero to the database.
   *
   * @param hero a Hero object
   * @return whether the database update was successful
   */
  @Override
  public boolean addHero(Hero hero) {
    final String sql = "INSERT INTO Hero (heroName, heroDesc, superpower)" +
            "VALUES (?,?,?)";

    return jdbcTemplate.update(sql, hero.getName(),
            hero.getDesc(),
            hero.getSuperPower()) > 0;
  }

  /**
   * This method adds a supervillan to the database.
   *
   * @param villan a Villan object
   * @return whether the database update was successful
   */
  @Override
  public boolean addVillan(Villan villan) {
    final String sql = "INSERT INTO Villan (villanName, villanDesc, superpower, heroId) " +
            "VALUES (?,?,?,?)";

    return jdbcTemplate.update(sql, villan.getName(),
            villan.getDesc(),
            villan.getSuperPower(),
            villan.getHeroId()) > 0;
  }

  /**
   * This method gets all the superhero IDs.
   *
   * @return a list of all superhero IDs
   */
  @Override
  public List<Integer> getHeroIDs() {
    final String sql = "SELECT heroId FROM Hero";
    return jdbcTemplate.query(sql, new IDMapper());
  }

  /**
   * This method updates a specific villan in the database.
   *
   * @param villan a villan object
   * @return whether the update was successful.
   */
  @Override
  public boolean updateVillan(Villan villan) {
    final String sql = "UPDATE Villan " +
            "SET villanName = ?, " +
            "villanDesc = ?, " +
            "superpower = ?, " +
            "heroId = ? " +
            "WHERE villanId = ?";

    return jdbcTemplate.update(sql,
            villan.getName(),
            villan.getDesc(),
            villan.getSuperPower(),
            villan.getHeroId(),
            villan.getVillanID()) > 0;
  }

  /**
   * This method updates a specific hero in the database.
   *
   * @param hero a hero object
   * @return whether the update was successful
   */
  @Override
  public boolean updateHero(Hero hero) {
    final String sql = "UPDATE Hero " +
            "SET heroName = ?, " +
            "heroDesc = ?, " +
            "superpower = ? " +
            "WHERE heroId = ?";

    return jdbcTemplate.update(sql, hero.getName(),
            hero.getDesc(),
            hero.getSuperPower(),
            hero.getHeroId()) > 0;
  }

  /**
   * This method deletes a specific hero in the database.
   *
   * @param id the ID of the hero to be deleted
   * @return whether the database update was successful
   */
  @Override
  public boolean deleteHero(int id) {
    final String sql = "DELETE FROM Hero WHERE heroId = ?";

    return jdbcTemplate.update(sql, id) > 0;
  }

  /**
   * This method deletes a specific villan in the database.
   *
   * @param id the ID of the villan to be deleted
   * @return whether the database update was successful
   */
  @Override
  public boolean deleteVillan(int id) {
    final String sql = "DELETE FROM Villan WHERE villanId = ?";
    return jdbcTemplate.update(sql, id) > 0;
  }
}
