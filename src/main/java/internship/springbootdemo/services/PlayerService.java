package internship.springbootdemo.services;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;

import java.util.List;

public interface PlayerService {
    List<Player> findAllPlayers();
    List<Team> findTeamsOfPlayer(Long id);

    void addPlayer(String name);
}
