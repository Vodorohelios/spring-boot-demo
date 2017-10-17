package internship.springbootdemo.services;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;
import internship.springbootdemo.repositories.PlayerRepository;
import internship.springbootdemo.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.getAllPlayers();
    }

    @Override
    public List<Team> findTeamsOfPlayer(Long id) {
        return playerRepository.findTeamsOfPlayer(id);
    }

    @Override
    public void addPlayer(String name) {
        playerRepository.addPlayer(name);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deletePlayer(id);
    }

}
