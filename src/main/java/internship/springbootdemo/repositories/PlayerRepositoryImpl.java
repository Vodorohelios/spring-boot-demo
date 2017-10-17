package internship.springbootdemo.repositories;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PlayerRepositoryImpl implements PlayerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> getAllPlayers() {
        String hql = "FROM Player";
        return (List<Player>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Team> findTeamsOfPlayer(Long playerId) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Team> query = cb.createQuery(Team.class);
        Root<Player> player = query.from(Player.class);
        Join<Player, Team> teams = player.join("teams");
        query.select(teams).where(cb.equal(player.get("id"), playerId.toString()));
        return entityManager.createQuery(query).getResultList();
    }

    // Method for testing cascading types operations
    @Override
    public void addPlayer(String name) {
        Player player = new Player();
        player.setName(name);

        List<Team> teamList = new ArrayList<>();
        Team team = new Team();
        team.setName(name + " team");
        teamList.add(team);
        player.setTeams(teamList);

        entityManager.persist(player);
    }

    @Override
    public void deletePlayer(Long id) {
        Player player = entityManager.getReference(Player.class, id);
        entityManager.remove(player);
    }

}
