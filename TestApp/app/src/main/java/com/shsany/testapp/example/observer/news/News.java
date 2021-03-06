package com.shsany.testapp.example.observer.news;

/**
 * Created by PC on 2017/11/30.
 */

public class News {
    private String title;
    private String content;

    public News(String title,String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{title=" + title + ",content=" + content + "}";
    }
}
