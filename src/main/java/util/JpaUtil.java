package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by anderson on 11/03/17.
 */
public class JpaUtil {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("AcademicoPU");
    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
