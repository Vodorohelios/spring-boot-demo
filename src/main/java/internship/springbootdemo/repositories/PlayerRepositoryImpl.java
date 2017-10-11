package internship.springbootdemo.repositories;

import internship.springbootdemo.models.Player;
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
}
