package com.example.portalsg.datareader;

import com.example.portalsg.ArticleParser;

import org.jsoup.select.Elements;
import org.junit.Test;

public class ArticleParserTest {

    @Test
    public void parse() throws Exception {
        final String CORRIDA_APAE_URL = "https://www.sgagora.com.br/sg/com-participacao-de-alunos-da-apae-7a-corrida-da-cenoura-e-realizada-em-sao-gotardo/";
        final String FRASCO_URL = "https://www.sgagora.com.br/sg/mae-confunde-frascos-e-bebe-e-envenenado-em-guarda-dos-ferreiros/";
        Elements[] data = ArticleParser.parse(CORRIDA_APAE_URL);

        System.out.println(data[0].first().text());
        System.out.println(data[1]);
    }
}