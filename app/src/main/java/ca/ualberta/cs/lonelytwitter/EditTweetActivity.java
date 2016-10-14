package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Harley on 10/13/2016.
 */
public class EditTweetActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        String tweetText = getIntent().getStringExtra(LonelyTwitterActivity.TWEET);
        TextView tweetView = (TextView)findViewById(R.id.tweetView);
        tweetView.setText(tweetText);
    }
}
