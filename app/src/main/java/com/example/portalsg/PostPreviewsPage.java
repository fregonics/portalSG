package com.example.portalsg;

import com.example.portalsg.SGAgora.SGAgoraPostPreview;
import com.example.portalsg.SGAgora.SGAgoraPostsPageParser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class PostPreviewsPage {
    final String PAGE = "https://www.sgagora.com.br/sg/sg-noticias/";

    int pagina;
    ArrayList<SGAgoraPostPreview> posts;

    public PostPreviewsPage(int i) throws Exception {
        pagina = i;
        posts = new ArrayList<SGAgoraPostPreview>();

        String html = PageReader.getPageContent(PAGE);
        Elements postsFiltrados = SGAgoraPostsPageParser.parse(html);

        for(Element e: postsFiltrados) {
            SGAgoraPostPreview p = new SGAgoraPostPreview(e);
            posts.add(p);
        }
    }

    public SGAgoraPostPreview get(int i) {
        return posts.get(i);
    }

    public int size() {
        return posts.size();
    }


    //test
    public ArrayList<String> mostrarTitulos() {
        ArrayList<String> titulos = new ArrayList<String>();
        for(SGAgoraPostPreview p : posts) {
            titulos.add(p.titulo);
        }
        return titulos;
    }
    //test
    public ArrayList<String> show() {
        ArrayList<String> data = new ArrayList<String>();
        for(SGAgoraPostPreview p : posts) {
            data.add(p.titulo);
            data.add(p.detalhes);
            data.add(p.thumbnail);
            data.add(p.url);
        }
        return data;
    }
}
