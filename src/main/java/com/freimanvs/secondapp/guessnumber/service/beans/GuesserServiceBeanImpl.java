package com.freimanvs.secondapp.guessnumber.service.beans;

import com.freimanvs.secondapp.guessnumber.dao.beans.interfaces.GuesserDAOBean;
import com.freimanvs.secondapp.guessnumber.entities.Guesser;
import com.freimanvs.secondapp.guessnumber.service.beans.interfaces.GuesserServiceBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GuesserServiceBeanImpl implements GuesserServiceBean {

    @EJB
    private GuesserDAOBean guesserDAOBean;

    @Override
    public Long add(Guesser obj) {
        return guesserDAOBean.add(obj);
    }

    @Override
    public List<Guesser> getList() {
        return guesserDAOBean.getList();
    }

    @Override
    public Guesser getById(Long id) {
        return guesserDAOBean.getById(id);
    }

    @Override
    public Guesser getByName(String name) {
        return guesserDAOBean.getByName(name);
    }

    @Override
    public void deleteById(Long id) {
        guesserDAOBean.deleteById(id);
    }

    @Override
    public void updateById(Long id, Guesser obj) {
        guesserDAOBean.updateById(id, obj);
    }
}
