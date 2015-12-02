package by.auction.car.base.address.importer.dao.remove.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STREET")
public class Street implements Serializable {

	private static final long serialVersionUID = -4274525201369347579L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STREET_ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_COUNTRY_ID")
	private CityFromCountry cityFromCountry;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_DISTRICT_ID")
	private CityFromDistrict cityFromDistrict;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_REGION_ID")
	private CityFromRegion cityFromRegion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SETTLEMENT_CITY_DISTRICT_ID")
	private SettlementFromCityFromDistrict settlementFromCityFromDistrict;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SETTLEMENT_CITY_REGION_ID")
	private SettlementFromCityFromRegion settlementFromCityFromRegion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SETTLEMENT_DISTRICT_ID")
	private SettlementFromDistrict settlementFromDistrict;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREFIX_ID")
	private Prefix prefix;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "street")
	private Set<House> streets = new HashSet<House>();
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "street")
	private Set<Address> address = new HashSet<Address>();
	
	public Street() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityFromCountry getCityFromCountry() {
		return cityFromCountry;
	}

	public void setCityFromCountry(CityFromCountry cityFromCountry) {
		this.cityFromCountry = cityFromCountry;
	}

	public CityFromDistrict getCityFromDistrict() {
		return cityFromDistrict;
	}

	public void setCityFromDistrict(CityFromDistrict cityFromDistrict) {
		this.cityFromDistrict = cityFromDistrict;
	}

	public CityFromRegion getCityFromRegion() {
		return cityFromRegion;
	}

	public void setCityFromRegion(CityFromRegion cityFromRegion) {
		this.cityFromRegion = cityFromRegion;
	}

	public SettlementFromCityFromDistrict getSettlementFromCityFromDistrict() {
		return settlementFromCityFromDistrict;
	}

	public void setSettlementFromCityFromDistrict(SettlementFromCityFromDistrict settlementFromCityFromDistrict) {
		this.settlementFromCityFromDistrict = settlementFromCityFromDistrict;
	}

	public SettlementFromCityFromRegion getSettlementFromCityFromRegion() {
		return settlementFromCityFromRegion;
	}

	public void setSettlementFromCityFromRegion(SettlementFromCityFromRegion settlementFromCityFromRegion) {
		this.settlementFromCityFromRegion = settlementFromCityFromRegion;
	}

	public SettlementFromDistrict getSettlementFromDistrict() {
		return settlementFromDistrict;
	}

	public void setSettlementFromDistrict(SettlementFromDistrict settlementFromDistrict) {
		this.settlementFromDistrict = settlementFromDistrict;
	}

	public Prefix getPrefix() {
		return prefix;
	}

	public void setPrefix(Prefix prefix) {
		this.prefix = prefix;
	}

	public Set<House> getStreets() {
		return streets;
	}

	public void setStreets(Set<House> streets) {
		this.streets = streets;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Street street = (Street) o;

		if (id != null ? !id.equals(street.id) : street.id != null) return false;
		if (name != null ? !name.equals(street.name) : street.name != null) return false;
		if (cityFromCountry != null ? !cityFromCountry.equals(street.cityFromCountry) : street.cityFromCountry != null)
			return false;
		if (cityFromDistrict != null ? !cityFromDistrict.equals(street.cityFromDistrict) : street.cityFromDistrict != null)
			return false;
		if (cityFromRegion != null ? !cityFromRegion.equals(street.cityFromRegion) : street.cityFromRegion != null)
			return false;
		if (settlementFromCityFromDistrict != null ? !settlementFromCityFromDistrict.equals(street.settlementFromCityFromDistrict) : street.settlementFromCityFromDistrict != null)
			return false;
		if (settlementFromCityFromRegion != null ? !settlementFromCityFromRegion.equals(street.settlementFromCityFromRegion) : street.settlementFromCityFromRegion != null)
			return false;
		if (settlementFromDistrict != null ? !settlementFromDistrict.equals(street.settlementFromDistrict) : street.settlementFromDistrict != null)
			return false;
		if (prefix != null ? !prefix.equals(street.prefix) : street.prefix != null) return false;
		if (streets != null ? !streets.equals(street.streets) : street.streets != null) return false;
		return !(address != null ? !address.equals(street.address) : street.address != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (cityFromCountry != null ? cityFromCountry.hashCode() : 0);
		result = 31 * result + (cityFromDistrict != null ? cityFromDistrict.hashCode() : 0);
		result = 31 * result + (cityFromRegion != null ? cityFromRegion.hashCode() : 0);
		result = 31 * result + (settlementFromCityFromDistrict != null ? settlementFromCityFromDistrict.hashCode() : 0);
		result = 31 * result + (settlementFromCityFromRegion != null ? settlementFromCityFromRegion.hashCode() : 0);
		result = 31 * result + (settlementFromDistrict != null ? settlementFromDistrict.hashCode() : 0);
		result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
		result = 31 * result + (streets != null ? streets.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Street [id=" + id + ", name=" + name + "]";
	}

}