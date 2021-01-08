package rest.service;

import java.util.List;

public interface Serviceable<T> {

    void create(T object);
    List<T> readAll();
    T readById(Integer id);
    boolean update(T object);
    boolean delete(Integer id);
    boolean updatePartial(T ob);
}