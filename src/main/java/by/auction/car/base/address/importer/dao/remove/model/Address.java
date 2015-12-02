package by.auction.car.base.address.importer.dao.remove.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 7885237269546989169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private Long id;
    
	@Column(name = "HOUSE")
	private String house;

	@Column(name = "HOUSING")
	private String housing;

	@Column(name = "FLAT")
	private String flat;

	@Column(name = "ROOM")
	private String room;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "REGION_ID")
	private Region region;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_COUNTRY_ID")
	private CityFromCountry cityFromCountry;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_DISTRICT_ID")
	private CityFromDistrict cityFromDistrict;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_REGION_ID")
	private CityFromRegion cityFromRegion;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SETTLEMENT_CITY_DISTRICT_ID")
	private SettlementFromCityFromDistrict settlementFromCityFromDistrict;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SETTLEMENT_CITY_REGION_ID")
	private SettlementFromCityFromRegion settlementFromCityFromRegion;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SETTLEMENT_DISTRICT_ID")
	private SettlementFromDistrict settlementFromDistrict;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID")
	private District district;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "STREET_ID")
	private Street street;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")
	private Set<User> users = new HashSet<>(0);

	public Address(){
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getHousing() {
		return housing;
	}

	public void setHousing(String housing) {
		this.housing = housing;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flat == null) ? 0 : flat.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((housing == null) ? 0 : housing.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (flat == null) {
			if (other.flat != null)
				return false;
		} else if (!flat.equals(other.flat))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (housing == null) {
			if (other.housing != null)
				return false;
		} else if (!housing.equals(other.housing))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}
}