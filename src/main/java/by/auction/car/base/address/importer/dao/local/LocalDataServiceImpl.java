package by.auction.car.base.address.importer.dao.local;

import java.util.*;

import by.auction.car.base.address.importer.beans.LocationVO;
import by.auction.car.base.address.importer.dao.DataDaoService;
import by.auction.car.base.address.importer.dao.local.model.CityBlr;
import by.auction.car.base.address.importer.dao.local.model.StreetBlr;
import by.auction.car.base.address.importer.dao.remove.model.Prefix;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Leonid.Ivashkevich
 **/

@Service("sourceDataService")
@Transactional("localTransactionManager")
public class LocalDataServiceImpl implements LocalDataService {
    public static final String GET_CITY_PREFIX_HQL = "select distinct c.pref as name from CityBlr c where c.pref is not null";
    public static final String GET_STREET_PREFIX_HQL = "select distinct s.pref as name from StreetBlr s where s.pref is not null";

    public static final String CITY_REGION_REGEXP = "4__000000";
    public static final String GET_CITY_REGION_HQL = "FROM CityBlr c WHERE str(c.code) like:regexp";
    public static final int CITY_REGION_CODE_LENGTH = 3;
    public static final int REGION_CODE_LENGTH = 1;
    public static final String REGION_REGEXP = "_000000000";
    public static final String GET_CAPITAL_REGEXP = "_000000000";
    public static final String GET_CAPITAL_HQL = "FROM CityBlr c WHERE str(c.code) like:regexp";
    public static final String REGEXP_PARAMETER = "regexp";
    public static final String GET_DISTRICT_REGEXP = "%";
    public static final String GET_DISTRICT_HQL = "FROM CityBlr c WHERE str(c.code) like:regexp";
    public static final String GET_CITY_FROM_DISTRICT_REGEXP = "___000";
    public static final String GET_CITY_FROM_DISTRICT_HQL = "FROM CityBlr c WHERE str(c.code) like:regexp";
    public static final String GET_SETTLEMENT_FROM_DISTRICT_REGEXP = "%";
    public static final String GET_SETTLEMENT_FROM_DISTRICT_HQL = "FROM CityBlr c WHERE str(c.code) like:regexp";
    public static final String GET_STREET_REGEXP = "%";
    public static final String GET_STREET_HQL = "FROM StreetBlr s WHERE str(s.code) like:regexp";

    @Autowired
    private DataDaoService<StreetBlr, String> streetBlrDao;

    @Autowired
    private DataDaoService<CityBlr, String> cityBlrDao;

    @Autowired
    Environment location_data;

    @SuppressWarnings("unchecked")
    @Override
    public LinkedHashMap<String, List> getRegion(LocationVO locationVO) {


        LinkedHashMap<String, List> locations = new LinkedHashMap();
        List<CityBlr> cityBlrList;
        int startIndex = 0;
        int endIndex = startIndex + REGION_CODE_LENGTH;
        String regexp = REGION_REGEXP;
        String hql = "FROM CityBlr c WHERE str(c.code) like:regexp";

        Query query = cityBlrDao.getQuery(hql);
        query.setParameter(REGEXP_PARAMETER, regexp);
        cityBlrList = query.list();
        for (CityBlr result : cityBlrList) {
            List locationDataList = new ArrayList<>();
            locationDataList.add(result.getName());
            locationDataList.add(result.getPref());
            locations.put(result.getCode().substring(startIndex, endIndex), locationDataList);
        }
        regexp = "_______000";
        hql = "FROM CityBlr c WHERE str(c.code) like:regexp and c.region is not null";
        query = cityBlrDao.getQuery(hql);
        query.setParameter(REGEXP_PARAMETER, regexp);
        cityBlrList = query.list();
        for (CityBlr result : cityBlrList) {
            List locationDataList = new ArrayList<>();
            locationDataList.add(result.getRegion());
            locations.put(result.getCode().substring(startIndex, endIndex), locationDataList);
        }

        return locations;
    }

    @SuppressWarnings("unchecked")
    @Override
    public LinkedHashMap<String, List> getCapital() {
        LinkedHashMap<String, List> locations = new LinkedHashMap();
        List<CityBlr> cityBlrList;
        int startIndex = 0;
        int endIndex = startIndex + 1;
        String regexp = GET_CAPITAL_REGEXP;
        String hql = GET_CAPITAL_HQL;

        Query query = cityBlrDao.getQuery(hql);
        query.setParameter(REGEXP_PARAMETER, regexp);
        cityBlrList = query.list();
        for (CityBlr result : cityBlrList) {
            List locationDataList = new ArrayList<>();
            locationDataList.add(result.getName());
            locationDataList.add(result.getPref());
            locations.put(result.getCode().substring(startIndex, endIndex), locationDataList);
        }

        return locations;
    }


    @SuppressWarnings("unchecked")
    @Override
    public LinkedHashMap<String, List> getDistrict(LocationVO locationVO) {
        LinkedHashMap<String, List> locations = new LinkedHashMap();
        List<CityBlr> cityBlrList;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locationVO.getRegionCode());
        int startIndex = stringBuilder.length();
        int endIndex = startIndex + 3;
        stringBuilder.append(GET_DISTRICT_REGEXP);
        String hql = GET_DISTRICT_HQL;
        String regexp = stringBuilder.toString();

