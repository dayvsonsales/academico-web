package repository;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by anderson on 11/03/17.
 */
public class RepositoryBase<E> {

    private EntityManager _manager;
    private Class<E> entityClass;

    public RepositoryBase(Class entityClass) {
        this._manager = JpaUtil.getEntityManager();
        this.entityClass = entityClass;
    }

    public EntityManager manager() {
        if (!_manager.isOpen())
            this._manager = JpaUtil.getEntityManager();

        return _manager;
    }

    public E save(E entity) {
        try {
            manager().getTransaction().begin();
            manager().merge(entity);
            manager().getTransaction().commit();

            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            manager().getTransaction().rollback();

            return null;
        } finally {
            manager().close();
        }
    }

    public boolean destroy(E entity) {
        try {
            manager().getTransaction().begin();
            entity = manager().merge(entity);
            manager().remove(entity);
            manager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            manager().getTransaction().rollback();
            return false;
        } finally {
            manager().close();
        }
    }

    public List<E> all() {
        String _class = entityClass.toString();
        String table = _class.substring(_class.lastIndexOf(".") + 1);

        TypedQuery<E> query = manager().createQuery("from " + table, entityClass);
        List<E> result = query.getResultList();

        manager().close();
        return result;
    }

    public E find(Integer id) {
        E result = manager().find(entityClass, id);
        manager().close();

        return result;
    }

}
