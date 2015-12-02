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
@Table(name = "HOUSE")
public class House implements Serializable  {

	private static final long serialVersionUID = -3689188954620283758L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOUSE_ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STREET_ID")
	private Street street;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "street")
	private Set<House> streets = new HashSet<House>();
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "street")
	private Set<Address> address = new HashSet<Address>();
	
	public House() {
		super();
	}

}
