package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Harley on 9/29/2016.
 */
public class TweetList{
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    public TweetList(){};
    public void add(Tweet tweet) {
        if(getTweets().contains(tweet)){
            throw new IllegalArgumentException("THIS TWEET ALREADY EXISTS!");
        }
        tweets.add(tweet);
    }

    public boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet t1) {
                return tweet.getDate().before(t1.getDate())?-1:1;
            }
        });
        return tweets;
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);

    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public int getCount() {
        return tweets.size();
    }
}
