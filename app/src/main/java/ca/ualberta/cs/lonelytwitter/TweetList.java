package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Harley on 9/29/2016.
 * Class to contain a list of tweets and control their addition and access.
 */
public class TweetList{
    /**
     * Primary list to contain all the tweets in the tweetlist
     */
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Instantiates a new Tweet list.
     */
    public TweetList(){};

    /**
     * Add a tweet to the current tweetlist.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        if(getTweets().contains(tweet)){
            throw new IllegalArgumentException("THIS TWEET ALREADY EXISTS!");
        }
        tweets.add(tweet);
    }

    /**
     * Boolean for whether the list contains a tweet
     *
     * @param tweet Check if this tweet exists in the tweet list
     * @return True if the tweet is in the list, false if the tweet is not in the list
     */
    public boolean contains(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Gets all tweets in the tweetlist in chronological order
     *
     * @return All tweets, chonologically ordered
     */
    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet t1) {
                return tweet.getDate().before(t1.getDate())?-1:1;
            }
        });
        return tweets;
    }

    /**
     * Delete a tweet
     *
     * @param tweet The tweet to delete
     */
    public void delete(Tweet tweet) {
        tweets.remove(tweet);

    }

    /**
     * Gets tweet.
     *
     * @param i the index of the tweet to return
     * @return The tweet at index i
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Gets count.
     *
     * @return The number of tweets in the list
     */
    public int getCount() {
        return tweets.size();
    }
}
