package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Created by Harley on 10/13/2016.
 */
public class EditTweetActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        String tweetText = getIntent().getStringExtra(LonelyTwitterActivity.TWEET);
        Gson gson = new Gson();
        Tweet tweet = gson.fromJson(tweetText,NormalTweet.class);
        TextView tweetView = (TextView)findViewById(R.id.tweetView);
        tweetView.setText(tweet.getMessage());
    }
}
