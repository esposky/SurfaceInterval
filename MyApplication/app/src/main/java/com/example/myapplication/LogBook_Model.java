package com.example.myapplication;

public class LogBook_Model {
    String diveLog_title;
    String diveLog_description;
    String id;

    public LogBook_Model(String id, String title, String description) {
        this.diveLog_title = title;
        this.diveLog_description = description;
        this.id = id;
    }

    public String getTitle() {
        return diveLog_title;
    }

    public void setTitle(String title) {
        this.diveLog_title = title;
    }

    public String getDescription() {
        return diveLog_description;
    }

    public void setDescription(String description) {
        this.diveLog_description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

