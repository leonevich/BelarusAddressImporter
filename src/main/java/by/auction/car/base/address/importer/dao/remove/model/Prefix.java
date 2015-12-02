package by.auction.car.base.address.importer.dao.remove.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PREFIX")
public class Prefix implements Serializable {

    private static final long serialVersionUID = 5073050870500889556L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREFIX_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Prefix() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prefix prefix = (Prefix) o;

        if (id != null ? !id.equals(prefix.id) : prefix.id != null) return false;
        return !(name != null ? !name.equals(prefix.name) : prefix.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Prefix{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
