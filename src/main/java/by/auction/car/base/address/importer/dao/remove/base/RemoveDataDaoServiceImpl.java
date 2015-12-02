package by.auction.car.base.address.importer.dao.remove.base;

import by.auction.car.base.address.importer.dao.DataDaoService;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional("removeTransactionManager")
public class RemoveDataDaoServiceImpl<T, PK extends Serializable> implements DataDaoService<T, PK> {
    private static Logger log = Logger.getLogger(RemoveDataDaoServiceImpl.class);

    @Autowired
    private SessionFactory removeSessionFactory;

    private Class<T> type;

    public RemoveDataDaoServiceImpl() {
        super();
    }

    public RemoveDataDaoServiceImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public Session getSession() {
        return removeSessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getAll() {

        log.info("Getting list of object");
        @SuppressWarnings("unchecked")
        List<T> list = getSession().createCriteria(type).list();
        return list;

    }

    @Override
    public T get(PK id) {

        log.info("Getting object with id: " + id);
        @SuppressWarnings("unchecked")
        T entity = (T) getSession().get(type, id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PK add(T object) {
        PK id;
        id = (PK) getSession().save(object);
        log.info("Adding object with id: " + id);
        return id;

    }

    @Override
    public void update(T object) {
        log.info("Updating object");
        getSession().saveOrUpdate(object);
    }

    @Override
    public void delete(T object) {

        log.info("Deleting object");
        getSession().delete(object);

    }

    @Override
    public void flush() {
        log.info("session flush");
        getSession().flush();

    }

    @Override
    public Query getQuery(String hql) {
        Query query;
        query = getSession().createQuery(hql);
        return query;
    }
}