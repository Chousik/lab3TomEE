package ru.chousik.web3_tomee.database;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import ru.chousik.web3_tomee.models.Point;

import java.io.Serializable;
import java.util.List;


@Named
@ApplicationScoped
public class DatabaseService implements Serializable {
    private EntityManager manager(){
        return Persistence.createEntityManagerFactory("PostgresPU")
                .createEntityManager();
    }
    public void addPoint(Point point) {
        EntityManager entityManager = manager();
        entityManager.getTransaction().begin();
        entityManager.persist(point);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Point> getPoints(String sessionId) {
        EntityManager entityManager = manager();
        List<Point> points = entityManager.createQuery(
                        "SELECT p FROM Point p WHERE p.sessionId = :sessionId", Point.class)
                .setParameter("sessionId", sessionId)
                .getResultList();
        entityManager.close();
        return points;
    }
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
