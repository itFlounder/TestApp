package com.shsany.testapp.example.observer.weather;

/**
 * Created by PC on 2017/11/30.
 * 定义了一个天气变换的主题，也就是被观察者，还有两个观察者观察天气变换，
 * 一旦变换了，就打印出天气信息，注意一定要调用被观察者的register进行注册，否则会收不到变换信息。
 * 而一旦不敢兴趣了，直接调用unregister方法进行取消注册即可
 */

public class Test {
    public static void main(String[] args){
        Observable<Weather> observable = new Observable<>();

        Observer<Weather> observer1 = new Observer<Weather>() {
            @Override
            public void onUpdata(Observable<Weather> observable, Weather data) {
                System.out.println("观察者1："+data.toString());
            }
        };

        Observer<Weather> observer2= new Observer<Weather>() {
            @Override
            public void onUpdata(Observable<Weather> observable, Weather data) {
                System.out.println("观察者2："+data.toString());
            }
        };
        observable.register(observer1);
        observable.register(observer2);

        Weather weather1 = new Weather("雪");
        observable.notifyObservers(weather1);

        Weather weather2 = new Weather("雨");
        observable.notifyObservers(weather2);

        observable.unRegister(observer1);

        Weather weather3= new Weather("晴");
        observable.notifyObservers(weather3);
    }
}
