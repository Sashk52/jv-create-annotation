package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;
import java.util.Optional;

@Dao
public class UserDaoImpl implements UserDao<User> {

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(Storage.users.get((int) id));
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public void save(User user) {
        Storage.users.add(user);
    }

    @Override
    public void update(User user) {
        Storage.users.add(user);
    }

    @Override
    public void delete(User user) {
        Storage.users.remove(user);
    }
}
