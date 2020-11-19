package fr.ulco.ecom.repository;

import java.util.List;

public interface EntityRepository<T> {
    public T save(T o);
    public List<T> findAll();
    public T findOne(Long id);
    public T update(T o);
    public void delete(Long id);
}
