package com.example.portalsg;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ContentPageTest {

    @Test
    public void showParagraphs() throws Exception {
        final String CORRIDA_APAE_URL = "https://www.sgagora.com.br/sg/com-participacao-de-alunos-da-apae-7a-corrida-da-cenoura-e-realizada-em-sao-gotardo/";
        try {
            ContentPage page = new ContentPage(CORRIDA_APAE_URL);
            ArrayList<String> paragraphs = page.showParagraphs();
            for(String s: paragraphs)
                System.out.println(s);
            System.out.println(page.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}