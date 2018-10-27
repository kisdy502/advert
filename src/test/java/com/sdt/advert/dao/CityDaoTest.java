package com.sdt.advert.dao;

import com.sdt.advert.AdvertApplication;
import com.sdt.advert.bean.City;
import com.sdt.advert.api.CityController;
import com.sdt.advert.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(AdvertApplication.class)
public class CityDaoTest {
    private static Logger logger = LoggerFactory.getLogger(CityController.class);


    @Autowired
    private CityService cityService;

    @Test
    public void queryAll() {
    }

    @Test
    public void insert() {
        City city = new City();
        city.setName("武汉");
        city.setCountryCode("DF7");
        city.setDistrict("Asial");
        city.setPopulation(20000000);

        try {
            int rowId = cityService.insert(city);
            logger.debug("rowId:" + rowId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}