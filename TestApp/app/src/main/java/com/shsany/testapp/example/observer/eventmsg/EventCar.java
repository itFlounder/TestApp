package com.shsany.testapp.example.observer.eventmsg;

/**
 * Created by PC on 2017/12/4.
 */

public class EventCar {
    public static EventCar instance;
    private ConcreteObservableA observableA;

    private EventCar(){
        observableA = new ConcreteObservableA();
    }
    public static EventCar getInstance(){
        if (instance == null){
            synchronized (EventCar.class){
                if (instance == null ){
                    instance = new EventCar();
                }
            }
        }
        return instance;
    }

    public void register(Observer observer){
        observableA.addObserver(observer);
    }

    public void unregister(Observer observer){
        observableA.removeObserver(observer);
    }

    public void post(Object obj){
        observableA.notifyObserver(obj);
    }
}
