package ru.chousik.web3_tomee.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import ru.chousik.web3_tomee.models.Point;

import java.io.Serializable;

import static java.lang.Math.abs;

@Named
@ApplicationScoped
public class PointsService implements ServiceInterface<Point>, Serializable {
    private static final double MAX_R = 4;
    private static final double MIN_R = 1;
    private static final double MAX_ABS_X = 6;
    private static final double MAX_ABS_Y = 6;


    @Override
    public boolean valid(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();

        boolean xValid = x*x <= MAX_ABS_X*MAX_ABS_X;
        boolean yValid = y*y <= MAX_ABS_Y*MAX_ABS_Y;
        boolean rValid = MIN_R <= r && r <= MAX_R;

        return xValid || yValid || rValid;
    }

    @Override
    public boolean  check(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();

        boolean itTriangle = (x <= 0 && y >= 0 && (2 * x + r) >= y);
        boolean itCircle = (x < 0 && y < 0 && (x * x + y * y) <= r*r/4);
        boolean itRectangle = (x > 0 && x < r && y < 0 && y > -r);

        return itTriangle || itCircle || itRectangle;
    }
}