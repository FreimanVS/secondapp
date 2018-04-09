package com.freimanvs.secondapp.guessnumber.beans.interfaces;

import javax.ejb.Remote;

@Remote
public interface GuessBean {
    void timeOut();
}
