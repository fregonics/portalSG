package com.example.portalsg;

import java.util.ArrayList;

public class ContentPage {
    public String title;
    ArrayList<String> paragraphs;

    public ContentPage(String title, ArrayList<String> paragraphs) {
        this.title = title;
        this.paragraphs = paragraphs;
    }
    public String getParagraph(int i) {
        return paragraphs.get(i);
    }
    public boolean isImage(int i) {
        return false;
    }
}
