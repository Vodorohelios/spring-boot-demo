package internship.springbootdemo.controllers;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;
import internship.springbootdemo.services.PlayerService;
import internship.springbootdemo.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class FootballController {
    @Autowired
    private TeamService teamService;
    
    @Autowired
    private PlayerService playerService;
    
    /**
     *  View all players that was in this team.
     */
    @RequestMapping("/view-team/{id}")
    public @ResponseBody
    List<Player> viewTeam(@PathVariable("id") Long id) {
        return teamService.findPlayersOfTeam(id); // returns list of Player Objects
    }
    
    /**
     *  View all teams where player was.
     */
    @RequestMapping("/view-player/{id}")
    public @ResponseBody
    List<Team> viewPlayer(@PathVariable("id") Long id) {
        return playerService.findTeamsOfPlayer(id); // returns list of Team Objects
    }

    @RequestMapping("/view-all-players")
    @ResponseBody
    public List<Player> viewAllPlayers() {
        return playerService.findAllPlayers(); // returns list of Player Objects
    }

    @RequestMapping("/view-all-teams")
    @ResponseBody
    public List<Team> viewAllTeams() {
        return teamService.findAllTeams();
    }
}
