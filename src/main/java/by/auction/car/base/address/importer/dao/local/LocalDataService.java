package by.auction.car.base.address.importer.dao.local;

import by.auction.car.base.address.importer.beans.LocationVO;
import by.auction.car.base.address.importer.dao.remove.model.Prefix;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Leonid.Ivashkevich
 */
public interface LocalDataService {

	LinkedHashMap<String, List> getRegion(LocationVO locationVO);

	LinkedHashMap<String, List> getCapital();

	LinkedHashMap<String, List> getDistrict(LocationVO locationVO);

	LinkedHashMap<String, List> getCityFromRegion(LocationVO locationVO);

	LinkedHashMap<String, List> getCityFromDistrict(LocationVO locationVO);

	LinkedHashMap<String, List> getSettlementFromDistrict(LocationVO locationVO);

	LinkedHashMap<String, List> getStreet(LocationVO locationVO);

	List<Prefix> getPrefix();
}
