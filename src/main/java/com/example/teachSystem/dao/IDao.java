package com.example.teachSystem.dao;

/**
 * @author pengbin
 * @version 1.0
 */
public interface IDao<T> {
    T getEntity(String key, String clazz);
}
