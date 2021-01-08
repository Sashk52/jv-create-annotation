package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import java.util.List;
import java.util.Optional;

public interface BetDao {
    void add(Bet bet);

    List<Bet> getAll();

    void delete(Bet bet);

    Optional<Bet> get(long id);
}
