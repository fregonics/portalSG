package com.example.portalsg.datareader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PageParser {
    public static Elements parse(String content) {
        Document doc = Jsoup.parse(content);
        Elements posts = doc.select("article");
        return  posts;
    }
}
