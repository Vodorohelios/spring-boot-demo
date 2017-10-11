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
public class PlayerRepositoryImpl implements PlayerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> getAllPlayers() {
        String hql = "FROM Player";
        return (List<Player>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Team> findTeamsOfPlayer(Long id) {
        String hql = "select t.id, t.name from Player p " +
                " inner join p.teams t where p.id = " + id;
        return (List<Team>) entityManager.createQuery(hql).getResultList();
    }
}
