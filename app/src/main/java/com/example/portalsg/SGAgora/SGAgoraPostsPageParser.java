package com.example.portalsg.SGAgora;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SGAgoraPostsPageParser {
    public static Elements parse(String content) {
        Document doc = Jsoup.parse(content);
        Elements posts = doc.select("article");
        return  posts;
    }
}