        Query query = cityBlrDao.getQuery(hql);
        query.setParameter(REGEXP_PARAMETER, regexp);
        cityBlrList = query.list();
        for (CityBlr result : cityBlrList) {
            if (result.getDistrict() == null
                    && !locations.containsKey(result.getCode().substring(startIndex, endIndex))) {
                continue;
            }
            if (result.getDistrict() != null) {
                List locationDataList = new ArrayList<>();
                locationDataList.add(result.getDistrict());
                locations.put(result.getCode().substring(startIndex, endIndex), locationDataList);
            }
        }

        return locations;
    }

    @SuppressWarnings("unchecked")
    @Override
    public LinkedHashMap<String, List> getCityFromRegion(LocationVO locationVO) {
        LinkedHashMap<String, List> locations = new LinkedHashMap();
        List<CityBlr> cityBlrList;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locationVO.getRegionCode());
        int startIndex = stringBuilder.length();
        int endIndex = startIndex + CITY_REGION_CODE_LENGTH;
        stringBuilder.append(CITY_REGION_REGEXP);
        String hql = GET_CITY_REGION_HQL;
        String regexp = stringBuilder.toString();

        Query query = cityBlrDao.getQuery(hql);
        query.setParameter(REGEXP_PARAMETER, regexp);
        cityBlrList = query.list();
        for (CityBlr result : cityBlrList) {
            List locationDataList = new ArrayList<>();
            locationDataList.add(result.getName());
            locationDataList.add(result.getPref());
            locations.put(result.getCode().substring(startIndex, endIndex), locationDataList);
        }

        return locations;
    }

    @SuppressWarnings("unchecked")
    @Override
    public LinkedHashMap<String, List> getCityFromDistrict(LocationVO locationVO) {
        LinkedHashMap<String, List> locations = new LinkedHashMap();
        List<CityBlr> cityBlrList;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locationVO.getRegionCode());
        stringBuilder.append(locationVO.getDistrictCode());
        int startIndex = stringBuilder.length();
        int endIndex = startIndex + 6;
        stringBuilder.append(GET_CITY_FROM_DISTRICT_REGEXP);
        String hql = GET_CITY_FROM_DISTRICT_HQL;
        String regexp = stringBuilder.toString();

        Query query = cityBlrDao.getQuery(hql);
        query.setParameter(REGEXP_PARAMETER, regexp);
        cityBlrList = query.list();
        for (CityBlr result : cityBlrList) {
            if (result.getRegion() == null) {
                continue;
            }
            if (Integer.parseInt(result.getCode().substring(startIndex, endIndex)) < 520000 || result.getDistrict() == null) {
                List locationDataList = new ArrayList<>();
                locationDataList.add(result.getName());
                locationDataList.add(result.getPref());
                locations.put(result.getCode().substring(startIndex, endIndex), locationDataList);
            }
        }

        return locations;
    }

    @SuppressWarnings("unchecked")
    @Override
    public LinkedHashMap<String, List> getSettlementFromDistrict(LocationVO locationVO) {
        LinkedHashMap<String, List> locations = new LinkedHashMap();
        List<CityBlr> cityBlrList;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locationVO.getRegionCode());
        stringBuilder.append(locationVO.getDistrictCode());
        int startIndex = stringBuilder.length();
        int endIndex = startIndex + 6;
        stringBuilder.append(GET_SETTLEMENT_FROM_DISTRICT_REGEXP);
        String hql = GET_SETTLEMENT_FROM_DISTRICT_HQL;
        String regexp = stringBuilder.toString();

        Query query = cityBlrDao.getQuery(hql);
        query.setParameter(REGEXP_PARAMETER, regexp);
        cityBlrList = query.list();
        for (CityBlr result : cityBlrList) {
            if (result.getDistrict() == null || Integer.parseInt(result.getCode().substring(startIndex, endIndex)) < 520000) {
                continue;
            }
            List locationDataList = new ArrayList<>();
            locationDataList.add(result.getName());
            locationDataList.add(result.getPref());
            locations.put(result.getCode().substring(startIndex, endIndex), locationDataList);
        }

        return locations;
    }

    @SuppressWarnings("unchecked")
    @Override
    public LinkedHashMap<String, List> getStreet(LocationVO locationVO) {
        LinkedHashMap<String, List> locations = new LinkedHashMap();
        List<StreetBlr> streetBlrList;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locationVO.getRegionCode());
        stringBuilder.append(locationVO.getDistrictCode());
        stringBuilder.append(locationVO.getCityCode());
        int startIndex = stringBuilder.length();
        stringBuilder.append(GET_STREET_REGEXP);
        String hql = GET_STREET_HQL;
        String regexp = stringBuilder.toString();

        Query query = streetBlrDao.getQuery(hql);
        query.setParameter(REGEXP_PARAMETER, regexp);
        streetBlrList = query.list();
        for (StreetBlr result : streetBlrList) {
            List locationDataList = new ArrayList<>();
            locationDataList.add(result.getName());
            locationDataList.add(result.getPref());
            locations.put(result.getCode().substring(startIndex), locationDataList);
        }
        return locations;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Prefix> getPrefix() {
        List<Prefix> resultPrefixList = new ArrayList<>();
        List<Prefix> prefixCityList;
        List<Prefix> prefixStreetList;

        Query query = cityBlrDao.getQuery(GET_CITY_PREFIX_HQL);
        prefixCityList = query.setResultTransformer(Transformers.aliasToBean(Prefix.class)).list();
        query = streetBlrDao.getQuery(GET_STREET_PREFIX_HQL);
        prefixStreetList = query.setResultTransformer(Transformers.aliasToBean(Prefix.class)).list();
        resultPrefixList.addAll(prefixCityList);
        resultPrefixList.addAll(prefixStreetList);
        return resultPrefixList;
    }
}
