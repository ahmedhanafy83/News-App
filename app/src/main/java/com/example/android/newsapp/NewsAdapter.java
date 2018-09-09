package com.example.android.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News>{
    /**
     * constructors a new ArrayAdapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * getView returns the news information fitting position of the views in news_item_layout
     */
    public View getView(int position, View convertView, ViewGroup parent) {


        /**
         * we must check to see if there is an existing view we can reuse
         * if the view is null we must inflate a new list item layout
         */
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list, parent, false);
        }

        News currentNews = getItem(position);

        //find the news title with the ID news_type
        TextView titleView = listItemView.findViewById(R.id.sectionName);
        titleView.setText(currentNews.getRubric());

        //find news section with ID newsTitle
        TextView newsSection = listItemView.findViewById(R.id.webTitle);
        newsSection.setText(currentNews.getTitle());

        //find news section with iD author
        TextView newsAuthor = listItemView.findViewById(R.id.webUrl);
        // if current news has an name: SHOW
        if (currentNews.geturlNews() != "") {
            newsAuthor.setText(currentNews.geturlNews());

            newsAuthor.setVisibility(View.VISIBLE);
            // if not do not show
        } else {
            newsAuthor.setVisibility(View.GONE);
        }

        // gets the Date and time of the news from the currentNews object and stores it in the variable dateAndTime
        String dateAndTime = currentNews.getDateAndTime();
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        // creates a new SimpleDateFormat object with the ISODateformat that is uses in the Guardian API and stores
        // in the variable dateTimeFormat



        return listItemView;

    }


}
