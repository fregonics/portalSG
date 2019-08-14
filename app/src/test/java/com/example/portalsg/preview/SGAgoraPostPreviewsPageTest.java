package com.example.portalsg.preview;

import com.example.portalsg.PostPreviewsPage;

import org.junit.Test;

import java.util.ArrayList;

public class SGAgoraPostPreviewsPageTest {

    @Test
    public void mostrarTitulos() throws Exception {
        PostPreviewsPage page = new PostPreviewsPage(1);
        ArrayList<String> titulos = page.mostrarTitulos();
        for(String s: titulos)
            System.out.println(s);
    }
    @Test
    public void show() throws Exception {
        PostPreviewsPage page = new PostPreviewsPage(1);
        ArrayList<String> data = page.show();
        for(String s: data)
            System.out.println(s);
    }
}