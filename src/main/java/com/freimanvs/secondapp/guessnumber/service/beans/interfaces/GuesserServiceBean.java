package com.freimanvs.secondapp.guessnumber.service.beans.interfaces;

import com.freimanvs.secondapp.guessnumber.entities.Guesser;
import com.freimanvs.secondapp.guessnumber.service.Service;

import javax.ejb.Remote;

@Remote
public interface GuesserServiceBean extends Service<Guesser> {
}
