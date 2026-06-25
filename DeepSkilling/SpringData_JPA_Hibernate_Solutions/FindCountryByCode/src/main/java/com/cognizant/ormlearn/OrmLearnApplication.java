package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        seedCountries();
        testFindCountryByCode();
        testFindCountryByCodeNotFound();
    }

    private static void seedCountries() {
        countryService.addCountry(new Country("IN", "India"));
        countryService.addCountry(new Country("US", "United States of America"));
        countryService.addCountry(new Country("FR", "France"));
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country:{}", country);
        LOGGER.info("End");
    }

    private static void testFindCountryByCodeNotFound() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Exception caught as expected: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
}
