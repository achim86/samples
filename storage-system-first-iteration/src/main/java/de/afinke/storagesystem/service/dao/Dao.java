package de.afinke.storagesystem.service.dao;

import java.util.List;

public interface Dao<E, K> {

    void create(E entity);

    E read(K key);

    void update(E entity);

    void delete(E entity);

    List<E> list();

}
