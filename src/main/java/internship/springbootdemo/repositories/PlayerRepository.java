package internship.springbootdemo.repositories;

import internship.springbootdemo.models.Player;

import java.util.List;

public interface PlayerRepository {
    List<Player> getAllPlayers();

    // List<Team> findTeamsOfPlayer ...
}
