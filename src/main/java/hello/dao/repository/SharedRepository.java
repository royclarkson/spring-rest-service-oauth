package hello.dao.repository;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by asabanovic on 7/24/15.
 */
public interface SharedRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
    T findByName(String name);
}
