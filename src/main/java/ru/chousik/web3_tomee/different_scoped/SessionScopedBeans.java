package ru.chousik.web3_tomee.different_scoped;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("SScope")
@SessionScoped
public class SessionScopedBeans implements Serializable {
    private int count = 0;

    public int getCount() {
        return count++;
    }
}
