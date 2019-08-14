package com.example.portalsg;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements /*NavigationView.OnNavigationItemSelectedListener,*/ OnPreviewClickListener {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    PostsPage mPostsPage;
    OnPreviewClickListener mainOnPreviewClickListener = this;
    ProgressBar mProgressBar;
    TextView mErrorReadingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        /*DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);*/
        mProgressBar = findViewById(R.id.posts_progress_bar);
        mErrorReadingMessage = findViewById(R.id.tv_error_reading);
        mErrorReadingMessage.setVisibility(View.INVISIBLE);

        recyclerView = findViewById(R.id.post_previews);
        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();


        if(activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
            new PostsPageReaderTask().execute("void");
        }
        else {
            mErrorReadingMessage.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

    @Override
    public void onPreviewClick(int position) {
        Intent intent = new Intent(this, ArticleActivity.class);
        intent.putExtra("url", mPostsPage.get(position).url);
        startActivity(intent);
    }

    public class MainRecyclerviewAdapter extends RecyclerView.Adapter<MainRecyclerviewAdapter.MyViewHolder> {
        PostsPage mDataset;
        OnPreviewClickListener mOnpreviewClickListener;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            // each data item is just a string in this case
            public TextView title;
            public TextView details;
            public ImageView image;
            OnPreviewClickListener onPreviewClickListener;

            public MyViewHolder(View v, OnPreviewClickListener onPreviewClickListener) {
                super(v);
                title = v.findViewById(R.id.preview_title);
                details = v.findViewById(R.id.preview_details);
                image = v.findViewById(R.id.preview_img);
                this.onPreviewClickListener = onPreviewClickListener;
                v.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                onPreviewClickListener.onPreviewClick(getAdapterPosition());
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MainRecyclerviewAdapter(PostsPage posts, OnPreviewClickListener onPreviewClickListener) {
            mDataset = posts;
            mOnpreviewClickListener = onPreviewClickListener;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MainRecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            View v = (View) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.post_preview_layout, parent, false);

            MyViewHolder vh = new MyViewHolder(v,mOnpreviewClickListener);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.title.setText(mDataset.get(position).titulo);
            holder.details.setText(mDataset.get(position).detalhes);
            Glide.with(getApplicationContext()).load(mDataset.get(position).thumbnail).into(holder.image);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }

    }

    private class PostsPageReaderTask extends AsyncTask<String, String, PostsPage> {
        @Override
        protected PostsPage doInBackground(String... strings) {
            PostsPage postsPage;
            Log.d(PostsPageReaderTask.class.getSimpleName(), "VAI LER");

            try {
                postsPage = new PostsPage(1);
                Log.d(PostsPageReaderTask.class.getSimpleName(), "LEU");
                return postsPage;
            } catch (Exception e) {
                Log.d(PostsPageReaderTask.class.getSimpleName(), "NÃO CONSEGUIU LER");
                return null;
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(PostsPage postsPage) {
            super.onPostExecute(postsPage);
            Log.d(PostsPageReaderTask.class.getSimpleName(), "NO POST EXECUTE");
            if(postsPage == null) {
                Log.d(PostsPageReaderTask.class.getSimpleName(), "NÃO PASSOU CERTO");
                mErrorReadingMessage.setVisibility(View.VISIBLE);
            }
            mPostsPage = postsPage;
            Log.d(PostsPageReaderTask.class.getSimpleName(),"LEU TITULO: " + mPostsPage.get(0).titulo);
            mAdapter = new MainRecyclerviewAdapter(mPostsPage, mainOnPreviewClickListener);
            recyclerView.setAdapter(mAdapter);
            mProgressBar.setVisibility(View.INVISIBLE);
        }

    }
}
