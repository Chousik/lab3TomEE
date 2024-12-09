package ru.chousik.web3_tomee.different_scoped;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("VScope")
@ViewScoped
public class ViewScopedBeans implements Serializable {
    private int count = 0;

    public int getCount() {
        return count++;
    }
}
