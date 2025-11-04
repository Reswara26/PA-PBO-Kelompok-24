package model;

import java.util.List;

public interface ICRUD<T> {
    boolean tambah(T t);
    boolean edit(T t);
    boolean hapus(String id);
    T getById(String id);
    List<T> getAll();
}
