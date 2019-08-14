package com.example.portalsg.SGAgora;

import com.example.portalsg.PostPreview;

import org.jsoup.nodes.Element;

public class SGAgoraPostPreview extends PostPreview {
    public String titulo;
    public String thumbnail;
    public String detalhes;
    public String url;

    public SGAgoraPostPreview(Element e) {
        super();
        this.titulo = e.select(".first_A").attr("title");
        this.detalhes = e.select("p").text();
        this.thumbnail = e.select("img").attr("src");
        this.url = e.select(".first_A").attr("href");
    }
}
