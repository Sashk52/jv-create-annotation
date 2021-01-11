package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> get(long id);

    List<User> getAll();

    void save(User user);

    void update(User user);

    void delete(User user);
}
