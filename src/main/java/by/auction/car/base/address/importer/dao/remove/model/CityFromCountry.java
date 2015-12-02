package by.auction.car.base.address.importer.dao.remove.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CITY_COUNTRY")
public class CityFromCountry implements Serializable {

	private static final long serialVersionUID = -3026173317910320324L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITY_COUNTRY_ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cityFromCountry")
	private Set<Address> address = new HashSet<Address>();

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PREFIX_ID")
	private Prefix prefix;

	public CityFromCountry(){
		super();
	}

	public CityFromCountry(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

		CityFromCountry that = (CityFromCountry) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (address != null ? !address.equals(that.address) : that.address != null) return false;
		if (country != null ? !country.equals(that.country) : that.country != null) return false;
		return !(prefix != null ? !prefix.equals(that.prefix) : that.prefix != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (country != null ? country.hashCode() : 0);
		result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CityFromCountry{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
