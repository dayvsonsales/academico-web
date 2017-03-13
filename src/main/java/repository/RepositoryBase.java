package repository;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by anderson on 11/03/17.
 */
public class RepositoryBase<E> {

    protected EntityManager manager;
    private Class<E> entityClass;

    public RepositoryBase(Class entityClass) {
        this.manager = JpaUtil.getEntityManager();
        this.entityClass = entityClass;
    }

    public E save(E entity) {
        try {
            manager.getTransaction().begin();
            manager.merge(entity);
            manager.getTransaction().commit();

            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();

            return null;
        } finally {
            manager.close();
        }
    }

    public void destroy(E entity) {
        try {
            manager.getTransaction().begin();
            entity = manager.merge(entity);
            manager.remove(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }

    public List<E> all(){
        String classe = entityClass.toString();
        String table = classe.substring(classe.lastIndexOf(".")+1);
        System.out.println(table);
        TypedQuery<E> query = manager.createQuery("from " + table, entityClass);
        List<E> result = query.getResultList();
        manager.close();
        return result;
    }

    public E find(Integer id) {
        E result = manager.find(entityClass, id);
        manager.close();

        return result;
    }

}
