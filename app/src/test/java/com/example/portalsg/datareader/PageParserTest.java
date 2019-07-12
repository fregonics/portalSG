package com.example.portalsg.datareader;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageParserTest {

    @Test
    public void parse() {
        final String PAGE = "https://www.sgagora.com.br/sg/sg-noticias/";
        try {
            String pageContent = PageReader.getPageContent(PAGE);
            Elements posts = PageParser.parse(pageContent);
            System.out.println(posts.size());
            Element first = posts.first();
            System.out.println(first.html());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}