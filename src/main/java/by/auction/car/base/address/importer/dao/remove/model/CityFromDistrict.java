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
@Table(name = "CITY_DISTRICT")
public class CityFromDistrict implements Serializable {

	private static final long serialVersionUID = -1492155259696827465L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITY_DISTRICT_ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cityFromDistrict")
	private Set<Address> address = new HashSet<Address>();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTRICT_ID")
	private District district;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREFIX_ID")
	private Prefix prefix;
	
	public CityFromDistrict() {
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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
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

		CityFromDistrict that = (CityFromDistrict) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (address != null ? !address.equals(that.address) : that.address != null) return false;
		if (district != null ? !district.equals(that.district) : that.district != null) return false;
		return !(prefix != null ? !prefix.equals(that.prefix) : that.prefix != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (district != null ? district.hashCode() : 0);
		result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CityFromDistrict{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
