package com.example.portalsg;

import android.util.Log;

public class URLReader {
    public void main() {
        final String URL = "http://www.sgagora.com/sg";

        try {
            String content = PageReader.getPageContent(URL);
            Log.d(this.getClass().getSimpleName(), content);
        } catch (Exception e) {
            Log.d(this.getClass().getSimpleName(), "nao foi possivel acessar");
        }
    }
}
