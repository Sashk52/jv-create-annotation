package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;
import java.util.Objects;
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
    public void update(User user, String[] params) {
        if (Storage.users.contains(user)) {
            int index = Storage.users.indexOf(user);
            Storage.users.remove(user);
            User newUser = new User(Objects.requireNonNull(params[0], "Name can't be null"),
                    Objects.requireNonNull(params[1], " e-mail can't be null"));
            Storage.users.add(index, newUser);
        }
    }

    @Override
    public void delete(User user) {
        Storage.users.remove(user);
    }
}
