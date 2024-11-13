package ru.chousik.web3_tomee.services;

public interface ServiceInterface<T> {
    boolean valid(T t);
    boolean check(T t);
}
