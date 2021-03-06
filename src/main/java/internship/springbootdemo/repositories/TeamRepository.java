package internship.springbootdemo.repositories;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;

import java.util.List;

public interface TeamRepository {
    Team getById(Long id);
    List<Team> getAllTeams();
    List<Player> findPlayersOfTeam(Long teamId);
    List<Long> findPlayerIdsOfTeam(Long teamId);
}
