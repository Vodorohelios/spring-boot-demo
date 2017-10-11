package internship.springbootdemo.repositories;

import internship.springbootdemo.models.Player;
import internship.springbootdemo.models.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TeamRepositoryImpl implements TeamRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Team> getAllTeams() {
        String hql = "FROM Team";
        return (List<Team>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Player> findPlayersOfTeam(Long id) {
        String hql = "select p.id, p.name from Team t " +
                " inner join t.players p where t.id = " + id;
        return (List<Player>) entityManager.createQuery(hql).getResultList();
    }
}
