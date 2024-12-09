package ru.chousik.web3_tomee.different_scoped;

import java.io.Serializable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("AScope")
@ApplicationScoped
public class ApplicationScopedBeans implements Serializable {
    private int count = 0;

    public int getCount() {
        return count++;
    }
}
