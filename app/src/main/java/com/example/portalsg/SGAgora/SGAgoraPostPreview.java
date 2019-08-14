package com.example.portalsg.SGAgora;

import com.example.portalsg.PostPreview;

import org.jsoup.nodes.Element;

public class SGAgoraPostPreview extends PostPreview {

    public SGAgoraPostPreview(Element e) {
        this.titulo = e.select(".first_A").attr("title");
        this.detalhes = e.select("p").text();
        this.thumbnail = e.select("img").attr("src");
        this.url = e.select(".first_A").attr("href");
    }
}
