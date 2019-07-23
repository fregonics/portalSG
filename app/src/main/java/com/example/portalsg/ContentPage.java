package com.example.portalsg;

import com.example.portalsg.datareader.ArticleParser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ContentPage {
    public String title;
    ArrayList<String> paragraphs;

    final int TITLE_INDEX = 0;
    final int ARTICLE_INDEX = 1;

    public ContentPage(String url) throws Exception {
        Elements[] elements = ArticleParser.parse(url);
        this.title = elements[TITLE_INDEX].first().text();

        Elements article = elements[ARTICLE_INDEX];
        paragraphs = new ArrayList<String>();

        for(Element e: article) {
            paragraphs.add(e.text());
            try{e.children().html();}
            catch (Exception exception) {}
        }
    }
    public String getParagraph(int i) {
        return paragraphs.get(i);
    }
    public boolean isImage(Element e) {
       return false;
    }
    public int size() {
        return paragraphs.size();
    }

    //test
    public ArrayList<String> showParagraphs() {
        return paragraphs;
    }
}
