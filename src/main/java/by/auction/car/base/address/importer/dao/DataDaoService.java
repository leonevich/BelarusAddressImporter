package by.auction.car.base.address.importer.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public interface DataDaoService<T, PK extends Serializable> {


    Session getSession();

    List<T> getAll();


    T get(PK id);


    PK add(T object);


    void update(T object);


    void delete(T object);


    void flush();

    Query getQuery(String hql);


}
