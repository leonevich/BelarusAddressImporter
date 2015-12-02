package by.auction.car.base.address.importer.dao.remove;

import java.util.List;


import by.auction.car.base.address.importer.dao.remove.model.*;
import org.hibernate.Session;

public interface RemoveDataService {

	List<Country> getCountry();

	void addPrefix(Prefix prefix);

	void addCountry(Country country);

	Prefix getPrefixByName(String name);

	Session getSession();

	List<Region> getRegion();

	void addRegion(Region region);

	List<District> getDistrict();

	void addDistrict(District district);

	List<CityFromCountry> getCityFromCountry();

	void addCityFromCountry(CityFromCountry cityFromCountry);

	List<CityFromDistrict> getCityFromDistrict();

	void addCityFromDistrict(CityFromDistrict cityFromDistrict);

	List<CityFromRegion> getCityFromRegion();

	void addCityFromRegion(CityFromRegion cityFromRegion);

	List<Street> getStreet();

	void addStreet(Street street);

	List<SettlementFromDistrict> getSettelementFromDistrict();

	void addSettelementFromDistrict(SettlementFromDistrict settlementFromDistrict);
}

