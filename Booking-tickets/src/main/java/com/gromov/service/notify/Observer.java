package com.gromov.service.notify;

import com.gromov.models.interfaces.IObserver;

import java.util.LinkedList;
import java.util.List;

public class Observer {
    private List<IObserver> observers = new LinkedList<>();
    public void pushObsUser(IObserver observer) {
        observers.add(observer);
    }
    public void deleteObsUser(IObserver observer) {
        observers.remove(observer);
    }
    public void notify(String event) {
        for(IObserver x : observers) {
            System.out.println(x.notify(event));
        }
    }
}
