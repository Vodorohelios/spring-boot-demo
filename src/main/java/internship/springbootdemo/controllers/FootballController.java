package internship.springbootdemo.controllers;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;
import internship.springbootdemo.services.PlayerService;
import internship.springbootdemo.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FootballController {
    @Autowired
    private TeamService teamService;
    
    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("teams", teamService.findAllTeams());
        model.addAttribute("players", playerService.findAllPlayers());
        return "index";
    }
    
    /**
     *  View all players that was in this team.
     */
    @GetMapping("/teams/{id}")
    @ResponseBody
    public List<Player> viewTeam(@PathVariable("id") Long id) {
        return teamService.findPlayersOfTeam(id); // returns list of Player Objects
    }
    
    /**
     *  View all teams where player was.
     */
    @GetMapping("/players/{id}")
    @ResponseBody
    public List<Team> viewPlayer(@PathVariable("id") Long id) {
        return playerService.findTeamsOfPlayer(id); // returns list of Team Objects
    }

    /**
     * View all players.
     */
    @GetMapping("/players")
    @ResponseBody
    public List<Player> viewAllPlayers() {
        return playerService.findAllPlayers(); // returns list of Player Objects
    }

    /**
     * View all teams.
     */
    @GetMapping("/teams")
    @ResponseBody
    public List<Team> viewAllTeams() {
        return teamService.findAllTeams();
    }

    /**
     * View player's ids of a team.
     * @param teamId
     * @return
     */
    @GetMapping("/player-ids-of-team")
    @ResponseBody
    public List<Long> findPlayerIdsOfTeam(@RequestParam("id") Long teamId) {
        return teamService.findPlayerIdsOfTeam(teamId);
    }
}
