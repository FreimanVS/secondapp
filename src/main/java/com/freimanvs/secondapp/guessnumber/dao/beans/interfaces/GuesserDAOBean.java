package com.freimanvs.secondapp.guessnumber.dao.beans.interfaces;

import com.freimanvs.secondapp.guessnumber.dao.DAO;
import com.freimanvs.secondapp.guessnumber.entities.Guesser;

import javax.ejb.Remote;

@Remote
public interface GuesserDAOBean extends DAO<Guesser> {
}
