package com.example.portalsg;

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
    public PostPreview() {
        return;
    }
}
