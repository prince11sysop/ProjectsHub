package com.appdeveloper.prince.projectshub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.ads.InterstitialAd;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //a list to store all the projects
    List<Project> projectList;
    //the recycler view
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //To hide the notification bar
      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
      //  requestWindowFeature(android.view.Window.FEATURE_CUSTOM_TITLE);

         setContentView(R.layout.activity_main);
         getSupportActionBar().setIcon(R.mipmap.ic_launcher);


         recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int numberOfColumns=2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerView.setHasFixedSize(true);

        //initializing the project list
        projectList = new ArrayList<>();

        //adding some items to our list
        projectList.add(new Project("Computer Science Engineering Project Ideas", R.drawable.computer));
        projectList.add(new Project("Science Project Ideas", R.drawable.science));
        projectList.add(new Project("Website Ideas", R.drawable.website));
        projectList.add(new Project("Electrical Project Ideas", R.drawable.electrical));
        projectList.add(new Project("Arts and Crafts Ideas", R.drawable.arts));
        projectList.add(new Project("Blog Ideas", R.drawable.blog));
        projectList.add(new Project("Civil Project Ideas", R.drawable.civil));
        projectList.add(new Project("App Ideas", R.drawable.app));
        projectList.add(new Project("Electronics & Communication Project Ideas", R.drawable.electronics));
        projectList.add(new Project("Mechanical Project Ideas", R.drawable.mechanical));
        projectList.add(new Project("StartUp Ideas", R.drawable.startup));
        projectList.add(new Project("Small Business Ideas", R.drawable.business));

        //creating recycler view adapter
        ProjectAdapter adapter = new ProjectAdapter(this, projectList);

        //setting adapter to recycler view
        recyclerView.setAdapter(adapter);
        }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
               Intent i = new Intent(getApplicationContext(),About.class); //Change the to  class name
                getApplicationContext().startActivity(i);
                return true;
            case R.id.rate:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.appdeveloper.prince.projectshub")));
                return true;
            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "https://play.google.com/store/apps/details?id=com.appdeveloper.prince.projectshub";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Download Projects Hub to get hundreds of Project related ideas:");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Share Using"));
                return true;
            case R.id.privacy:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/e/2PACX-1vQMgM56lVBDjQcQZsrFGzY6_XgN5wlqjsm18JgiLHPJmoiWbEfYqaj3FGclcq1lea7DvVAIUHwTds_v/pub") );
                startActivity(browserIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


   /* public void privacyPolicy(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/e/2PACX-1vQMgM56lVBDjQcQZsrFGzY6_XgN5wlqjsm18JgiLHPJmoiWbEfYqaj3FGclcq1lea7DvVAIUHwTds_v/pub") );
                startActivity(browserIntent);
    }*/
}



