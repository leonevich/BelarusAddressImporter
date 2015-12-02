package by.auction.car.base.address.importer;


import by.auction.car.base.address.importer.beans.LocationVO;
import by.auction.car.base.address.importer.config.DaoBeansConfiguration;
import by.auction.car.base.address.importer.config.HibernateConfiguration;
import by.auction.car.base.address.importer.dao.remove.RemoveDataService;
import by.auction.car.base.address.importer.dao.local.LocalDataService;
import by.auction.car.base.address.importer.dao.remove.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.LinkedHashMap;
import java.util.List;

public class Load {

    public static final String COUNTRY = "Беларусь";
    public static final String DEFAULT_CODE = "000";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoBeansConfiguration.class, HibernateConfiguration.class);
        RemoveDataService removeDataService = (RemoveDataService) applicationContext.getBean("removeDataService");
        LocalDataService localDataService = (LocalDataService) applicationContext.getBean("sourceDataService");

        List<Prefix> prefixList;
        prefixList = localDataService.getPrefix();
        for (Prefix prefix : prefixList) {
            removeDataService.addPrefix(prefix);
        }

        Country country = new Country();
        country.setName(COUNTRY);
        removeDataService.addCountry(country);

        Region region;
        District district;
        CityFromDistrict cityFromDistrict;
        CityFromRegion cityFromRegion;
        CityFromCountry cityFromCountry;
        SettlementFromDistrict settlementFromDistrict;
        Street street;
        String name;
        String prefix;


        LocationVO locationVO = new LocationVO();
        LinkedHashMap<String, List> regionHashMap = localDataService.getRegion(locationVO);


        //-----------импорт регионов (области)------------------------
        for (String keyRegion : regionHashMap.keySet()) {
            if (!keyRegion.equals("5")) {
                region = new Region();
                name = (String) regionHashMap.get(keyRegion).get(0);
                region.setName(name);
                region.setCountry(country);
                removeDataService.addRegion(region);
                locationVO.setRegionCode(keyRegion);
                LinkedHashMap<String, List> cityRegionHashMap = localDataService.getCityFromRegion(locationVO);

                //-----------импорт городов областного подчинения ---------------------------
                for (String keyCityRegion : cityRegionHashMap.keySet()) {

                    cityFromRegion = new CityFromRegion();
                    name = (String) cityRegionHashMap.get(keyCityRegion).get(0);
                    cityFromRegion.setName(name);
                    prefix = (String) cityRegionHashMap.get(keyCityRegion).get(1);
                    cityFromRegion.setPrefix(removeDataService.getPrefixByName(prefix));
                    cityFromRegion.setRegion(region);
                    removeDataService.addCityFromRegion(cityFromRegion);
                    locationVO.setDistrictCode(keyCityRegion);
                    locationVO.setCityCode("000000");
                    LinkedHashMap<String, List> streetHashMap = localDataService.getStreet(locationVO);

                    //-----импорт улиц для текущего населенного пункта ----------
                    for (String keyStreet : streetHashMap.keySet()) {

                        street = new Street();
                        name = (String) streetHashMap.get(keyStreet).get(0);
                        street.setName(name);
                        prefix = (String) streetHashMap.get(keyStreet).get(1);
                        street.setPrefix(removeDataService.getPrefixByName(prefix));
                        street.setCityFromRegion(cityFromRegion);
                        removeDataService.addStreet(street);
                    }
                }
                //-----------импорт районов------------------------
                locationVO.setRegionCode(keyRegion);
                LinkedHashMap<String, List> districtHashMap = localDataService.getDistrict(locationVO);
                for (String keyDistrict : districtHashMap.keySet()) {

                    district = new District();
                    name = (String) districtHashMap.get(keyDistrict).get(0);
                    district.setName(name);
                    district.setRegion(region);
                    removeDataService.addDistrict(district);

                    locationVO.setDistrictCode(keyDistrict);
                    LinkedHashMap<String, List> cityDistrictHashMap = localDataService.getCityFromDistrict(locationVO);

                    //-----------импорт городов районного подчинения ------------
                    for (String keyCityDistrict : cityDistrictHashMap.keySet()) {
                        cityFromDistrict = new CityFromDistrict();
                        name = (String) cityDistrictHashMap.get(keyCityDistrict).get(0);
                        cityFromDistrict.setName(name);
                        prefix = (String) cityDistrictHashMap.get(keyCityDistrict).get(1);
                        cityFromDistrict.setPrefix(removeDataService.getPrefixByName(prefix));
                        cityFromDistrict.setDistrict(district);
                        removeDataService.addCityFromDistrict(cityFromDistrict);

                        locationVO.setCityCode(keyCityDistrict);
                        LinkedHashMap<String, List> streetHashMap = localDataService.getStreet(locationVO);

                        //-----импорт улиц для текущего населенного пункта ----------
                        for (String keyStreet : streetHashMap.keySet()) {
                            street = new Street();
                            name = (String) streetHashMap.get(keyStreet).get(0);
                            street.setName(name);
                            prefix = (String) streetHashMap.get(keyStreet).get(1);
                            street.setPrefix(removeDataService.getPrefixByName(prefix));
                            street.setCityFromDistrict(cityFromDistrict);
                            removeDataService.addStreet(street);
                        }
                    }
                    locationVO.setDistrictCode(keyDistrict);
                    LinkedHashMap<String, List> settlementDistrictHashMap = localDataService.getSettlementFromDistrict(locationVO);


                    //-----------импорт населенных пунктов районного подчинения ------------
                    for (String keySettlementDistrict : settlementDistrictHashMap.keySet()) {

                        settlementFromDistrict = new SettlementFromDistrict();
                        name = (String) settlementDistrictHashMap.get(keySettlementDistrict).get(0);
                        settlementFromDistrict.setName(name);
                        prefix = (String) settlementDistrictHashMap.get(keySettlementDistrict).get(1);
                        settlementFromDistrict.setPrefix(removeDataService.getPrefixByName(prefix));
                        settlementFromDistrict.setDistrict(district);
                        removeDataService.addSettelementFromDistrict(settlementFromDistrict);

                        locationVO.setCityCode(keySettlementDistrict);
                        LinkedHashMap<String, List> streetHashMap = localDataService.getStreet(locationVO);

                        //-----импорт улиц для текущего населенного пункта ----------
                        for (String keyStreet : streetHashMap.keySet()) {
                            street = new Street();
                            name = (String) streetHashMap.get(keyStreet).get(0);
                            street.setName(name);
                            prefix = (String) streetHashMap.get(keyStreet).get(1);
                            street.setPrefix(removeDataService.getPrefixByName(prefix));
                            street.setSettlementFromDistrict(settlementFromDistrict);
                            removeDataService.addStreet(street);
                        }

                    }
                }
            } else {

                //-----------импорт городов республиканского подчинения (Минск) ------------
                cityFromCountry = new CityFromCountry();
                name = (String) regionHashMap.get(keyRegion).get(0);
                cityFromCountry.setName(name);
                prefix = (String) regionHashMap.get(keyRegion).get(1);
                cityFromCountry.setPrefix(removeDataService.getPrefixByName(prefix));
                cityFromCountry.setCountry(country);
                removeDataService.addCityFromCountry(cityFromCountry);

                locationVO.setRegionCode(keyRegion);
                locationVO.setDistrictCode(DEFAULT_CODE);
                locationVO.setCityCode(DEFAULT_CODE);
                LinkedHashMap<String, List> streetHashMap = localDataService.getStreet(locationVO);

                //-----импорт улиц для текущего населенного пункта ----------
                for (String keyStreet : streetHashMap.keySet()) {
                    street = new Street();
                    name = (String) streetHashMap.get(keyStreet).get(0);
                    street.setName(name);
                    prefix = (String) streetHashMap.get(keyStreet).get(1);
                    street.setPrefix(removeDataService.getPrefixByName(prefix));
                    street.setCityFromCountry(cityFromCountry);
                    removeDataService.addStreet(street);
                }
            }
        }
    }
}