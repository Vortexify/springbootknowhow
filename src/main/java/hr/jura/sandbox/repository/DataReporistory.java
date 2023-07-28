package hr.jura.sandbox.repository;

import hr.jura.sandbox.model.Company;

import java.util.List;

public interface DataReporistory<T>{
    long save(T data);
    T findById(Long data);
    T update(T data);
    void deleteById(long data);
}
