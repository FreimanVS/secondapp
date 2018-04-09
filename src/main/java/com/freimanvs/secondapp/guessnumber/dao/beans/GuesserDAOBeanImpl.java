package com.freimanvs.secondapp.guessnumber.dao.beans;

import com.freimanvs.secondapp.guessnumber.dao.beans.interfaces.GuesserDAOBean;
import com.freimanvs.secondapp.guessnumber.entities.Guesser;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GuesserDAOBeanImpl implements GuesserDAOBean {

    @PersistenceContext(unitName = "guessnumberMySQL")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Long add(Guesser obj) {
        em.persist(obj);
        em.flush();
        return obj.getId();
    }

    @Override
    public List<Guesser> getList() {
        return em.createQuery("SELECT g FROM Guesser g", Guesser.class).getResultList();
    }

    @Override
    public Guesser getById(Long id) {
        return em.find(Guesser.class, id);
    }

    @Override
    public Guesser getByName(String name) {
        List<Guesser> list = em.createQuery("SELECT g FROM Guesser g " +
                "WHERE g.name = :name", Guesser.class)
                .setParameter("name", name).getResultList();
        return !list.isEmpty() ? list.get(0) : null;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void deleteById(Long id) {
        em.remove(getById(id));
        em.flush();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void updateById(Long id, Guesser obj) {
        Guesser objFromDB = getById(id);
        objFromDB.setName(obj.getName());
        objFromDB.setCount(obj.getCount());
        em.flush();
    }
}
