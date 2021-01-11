package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.List;
import java.util.Optional;

public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.bets;
    }

    @Override
    public void delete(Bet bet) {
        Storage.bets.remove(bet);
    }

    @Override
    public Optional<Bet> get(long id) {
        return Optional.ofNullable(Storage.bets.get((int) id));
    }
}
