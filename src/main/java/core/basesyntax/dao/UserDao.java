package core.basesyntax.dao;

import java.util.List;
import java.util.Optional;

public interface UserDao<T> {
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
