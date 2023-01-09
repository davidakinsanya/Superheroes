package com.example.superheroes.controller;


import com.example.superheroes.dao.LocationDataDAO;
import com.example.superheroes.dto.Location;
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
 * This method defines the HTTP requests made by the user involving locations.
 *
 * @author david
 */
@Controller
@RequestMapping("/")
public class LocationMapping {


  private LocationDataDAO dao;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * This method gets a list of locations and renders them on the browser.
   *
   * @param model a Model object used to pass objects into HTML.
   * @return a redirection to a HTML page.
   */
  @GetMapping("/locations")
  public String getLocations(Model model) {
    dao = new LocationDataDAO(jdbcTemplate);
    List<Location> locations = dao.getAllLocations();
    model.addAttribute("locations", locations);
    return "locations";
  }

  /**
   * This method add a location to the database through a HTML form.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @PostMapping("addLocation")
  public String addLocation(HttpServletRequest request) {
    String coordinate = request.getParameter("coordinates");

    if (!dao.getCoordinates().contains(coordinate)) {
      Location location = new Location(
              request.getParameter("name"),
              request.getParameter("info"),
              request.getParameter("desc"),
              coordinate);

      dao.addLocation(location);
    }

    return "redirect:/locations";
  }

  /**
   * This method edits a specific location through a HTML form
   *
   * @param request an object used to parse user input into variables
   * @param model a Model object used to pass objects into HTML.
   * @return a redirection to a HTML page
   */
  @GetMapping("editLocation")
  public String editLocation(HttpServletRequest request, Model model) {
    String id = request.getParameter("id");
    Location location = dao.getLocationById(id);
    model.addAttribute("location", location);

    return "editLocation";
  }

  /**
   * This method carries out the update operation in the database on a button click.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @PostMapping("updateLocation")
  public String updateLocation(HttpServletRequest request) {
    String id = request.getParameter("id");
    Location location = dao.getLocationById(id);

    location.setName(request.getParameter("name"));
    location.setInfo(request.getParameter("info"));
    location.setDesc(request.getParameter("desc"));

    dao.updateLocation(location);
    return "redirect:/locations";
  }

  /**
   * This method deletes a location in the database on a button click.
   *
   * @param request an object used to parse user input into variables
   * @return a redirection to a HTML page
   */
  @GetMapping("deleteLocation")
  public String deleteLocation(HttpServletRequest request) {
    String id = request.getParameter("id");
    dao.deleteLocation(id);
    return "redirect:/locations";
  }
}
