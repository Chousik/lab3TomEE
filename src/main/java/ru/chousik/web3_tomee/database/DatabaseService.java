package ru.chousik.web3_tomee.database;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import lombok.NoArgsConstructor;
import ru.chousik.web3_tomee.beans.PointBean;
import ru.chousik.web3_tomee.models.Point;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
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
    }

    public List<Point> getPoints() {
        return manager().createQuery("SELECT p FROM Point p", Point.class).getResultList();
    }
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
