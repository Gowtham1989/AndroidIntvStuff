package com.androidintvstuff.model;

public class IntvTopics {

    private String intvTopic, intvColor;

    public IntvTopics(String intvTopic, String intvColor) {
        this.intvTopic = intvTopic;
        this.intvColor = intvColor;
    }


    public String getIntvTopic() {
        return intvTopic;
    }

    public void setIntvTopic(String intvTopic) {
        this.intvTopic = intvTopic;
    }

    public String getIntvColor() {
        return intvColor;
    }

    public void setIntvColor(String intvColor) {
        this.intvColor = intvColor;
    }
}
