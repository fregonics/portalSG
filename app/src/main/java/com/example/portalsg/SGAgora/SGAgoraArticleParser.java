package com.example.portalsg.SGAgora;

import com.example.portalsg.PageReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SGAgoraArticleParser {
    public static Elements[] parse(String url) throws Exception {
        final int TITLE = 0;
        final int ARTICLE = 1;
        final int HEADER_IMG = 2;

        String page = PageReader.getPageContent(url);
        //Log.d(SGAgoraArticleParser.class.getSimpleName(), "LER URL: " + url);
        //Log.d(SGAgoraArticleParser.class.getSimpleName(), "PAGINA: " + page);
        Document document = Jsoup.parse(page);

        Elements[] elements = new Elements[3];
        elements[ARTICLE] = document.getElementsByAttributeValue("style", "text-align: justify;");
        elements[TITLE] = document.getElementsByTag("title");
        elements[HEADER_IMG] = document.getElementsByClass("wp-post-image");
        //Log.d(SGAgoraArticleParser.class.getSimpleName(), "PARSED: " + elements[TITLE].text());
        //Log.d(SGAgoraArticleParser.class.getSimpleName(), "PARSED: " + elements[ARTICLE].text());
        //Log.d(SGAgoraArticleParser.class.getSimpleName(), "PARSED: " + elements[HEADER_IMG].attr("src"));

        return elements;
    }
}
