package com.example.portalsg.preview;

import org.jsoup.nodes.Element;

public class PostPreview {
    public String titulo;
    public String thumbnail;
    public String detalhes;
    public String url;

    public PostPreview(String titulo, String thumbnail, String detalhes, String url) {
        this.titulo = titulo;
        this.thumbnail = thumbnail;
        this.detalhes = detalhes;
        this.url = url;
    }
    public PostPreview(Element e) {
        this.titulo = e.select(".first_A").attr("title");
        this.detalhes = e.select("p").text();
        this.thumbnail = e.select("img").attr("src");
        this.url = e.select(".first_A").attr("href");
    }
}
