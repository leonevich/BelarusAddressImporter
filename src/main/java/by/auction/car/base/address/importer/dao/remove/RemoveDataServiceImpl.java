package by.auction.car.base.address.importer.dao.remove;

import java.util.List;

import by.auction.car.base.address.importer.dao.DataDaoService;
import by.auction.car.base.address.importer.dao.remove.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("removeDataService")
@Transactional(value = "removeTransactionManager")
public class RemoveDataServiceImpl implements RemoveDataService {

    @Autowired
    private DataDaoService<Region, Long> regionDao;

    @Autowired
    private DataDaoService<Prefix, Long> prefixDao;

    @Autowired
    private DataDaoService<District, Long> districtDao;

    @Autowired
    private DataDaoService<CityFromCountry, Long> cityFromCountryDao;

    @Autowired
    private DataDaoService<CityFromDistrict, Long> cityFromDistrictDao;

    @Autowired
    private DataDaoService<CityFromRegion, Long> cityFromRegionDao;

    @Autowired
    private DataDaoService<SettlementFromDistrict, Long> settelementFromDistrictDao;

    @Autowired
    private DataDaoService<Country, Long> countryDao;

    @Autowired
    private DataDaoService<Street, Long> streetDao;

    public RemoveDataServiceImpl() {
        super();
    }

    @Override
    public void addCountry(Country country) {
        countryDao.add(country);
    }

    @Override
    public void addPrefix(Prefix prefix) {
        prefixDao.add(prefix);
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Override
    public Prefix getPrefixByName(String name) {
        String hql = "FROM Prefix p WHERE p.name=:name";
        Query query = prefixDao.getQuery(hql);
        query.setParameter("name", name);
        Prefix prefix = (Prefix) query.uniqueResult();
        return prefix;
    }

    @Override
    public Session getSession() {
        return regionDao.getSession();
    }

    @Override
    public List<Region> getRegion() {
        return regionDao.getAll();
    }

    @Override
    public void addRegion(Region region) {
        regionDao.add(region);

    }

    @Override
    public List<District> getDistrict() {
        return districtDao.getAll();
    }

    @Override
    public void addDistrict(District district) {
        districtDao.add(district);
    }

    @Override
    public List<CityFromCountry> getCityFromCountry() {
        return cityFromCountryDao.getAll();
    }

    @Override
    public void addCityFromCountry(CityFromCountry cityFromCountry) {
        cityFromCountryDao.add(cityFromCountry);
    }

    @Override
    public List<CityFromDistrict> getCityFromDistrict() {
        return cityFromDistrictDao.getAll();
    }

    @Override
    public void addCityFromDistrict(CityFromDistrict cityFromDistrict) {
        cityFromDistrictDao.add(cityFromDistrict);
    }

    @Override
    public List<CityFromRegion> getCityFromRegion() {
        return cityFromRegionDao.getAll();
    }

    @Override
    public void addCityFromRegion(CityFromRegion cityFromRegion) {
        cityFromRegionDao.add(cityFromRegion);
    }

    @Override
    public List<Street> getStreet() {
        return streetDao.getAll();
    }

    @Override
    public void addStreet(Street street) {
        streetDao.add(street);
    }

    @Override
    public List<SettlementFromDistrict> getSettelementFromDistrict() {
        return settelementFromDistrictDao.getAll();
    }

    @Override
    public void addSettelementFromDistrict(SettlementFromDistrict settlementFromDistrict) {
        settelementFromDistrictDao.add(settlementFromDistrict);
    }

    @Override
    public List<Country> getCountry() {
        List<Country> countries;
        countries = countryDao.getAll();
        return countries;
    }
}
