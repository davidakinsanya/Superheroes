package com.example.superheroes.controller;


import com.example.superheroes.dao.HeroSightingsDAO;
import com.example.superheroes.dao.LocationDataDAO;
import com.example.superheroes.dto.Sighting;
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
 * This method defines the HTTP requests made by the user involving sightings.
 *
 * @author david
 */
@Controller
@RequestMapping("/")
public class SightingMapping {


  private LocationDataDAO dao;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * This method gets a list of sightings and renders them on the browser.
   *
   * @param model a Model object used to pass objects into HTML.
   * @return a redirection to a HTML page.
   */
  @GetMapping("/sightings")
  public String getSightings(Model model) {
    dao = new LocationDataDAO(jdbcTemplate);
    List<Sighting> sightings = dao.getAllSightings();
    model.addAttribute("sightings", sightings);
    return "sightings";
  }

  /**
   * This method add a sighting to the database through a HTML form.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @PostMapping("addSighting")
  public String addSighting(HttpServletRequest request, Model model) {
    String coordinate = request.getParameter("coordinates");
    int id = Integer.parseInt(request.getParameter("heroId"));
    HeroSightingsDAO heroDao = new HeroSightingsDAO(jdbcTemplate);

    if (!dao.getCoordinates().contains(coordinate)) {
      model.addAttribute("coordinate", coordinate);
      return "redirect:/locations";
    } else if (!heroDao.getHeroIDs().contains(id)) {
      return "redirect:/heroes";
    }

    Sighting sighting = new Sighting(
            Integer.parseInt(request.getParameter("heroId")),
            request.getParameter("sightingDate"),
            request.getParameter("coordinates")
    );

    dao.addSighting(sighting);

    return "redirect:/sightings";
  }

  /**
   * This method edits a specific sighting through a HTML form
   *
   * @param request an object used to parse user input into variables
   * @param model a Model object used to pass objects into HTML.
   * @return a redirection to a HTML page
   */
  @GetMapping("editSighting")
  public String editSighting(HttpServletRequest request, Model model) {
    int id = Integer.parseInt(request.getParameter("id"));
    Sighting sighting = dao.getSightingById(id);
    model.addAttribute("sighting", sighting);
    return "editSighting";
  }

  /**
   * This method carries out the update operation in the database on a button click.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @PostMapping("updateSighting")
  public String updateSighting(HttpServletRequest request) {
    int id = Integer.parseInt(request.getParameter("id"));
    Sighting sighting = dao.getSightingById(id);

    sighting.setSightingDate(request.getParameter("sightingDate"));
    sighting.setCoordinates(request.getParameter("coordinates"));
    sighting.setHeroId(Integer.parseInt(request.getParameter("heroId")));
    dao.updateSighting(sighting);

    return "redirect:/sightings";
  }

  /**
   * This method deletes a sighting in the database on a button click.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @GetMapping("deleteSighting")
  public String deleteSighting(HttpServletRequest request) {
    int id = Integer.parseInt(request.getParameter("id"));
    dao.deleteSighting(id);
    return "redirect:/sightings";
  }
}
