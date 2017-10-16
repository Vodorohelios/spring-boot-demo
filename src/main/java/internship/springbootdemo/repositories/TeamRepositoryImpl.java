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
public class TeamRepositoryImpl implements TeamRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Team getById(Long id) {
        return null;
    }

    @Override
    public List<Team> getAllTeams() {
        String hql = "FROM Team";
        return (List<Team>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Player> findPlayersOfTeam(Long teamId) {
        // using hql:
//        String hql = "select p.id, p.name from Player p " +
//                " inner join p.teams t where t.id = " + teamId;
//        return (List<Player>) entityManager.createQuery(hql).getResultList();

        // using criteria:
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Player> query = cb.createQuery(Player.class);
        Root<Team> team = query.from(Team.class);
        Join<Team, Player> players = team.join("players");
        query.select(players).where(cb.equal(team.get("id"), teamId.toString()));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Long> findPlayerIdsOfTeam(Long teamId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Player> query = cb.createQuery(Player.class);
        Root<Team> team = query.from(Team.class);
        Join<Team, Player> players = team.join("players");
        query.select(players).where(cb.equal(team.get("id"), teamId.toString()));

        List<Player> playersList = entityManager.createQuery(query).getResultList();
        List<Long> playerIds = new ArrayList<>();
        for (Player player : playersList) {
            playerIds.add(player.getId());
        }
        return playerIds;
    }
}
