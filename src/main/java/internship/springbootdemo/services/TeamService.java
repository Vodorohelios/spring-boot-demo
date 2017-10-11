package internship.springbootdemo.services;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAllTeams();
//    List<Player> findPlayersOfTeam(Long id);
}
