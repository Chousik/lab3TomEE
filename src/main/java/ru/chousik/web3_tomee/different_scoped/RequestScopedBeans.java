package ru.chousik.web3_tomee.different_scoped;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("RScope")
@RequestScoped
public class RequestScopedBeans implements Serializable {
    private int count = 0;

    public int getCount() {
        return count++;
    }
}
