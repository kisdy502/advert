package com.sdt.advert.service;

import com.sdt.advert.bean.City;
import com.sdt.advert.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> queryAll() {
        return cityDao.queryAll();
    }

    public int insert(City city) {
        return cityDao.insert(city);
    }

    public int update(City city) {
        return cityDao.update(city);
    }

    public List<City> queryByName(String name) {
        return cityDao.queryByName(name);
    }

    public City queryById(Integer id) {
        return cityDao.queryById(id);
    }
}
