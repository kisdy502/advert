package com.sdt.advert.api;

import com.sdt.advert.bean.City;
import com.sdt.advert.service.CityService;
import com.sdt.advert.utils.IPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/city")
public class CityController {

    private static Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @RequestMapping("/queryAll")
    public List<City> queryAll() {
        List<City> list = cityService.queryAll();
        return list;
    }

    @RequestMapping("/getCityIp")
    public String getIpInfo(HttpServletRequest request, String deviceId) {
        String ip = IPUtils.getIpAddr(request);
        return ip;
    }

    @RequestMapping("/insert")
    public int insertCity() {
        City city = new City();
        city.setName("shenzhen");
        city.setCountryCode("DFC");
        city.setDistrict("Asial");
        city.setPopulation(2000000);
        int rowId = cityService.insert(city);
        return rowId;
    }

    @RequestMapping("/update")
    public int updateCity() {
        List<City> cityList = cityService.queryByName("shenzhen");
        if (cityList != null && cityList.size() > 0) {
            City city = cityList.get(0);
            city.setPopulation(950600);
            int result = cityService.update(city);
            logger.debug("result:" + result);
            return result;
        }
        return 0;
    }

    @RequestMapping("/getCityByName")
    public City getCityByName(@RequestParam(value = "name", required = true) String name) {
        List<City> cityList = cityService.queryByName(name);
        if (cityList != null && cityList.size() > 0) {
            return cityList.get(0);
        }
        return null;
    }


    @RequestMapping("/getCityById/{id}")
    public City getCityById(@PathVariable("id") Integer id) {
        return cityService.queryById(id);
    }

}
