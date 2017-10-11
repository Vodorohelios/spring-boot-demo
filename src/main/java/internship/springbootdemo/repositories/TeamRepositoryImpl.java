package internship.springbootdemo.repositories;

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
}
