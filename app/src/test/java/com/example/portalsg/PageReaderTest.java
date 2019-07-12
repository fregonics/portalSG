package com.example.portalsg;

import android.util.Log;

import com.example.portalsg.datareader.PageReader;

import org.junit.Test;

import static org.junit.Assert.*;

public class PageReaderTest {

    @Test
    public void getPageContent() throws Exception{
        System.out.println("inicio");
        final String page = "https://www.sgagora.com.br/sg/";
        String content = PageReader.getPageContent(page);
        System.out.println(content);
    }
}