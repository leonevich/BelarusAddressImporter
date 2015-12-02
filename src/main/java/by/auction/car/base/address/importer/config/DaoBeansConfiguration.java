package by.auction.car.base.address.importer.config;


import by.auction.car.base.address.importer.dao.local.base.LocalDataDaoServiceImpl;
import by.auction.car.base.address.importer.dao.local.model.CityBlr;
import by.auction.car.base.address.importer.dao.local.model.StreetBlr;
import by.auction.car.base.address.importer.dao.remove.base.RemoveDataDaoServiceImpl;
import by.auction.car.base.address.importer.dao.remove.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoBeansConfiguration {

    @Bean
    public RemoveDataDaoServiceImpl<Address, Long> addressDao() {
        return new RemoveDataDaoServiceImpl<>(Address.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<Prefix, Long> prefixDao() {
        return new RemoveDataDaoServiceImpl<>(Prefix.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<Country, Long> countryDao() {
        return new RemoveDataDaoServiceImpl<>(Country.class);

    }

    @Bean
    public RemoveDataDaoServiceImpl<Region, Long> regionDao() {
        return new RemoveDataDaoServiceImpl<>(Region.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<District, Long> districtDao() {
        return new RemoveDataDaoServiceImpl<>(District.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<CityFromCountry, Long> cityFromCountryDao() {
        return new RemoveDataDaoServiceImpl<>(CityFromCountry.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<CityFromRegion, Long> cityFromRegionDao() {
        return new RemoveDataDaoServiceImpl<>(CityFromRegion.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<CityFromDistrict, Long> cityFromDistrictDao() {
        return new RemoveDataDaoServiceImpl<>(CityFromDistrict.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<SettlementFromDistrict, Long> settelementFromDistrictDao() {
        return new RemoveDataDaoServiceImpl<>(SettlementFromDistrict.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<SettlementFromCityFromRegion, Long> settelementFromCityFromRegionDao() {
        return new RemoveDataDaoServiceImpl<>(SettlementFromCityFromRegion.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<SettlementFromCityFromDistrict, Long> settelementFromCityFromDistrictDao() {
        return new RemoveDataDaoServiceImpl<>(SettlementFromCityFromDistrict.class);
    }

    @Bean
    public RemoveDataDaoServiceImpl<Street, Long> streetDao() {
        return new RemoveDataDaoServiceImpl<>(Street.class);
    }

    @Bean
    public LocalDataDaoServiceImpl<CityBlr, String> cityBlrDao() {
        return new LocalDataDaoServiceImpl<>(CityBlr.class);
    }

    @Bean
    public LocalDataDaoServiceImpl<StreetBlr, String> streetBlrDao() {
        return new LocalDataDaoServiceImpl<>(StreetBlr.class);
    }
}
