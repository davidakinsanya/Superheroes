package com.example.superheroes.controller;


import com.example.superheroes.dao.HeroSightingsDAO;
import com.example.superheroes.dto.Villan;
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
 * This method defines the HTTP requests made by the user involving supervillans.
 *
 * @author david
 */
@Controller
@RequestMapping("/")
public class VillanMapping {


  private HeroSightingsDAO dao;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * This method gets a list of supervillans and renders them on the browser.
   *
   * @param model a Model object used to pass objects into HTML.
   * @return a redirection to a HTML page.
   */
  @GetMapping("/villans")
  public String getHeroes(Model model) {
    dao = new HeroSightingsDAO(jdbcTemplate);
    List<Villan> villan = dao.getAllVillans();
    model.addAttribute("villans", villan);
    return "villans";
  }

  /**
   * This method add a supervillan to the database through a HTML form.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @PostMapping("addVillan")
  public String addVillan(HttpServletRequest request) {
    int heroId = Integer.parseInt(request.getParameter("heroId"));

    if (!dao.getHeroIDs().contains(heroId)) return "redirect:/heroes";

    Villan villan = new Villan(request.getParameter("name"),
            request.getParameter("desc"),
            request.getParameter("superpower"),
            heroId);


    dao.addVillan(villan);

    return "redirect:/villans";
  }

  /**
   * This method edits a specific supervillan through a HTML form
   *
   * @param request an object used to parse user input into variables
   * @param model a Model object used to pass objects into HTML.
   * @return a redirection to a HTML page
   */
  @GetMapping("editVillan")
  public String editVillan(HttpServletRequest request, Model model) {
    int id = Integer.parseInt(request.getParameter("id"));
    Villan villan = dao.getVillanById(id);
    model.addAttribute("villan", villan);

    return "editVillan";
  }

  /**
   * This method carries out the update operation in the database on a button click.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @PostMapping("updateVillan")
  public String updateVillan(HttpServletRequest request, Model model) {
    int id = Integer.parseInt(request.getParameter("id"));
    Villan villan = dao.getVillanById(id);

    villan.setName(request.getParameter("name"));
    villan.setDesc(request.getParameter("desc"));
    villan.setSuperPower(request.getParameter("superpower"));

    dao.updateVillan(villan);

    return "redirect:/villans";
  }

  /**
   * This method deletes a supervillan in the database on a button click.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @GetMapping("deleteVillan")
  public String deleteVillan(HttpServletRequest request) {
    int id = Integer.parseInt(request.getParameter("id"));
    Villan villan = dao.getVillanById(id);
    dao.deleteVillan(villan.getVillanID());

    return "redirect:/villans";
  }
}