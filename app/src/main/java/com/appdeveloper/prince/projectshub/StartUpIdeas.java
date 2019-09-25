package com.appdeveloper.prince.projectshub;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StartUpIdeas extends AppCompatActivity {

    InterstitialAd interstitialAd = null;
    private  RecyclerView mBlogList;
    private  DatabaseReference mDatabase;
    Button visitbtn;          // Declare a button
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("StartUp Ideas");
        setContentView(R.layout.start_up_ideas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    //For back button

        MobileAds.initialize(this,
                "ca-app-pub-8185975393672752~5007031287");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-8185975393672752/4639153590");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);

        dialog = new ProgressDialog(StartUpIdeas.this);
        dialog.setMessage("Please Wait...");
        dialog.setCancelable(false);

        // Call isNetworkAvailable class
        if (!isNetworkAvailable()) {
            // Create an Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            // Set the Alert Dialog Message
            builder.setMessage("No Internet Connection")
                    .setCancelable(false)
                    .setPositiveButton("Retry",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    // Restart the Activity
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

        } else {
            dialog.show();
            // Locate the button in check_internet_connection.xml
            visitbtn = (Button) findViewById(R.id.visit);
            // Set the button visibility
            visitbtn.setVisibility(View.INVISIBLE);
            // Capture Button click
            visitbtn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View arg0) {
                    // Recheck Network Connection
                    if (!isNetworkAvailable()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                StartUpIdeas.this);
                        builder.setMessage("No Internet Connection")
                                .setCancelable(false)
                                .setPositiveButton("Retry",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int id) {
                                                visitbtn.setVisibility(View.GONE);
                                                // Restart the activity
                                                Intent intent = new Intent(
                                                        StartUpIdeas.this,
                                                        WebsiteIdeas.class);
                                                finish();
                                                startActivity(intent);

                                            }

                                        });
                        AlertDialog alert = builder.create();
                        alert.show();


                    } else {
                        visitbtn.setVisibility(View.GONE);
                        visitbtn.setVisibility(View.INVISIBLE);
                    }

                }
            });
        }
        mDatabase=FirebaseDatabase.getInstance().getReference().child("StartUp");
        mDatabase.keepSynced(true);
        mBlogList=(RecyclerView)findViewById(R.id.recycler_view);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Blog,BlogViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Blog, BlogViewHolder>
                (Blog.class,R.layout.card,BlogViewHolder.class,mDatabase)
        {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {
                viewHolder.setIdea(model.getIdea());
                viewHolder.setIdeaDescription(model.getIdeaDescription());
                dialog.dismiss();
            }
        };

        mBlogList.setAdapter(firebaseRecyclerAdapter);

    }
    public  static  class BlogViewHolder extends  RecyclerView.ViewHolder {
        View mView;
        public BlogViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }
        public  void setIdea(String idea)
        {
            TextView mIdea=(TextView)mView.findViewById(R.id.list_item_text);
            mIdea.setText(idea);
        }
        public  void setIdeaDescription(String ideaDescription)
        {
            TextView mIdeaDescription=(TextView)mView.findViewById(R.id.description);
            mIdeaDescription.setText(ideaDescription);
        }
    }

    //for back button
    @Override
    public boolean onSupportNavigateUp(){
        if (interstitialAd.isLoaded())
            interstitialAd.show();
        finish();
        return true;
    }

    // Private class isNetworkAvailable
    private boolean isNetworkAvailable() {
        // Using ConnectivityManager to check for Network Connection
        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
    @Override
    public void onBackPressed() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        } else {
            super.onBackPressed();
        }
    }

}
