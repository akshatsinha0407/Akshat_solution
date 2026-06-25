package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testSearchContaining();
        testSearchContainingSortedAscending();
        testSearchStartingWith();
    }

    private static void testSearchContaining() {
        LOGGER.info("Start - search containing 'ou'");
        List<Country> countries = countryService.searchCountriesContaining("ou");
        countries.forEach(c -> LOGGER.debug("{} - {}", c.getCode(), c.getName()));
        LOGGER.info("End");
    }

    private static void testSearchContainingSortedAscending() {
        LOGGER.info("Start - search containing 'ou' sorted ascending");
        List<Country> countries = countryService.searchCountriesContainingSortedAscending("ou");
        countries.forEach(c -> LOGGER.debug("{} - {}", c.getCode(), c.getName()));
        LOGGER.info("End");
    }

    private static void testSearchStartingWith() {
        LOGGER.info("Start - search starting with 'Z'");
        List<Country> countries = countryService.searchCountriesStartingWith("Z");
        countries.forEach(c -> LOGGER.debug("{} - {}", c.getCode(), c.getName()));
        LOGGER.info("End");
    }
}
