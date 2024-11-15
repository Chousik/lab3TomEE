package ru.chousik.web3_tomee.beans;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import lombok.Getter;
import lombok.Setter;
import ru.chousik.web3_tomee.database.DatabaseService;
import ru.chousik.web3_tomee.models.Point;
import ru.chousik.web3_tomee.services.PointsService;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Named("pointBean")
@SessionScoped
@Getter
@Setter
public class PointBean implements Serializable {
    private double selectedX = 0;
    private double selectedY;
    private double selectedR = 1;
    private List<Point> points;
    private Point point;

    @Inject
    private PointsService pointsService;


    private EntityManager entityManager;

    @PostConstruct
    public void loadPointsFromDb() {
        entityManager = Persistence.createEntityManagerFactory("PostgresPU").createEntityManager();
        points = entityManager.createQuery("SELECT p FROM Point p", Point.class).getResultList();
    }

    public void checkPoint() {
        long startTime = System.nanoTime();
        Point point = new Point();
        point.setX(selectedX);
        point.setY(selectedY);
        point.setR(selectedR);

        if (pointsService.valid(point)) {
            point.setInFlag(pointsService.check(point));
            point.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            point.setExecutionTime(System.nanoTime() - startTime);
            System.err.println(point);

            this.addPoint(point);
        }
    }

    private void addPoint(Point point) {
        // Добавляем точку в базу данных через JPA
        entityManager.getTransaction().begin();  // Начинаем транзакцию
        entityManager.persist(point);  // Сохраняем точку
        entityManager.getTransaction().commit();  // Фиксируем транзакцию

        points.add(point);
        this.point = point;
    }
}