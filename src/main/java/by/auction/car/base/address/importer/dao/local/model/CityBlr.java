package by.auction.car.base.address.importer.dao.local.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CITY_BLR")
public class CityBlr implements Serializable{


	private static final long serialVersionUID = -7747522677712818542L;
	@Id
	@Column(name = "CODE")
	private String code;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PREF")
	private String pref;
	@Column(name = "REGION")
	private String region;
	@Column(name = "DISTRICT")
	private String district;
	
	public CityBlr() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPref() {
		return pref;
	}

	public void setPref(String pref) {
		this.pref = pref;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CityBlr cityBlr = (CityBlr) o;

		if (code != null ? !code.equals(cityBlr.code) : cityBlr.code != null) return false;
		if (name != null ? !name.equals(cityBlr.name) : cityBlr.name != null) return false;
		if (pref != null ? !pref.equals(cityBlr.pref) : cityBlr.pref != null) return false;
		if (region != null ? !region.equals(cityBlr.region) : cityBlr.region != null) return false;
		return !(district != null ? !district.equals(cityBlr.district) : cityBlr.district != null);

	}

	@Override
	public int hashCode() {
		int result = code != null ? code.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (pref != null ? pref.hashCode() : 0);
		result = 31 * result + (region != null ? region.hashCode() : 0);
		result = 31 * result + (district != null ? district.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CityBlr [code=" + code + ", name=" + name + ", pref=" + pref + ", region=" + region + ", district="
				+ district + "]";
	}
	
}
