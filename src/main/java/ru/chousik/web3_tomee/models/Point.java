package ru.chousik.web3_tomee.models;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "points")
public class Point implements Serializable {
    @Serial
    private static final long serialVersionUID = -5170875020617735653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private int id;

    @Column(name = "x", nullable=false)
    private double x;

    @Column(name = "y", nullable=false)
    private double y;

    @Column(name = "r", nullable=false)
    private double r;

    @Column(name = "in_flag", nullable=false)
    private boolean inFlag;

    @Column(name = "time", nullable=false)
    private String time;

    @Column(name = "execution_time", nullable=false)
    private long executionTime;

    @Column(name = "session_id")
    private String sessionId;
}