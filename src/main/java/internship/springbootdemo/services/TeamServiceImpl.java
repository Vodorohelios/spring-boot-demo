package internship.springbootdemo.services;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;
import internship.springbootdemo.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    TeamRepository teamRepository;

    @Override
    public List<Team> findAllTeams() {
        return teamRepository.getAllTeams();
    }

    @Override
    public List<Player> findPlayersOfTeam(Long id) {
        return teamRepository.findPlayersOfTeam(id);
    }
}
