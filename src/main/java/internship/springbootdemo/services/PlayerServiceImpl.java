package internship.springbootdemo.services;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.repositories.PlayerRepository;
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
}
