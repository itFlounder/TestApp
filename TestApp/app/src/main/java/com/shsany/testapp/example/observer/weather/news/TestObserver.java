package com.shsany.testapp.example.observer.weather.news;

/**
 * Created by PC on 2017/11/30.
 */

public class TestObserver {
    public static void main(String[] args){
        Observable<News> observable = new Observable<>();
        Observer<News> observer1 = new Observer<News>() {
            @Override
            public void upData(Observable<News> observable, News data) {
                System.out.println("observer1："+data.toString());
            }
        };

        Observer<News> observer2 = new Observer<News>() {
            @Override
            public void upData(Observable<News> observable, News data) {
                System.out.println("observer2："+data.toString());
            }
        };

        observable.regsiter(observer1);
        observable.regsiter(observer2);

        News news = new News("兰亭序","死生亦大事也");
        observable.notifyObserver(news);
    }
}
