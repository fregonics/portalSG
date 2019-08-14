package com.example.portalsg;

import org.junit.Test;

public class PageReaderTest {

    @Test
    public void getPageContent() throws Exception{
        System.out.println("inicio");
        final String page = "https://www.sgagora.com.br/sg/";
        String content = PageReader.getPageContent(page);
        System.out.println(content);
    }
}