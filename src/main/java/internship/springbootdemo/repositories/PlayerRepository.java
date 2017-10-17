package internship.springbootdemo.repositories;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;

import java.util.List;

public interface PlayerRepository {
    List<Player> getAllPlayers();
    List<Team> findTeamsOfPlayer(Long playerId);

    void addPlayer(String name);

    void deletePlayer(Long id);
}
