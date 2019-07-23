package com.example.portalsg;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {
    ContentPage mContentPage;
    LinearLayout mLinearLayout;
    String mURL;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Log.d(ArticleActivity.class.getSimpleName(), "CARREGOU BASE");

        Intent intent = getIntent();
        mURL = intent.getStringExtra("url");
        Log.d(ArticleActivity.class.getSimpleName(), "URL: " + mURL);

        mLinearLayout = findViewById(R.id.paragraphs);
        new ContentPageReaderTask().execute(new Object());

    }

    class ContentPageReaderTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                mContentPage = new ContentPage(mURL);
                Log.d(ArticleActivity.class.getSimpleName(), "PEGOU CONTENT PAGE: " + mContentPage.title);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            TextView tvTitle = new TextView(getApplicationContext());
            final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

            tvTitle.setText(mContentPage.title);
            tvTitle.setTextSize(22);
            mLinearLayout.addView(tvTitle);
            tvTitle.setLayoutParams(params);

            for(int i = 0; i < mContentPage.size(); i ++) {
                Log.d(ArticleActivity.class.getSimpleName(), "CRIANDO TEXTVIEW " + i);

                TextView tv = new TextView(getApplicationContext());
                tv.setText(mContentPage.getParagraph(i));
                tv.setId(i);
                tv.setTextSize(16);
                tv.setLayoutParams(params);
                Log.d(ArticleActivity.class.getSimpleName(), "TEXTVIEW CRIADA");

                mLinearLayout.addView(tv);
                Log.d(ArticleActivity.class.getSimpleName(), "TEXTVIEW ADICIONADA");

                toolbar.setTitle("");
                setSupportActionBar(toolbar);
            }
        }
    }
}
