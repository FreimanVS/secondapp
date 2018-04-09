package com.freimanvs.secondapp.guessnumber.beans;

import com.freimanvs.secondapp.guessnumber.beans.interfaces.GuessBean;

import javax.ejb.Stateful;

@Stateful
public class GuessBeanImpl implements GuessBean {

    private final long SLEEPTIME = 1000 * 10;

    @Override
    public void timeOut() {
        try {
            Thread.sleep(SLEEPTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
