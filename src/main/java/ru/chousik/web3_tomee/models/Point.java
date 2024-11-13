package ru.chousik.web3_tomee.models;

import jakarta.inject.Named;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Named("point")
public final class Point implements Serializable {
    @Serial
    private static final long serialVersionUID = -5170875020617735653L;
    private int id;
    private double x;
    private double y;
    private double r;
    private boolean inFlag;
    private String time;
    private long executionTime;
}
