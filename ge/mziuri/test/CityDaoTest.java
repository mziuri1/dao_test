
package ge.mziuri.test;

import ge.mziuri.daotest.dao.CityDAO;
import ge.mziuri.daotest.dao.CityDAOImpl;
import ge.mziuri.daotest.model.City;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CityDaoTest {
    
    CityDAO cityDAO;
    
    @Before
    public void init() {
       cityDAO = new CityDAOImpl();
    }
    
    @Test
    public void testAddCity() {
        City city = new City(0, "თბილისი", 1_108_000, true, 1);
        cityDAO.addCity(city);
        List<City> cityList = cityDAO.getCityByName("თბილისი");
        Assert.assertEquals(1, cityList.size());
        Assert.assertEquals(city, cityList.get(0));
        cityDAO.deleteCity(cityList.get(0).getId());
    }
    
}
