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
@Table(name = "SETTLEMENT_CITY_DISTRICT")
public class SettlementFromCityFromDistrict implements Serializable{

	private static final long serialVersionUID = 7714008587182321039L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SETTLEMENT_CITY_DISTRICT_ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "settlementFromCityFromDistrict")
	private Set<Address> address = new HashSet<Address>();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_DISTRICT_ID")
	private CityFromDistrict cityFromDistrict;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREFIX_ID")
	private Prefix prefix;
	
	public SettlementFromCityFromDistrict() {
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

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public CityFromDistrict getCityFromDistrict() {
		return cityFromDistrict;
	}

	public void setCityFromDistrict(CityFromDistrict cityFromDistrict) {
		this.cityFromDistrict = cityFromDistrict;
	}

	public Prefix getPrefix() {
		return prefix;
	}

	public void setPrefix(Prefix prefix) {
		this.prefix = prefix;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SettlementFromCityFromDistrict that = (SettlementFromCityFromDistrict) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (address != null ? !address.equals(that.address) : that.address != null) return false;
		if (cityFromDistrict != null ? !cityFromDistrict.equals(that.cityFromDistrict) : that.cityFromDistrict != null)
			return false;
		if (prefix != null ? !prefix.equals(that.prefix) : that.prefix != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (cityFromDistrict != null ? cityFromDistrict.hashCode() : 0);
		result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "SettlementFromCityFromDistrict{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
