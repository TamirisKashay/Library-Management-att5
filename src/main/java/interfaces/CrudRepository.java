package interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {

    T create(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    T update(T entity);

    void delete(ID id);
}
