package com.epicodus.movietrailers;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity {

    private TextView mAppNameTextView;
    private static final String TAG = "MainActivity";

    YouTubePlayerView mYouTubePlayerView;
    Button buttonPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppNameTextView = (TextView) findViewById(R.id.textView);
        Typeface theaterFont = Typeface.createFromAsset(getAssets(), "fonts/Capture_it.ttf");
        mAppNameTextView.setTypeface(theaterFont);

        Log.d(TAG, "onCreate: Starting.");

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youTubePlay);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done initializing.");
                youTubePlayer.loadPlaylist("PLelK7aEMtfK2wpv7tv472alrDpNwO_0jw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed to initialize.");

            }
        };

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Initializing YouTube Player.");
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializedListener);
            }
        });
    }
}
