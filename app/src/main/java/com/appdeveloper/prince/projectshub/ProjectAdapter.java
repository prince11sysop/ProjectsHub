package com.appdeveloper.prince.projectshub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Project> projectList;


    //getting the context and product list with constructor
    public ProjectAdapter(Context mCtx, List<Project> projectList) {
        this.mCtx = mCtx;
        this.projectList = projectList;

    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview_format, null);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        //getting the product of the specified position
        Project project = projectList.get(position);
        //binding the data with the viewholder views
        holder.textViewTitle.setText(project.getTitle());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(project.getImage()));

    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView imageView;


        public ProjectViewHolder(final View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setTag(getAdapterPosition());// To get the position of recycler View

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, computerScience.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 1) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, ScienceProjectsIdeas.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 2) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, WebsiteIdeas.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 3) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, electricalEngineering.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 4) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, ArtAndCrafts.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 5) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, BlogIdeas.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 6) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, CivilEngineering.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 7) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, AppIdeas.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 8) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, ElectronicsAndCommunication.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 9) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, MetallurgicalEngineering.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 10) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, StartUpIdeas.class); //Change the to  class name
                        context.startActivity(i);
                    } else if (getAdapterPosition() == 11) {
                        Context context = v.getContext();
                        Intent i = new Intent(context, SmallBusinessIdeas.class); //Change the to  class name
                        context.startActivity(i);
                    }
                }
            });


        }



    }
}
