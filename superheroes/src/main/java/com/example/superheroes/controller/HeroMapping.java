package com.example.superheroes.controller;


import com.example.superheroes.dao.HeroSightingsDAO;
import com.example.superheroes.dto.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This method defines the HTTP requests made by the user involving superheroes.
 *
 * @author david
 */
@Controller
@RequestMapping("/")
public class HeroMapping {


  private HeroSightingsDAO dao;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * This method gets a list of superheroes and renders them on the browser.
   *
   * @param model a Model object used to pass objects into HTML.
   * @return a redirection to a HTML page.
   */
  @GetMapping("/heroes")
  public String getHeroes(Model model) {
    dao = new HeroSightingsDAO(jdbcTemplate);
    List<Hero> hero = dao.getAllHeroes();
    model.addAttribute("heroes", hero);
    return "heroes";
  }

  /**
   * This method add a superhero to the database through a HTML form.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @PostMapping("addHero")
  public String addHero(HttpServletRequest request) {
    Hero hero = new Hero(request.getParameter("name"),
                         request.getParameter("desc"),
                         request.getParameter("superpower"));

    dao.addHero(hero);

    return "redirect:/heroes";
  }


  /**
   * This method edits a specific superhero through a HTML form
   *
   * @param request an object used to parse user input into variables
   * @param model a Model object used to pass objects into HTML.
   * @return a redirection to a HTML page
   */
  @GetMapping("editHero")
  public String editHero(HttpServletRequest request, Model model) {
    int id = Integer.parseInt(request.getParameter("id"));
    Hero hero = dao.getHeroById(id);
    model.addAttribute("hero", hero);

    return "editHero";
  }

  /**
   * This method carries out the update operation in the database on a button click.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @PostMapping("updateHero")
  public String updateHero(HttpServletRequest request) {
    int id = Integer.parseInt(request.getParameter("id"));
    Hero hero = dao.getHeroById(id);

    hero.setName(request.getParameter("name"));
    hero.setDesc(request.getParameter("desc"));
    hero.setSuperPower(request.getParameter("superpower"));

    dao.updateHero(hero);

    return "redirect:/heroes";
  }

  /**
   * This method deletes a superhero in the database on a button click.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @GetMapping("deleteHero")
  public String deleteHero(HttpServletRequest request) {
    int id = Integer.parseInt(request.getParameter("id"));
    dao.deleteHero(id);
    return "redirect:/heroes";
  }
}
