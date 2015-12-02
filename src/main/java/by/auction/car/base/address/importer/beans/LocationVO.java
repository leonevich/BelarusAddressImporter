package by.auction.car.base.address.importer.beans;

import java.io.Serializable;

public class LocationVO implements Serializable {


	private static final long serialVersionUID = -3435685568064957776L;
	private String countryCode;
	private String regionCode;
	private String districtCode;
	private String cityCode;
	private String streetCode;

	public LocationVO() {
		super();
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		LocationVO that = (LocationVO) o;

		if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
		if (regionCode != null ? !regionCode.equals(that.regionCode) : that.regionCode != null) return false;
		if (districtCode != null ? !districtCode.equals(that.districtCode) : that.districtCode != null) return false;
		if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
		return !(streetCode != null ? !streetCode.equals(that.streetCode) : that.streetCode != null);

	}

	@Override
	public int hashCode() {
		int result = countryCode != null ? countryCode.hashCode() : 0;
		result = 31 * result + (regionCode != null ? regionCode.hashCode() : 0);
		result = 31 * result + (districtCode != null ? districtCode.hashCode() : 0);
		result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
		result = 31 * result + (streetCode != null ? streetCode.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "LocationVO{" +
				"countryCode='" + countryCode + '\'' +
				", regionCode='" + regionCode + '\'' +
				", districtCode='" + districtCode + '\'' +
				", cityCode='" + cityCode + '\'' +
				", streetCode='" + streetCode + '\'' +
				'}';
	}
}
