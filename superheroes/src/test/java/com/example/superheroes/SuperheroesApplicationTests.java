package com.example.superheroes;

import com.example.superheroes.dao.HeroSightingsDAO;


import com.example.superheroes.dao.LocationDataDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SuperheroesApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private HeroSightingsDAO dao;
	private LocationDataDAO locationDao;

	@BeforeEach
	public void beforeEach() {
		dao = new HeroSightingsDAO(jdbcTemplate);
		locationDao = new LocationDataDAO(jdbcTemplate);
	}

	@Test
	public void TestGetAllHeroes() { assertDoesNotThrow(() -> dao.getAllHeroes()); }

	@Test
	public void TestGetAllVillans() {
		assertDoesNotThrow(() -> dao.getAllVillans());
	}

	@Test
	public void TestGetAllSightings() {
		assertDoesNotThrow(() -> locationDao.getAllSightings());
	}

	@Test
	public void TestGetAllLocations() { assertDoesNotThrow(() -> locationDao.getAllLocations()); }
}
