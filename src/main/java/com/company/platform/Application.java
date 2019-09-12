package com.company.platform;

public abstract class Application {
    protected String title;

    public abstract void run(String[] args);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
