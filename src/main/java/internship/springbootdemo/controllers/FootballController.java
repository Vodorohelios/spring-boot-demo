package internship.springbootdemo.controllers;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;
import internship.springbootdemo.services.PlayerService;
import internship.springbootdemo.services.TeamService;
import org.hibernate.Hibernate;
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
        List<Team> teamList = teamService.findAllTeams();
        System.out.println("Is initialized Team: " + Hibernate.isInitialized(teamList.get(0).getPlayers()));
        model.addAttribute("teams", teamList);

        List<Player> playerList = playerService.findAllPlayers();
        System.out.println(Hibernate.isInitialized("Is initialized Player: " + playerList.get(0).getTeams()));
        model.addAttribute("players", playerList);

        return "index";
    }
    
    /**
     *  View all players that was in this team.
     */
    @GetMapping("/teams/{id}")
    public String viewTeam(@PathVariable("id") Long id, Model model) {
        model.addAttribute("players", teamService.findPlayersOfTeam(id));
        return "players-of-team";
    }
    
    /**
     *  View all teams where player was.
     */
    @GetMapping("/players/{id}")
    public String viewPlayer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teams", playerService.findTeamsOfPlayer(id));
        return "teams-of-player";
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
     * Add new player with default team list.
     * This method is for testing cascading types operations.
     */
    @GetMapping("/add-player")
    public String addPlayer(@RequestParam("name") String name) {
        playerService.addPlayer(name);
        return "redirect:/";
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
