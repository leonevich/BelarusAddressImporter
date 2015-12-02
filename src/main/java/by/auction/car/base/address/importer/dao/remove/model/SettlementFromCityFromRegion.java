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
@Table(name = "SETTLEMENT_CITY_REGION")
public class SettlementFromCityFromRegion implements Serializable{

	private static final long serialVersionUID = 1553499706587983765L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SETTLEMENT_CITY_REGION_ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "settlementFromCityFromRegion")
	private Set<Address> address = new HashSet<Address>();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_REGION_ID")
	private CityFromRegion cityFromRegion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREFIX_ID")
	private Prefix prefix;
	
	public SettlementFromCityFromRegion() {
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

	public CityFromRegion getCityFromRegion() {
		return cityFromRegion;
	}

	public void setCityFromRegion(CityFromRegion cityFromRegion) {
		this.cityFromRegion = cityFromRegion;
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

		SettlementFromCityFromRegion that = (SettlementFromCityFromRegion) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (address != null ? !address.equals(that.address) : that.address != null) return false;
		if (cityFromRegion != null ? !cityFromRegion.equals(that.cityFromRegion) : that.cityFromRegion != null)
			return false;
		return !(prefix != null ? !prefix.equals(that.prefix) : that.prefix != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (cityFromRegion != null ? cityFromRegion.hashCode() : 0);
		result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "SettlementFromCityFromRegion{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
