package com.example.qlangeveld.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {
    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        TextView name = findViewById(R.id.name);
        name.setText(retrievedFriend.getName());

        TextView bio = findViewById(R.id.bio);
        bio.setText(retrievedFriend.getBio());

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(retrievedFriend.getDrawableId());

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        if (retrievedFriend.getRating() > 0) {
            ratingBar.setRating(retrievedFriend.getRating());
        }
        loadFromSharedPrefs();

        ratingBar.setOnRatingBarChangeListener(new RatingBarClickListener());
    }



    public void loadFromSharedPrefs() {
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float newRatingRestored = prefs.getFloat(retrievedFriend.getName(),0);

        if (newRatingRestored > 0) {
            RatingBar ratingBar = findViewById(R.id.ratingBar);
            ratingBar.setRating(newRatingRestored);
        }
    }

    private class RatingBarClickListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putFloat(retrievedFriend.getName(), rating);
            editor.apply();
            editor.commit();
        }
    }

}
