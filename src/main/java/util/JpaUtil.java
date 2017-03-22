package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anderson on 11/03/17.
 */
public class JpaUtil {

    private static EntityManagerFactory factory;

    static {
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<String, Object>();

        for (String envName : env.keySet()) {
            if (envName.contains("DATABASE_USER")) {
                configOverrides.put("javax.persistence.jdbc.user", env.get(envName));
            }else if (envName.contains("DATABASE_URL")) {
                configOverrides.put("javax.persistence.jdbc.url", env.get(envName));
            } else if (envName.contains("DATABASE_PASSWORD")) {
                configOverrides.put("javax.persistence.jdbc.password", env.get(envName));
            }
        }

        factory = Persistence.createEntityManagerFactory("AcademicoPU", configOverrides);
    }

    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
