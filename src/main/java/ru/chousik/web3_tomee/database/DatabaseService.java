package ru.chousik.web3_tomee.database;

import jakarta.enterprise.context.ApplicationScoped;
import ru.chousik.web3_tomee.models.Point;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

@ApplicationScoped
public class DatabaseService implements Serializable {
    public void addPoint(Point point) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(ADD_POINT)) {

            statement.setDouble(1, point.getX());
            statement.setDouble(2, point.getY());
            statement.setDouble(3, point.getR());
            statement.setBoolean(4, point.isInFlag());
            statement.setString(5, point.getTime());
            statement.setLong(6, point.getExecutionTime());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(GET_POINTS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Point point = new Point();
                point.setId(resultSet.getInt("id"));
                point.setX(resultSet.getDouble("x"));
                point.setY(resultSet.getDouble("y"));
                point.setR(resultSet.getDouble("r"));
                point.setInFlag(resultSet.getBoolean("in_flag"));
                point.setTime(resultSet.getString("time"));
                point.setExecutionTime(resultSet.getLong("execution_time"));

                points.add(point);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return points;
    }

    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS points(
                id SERIAL PRIMARY KEY,
                x REAL NOT NULL,
                y REAL NOT NULL,
                r REAL NOT NULL,
                in_flag BOOLEAN NOT NULL,
                time TEXT NOT NULL,
                execution_time BIGINT NOT NULL
            );
            """;

    private static final String ADD_POINT = """
            INSERT INTO points(x, y, r, in_flag, time, execution_time)
            VALUES (?, ?, ?, ?, ?, ?);""";

    private static final String GET_POINTS = """
            SELECT * FROM points;
            """;
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres_webapp";

    static {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(CREATE_TABLE)) {
            statement.execute();
            System.err.println("DSAJLDHSAAAAAAAAAAAAAAAAAAAAAAAAA");
            System.err.println(statement.getMetaData());
        } catch (SQLException e) {
            System.err.println("Таблица уже создана!");
        }
    }
}
