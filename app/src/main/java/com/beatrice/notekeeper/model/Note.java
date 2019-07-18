package com.beatrice.notekeeper.model;

public class Note {

    private String title, subTitle, text;

    public Note(String title, String subTitle, String text) {
        this.title = title;
        this.subTitle = subTitle;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getText() {
        return text;
    }
}
