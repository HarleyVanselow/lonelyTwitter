package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Created by Harley on 9/29/2016.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.contains(tweet));
    }
    public void testAddTweet(){
        TweetList list = new TweetList();
        Tweet testTweet =new NormalTweet("adding Tweet");
        list.add(testTweet);
        assertTrue(list.contains(testTweet));
    }


    public void testAddRepeatTweet(){
        TweetList list = new TweetList();
        Tweet testTweet = new NormalTweet("test");
        list.add(testTweet);
        try{
            list.add(testTweet);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }
    public void testGetTweet(){
        TweetList list = new TweetList();
        Tweet testTweet = new NormalTweet("test");
        list.add(testTweet);
        assertEquals(testTweet,list.getTweet(0));
    }
    public void testGetTweets(){
        TweetList list = new TweetList();
        Tweet first = new NormalTweet("1");
        first.setDate(new Date(1990,1,1));
        Tweet second = new NormalTweet("2");
        second.setDate(new Date(2000,1,1));
        Tweet third = new NormalTweet("3");
        third.setDate(new Date(2016,1,1));
        list.add(third);
        list.add(first);
        list.add(second);
        assertEquals(first,list.getTweets().get(0));
        assertEquals(second,list.getTweets().get(1));
        assertEquals(third,list.getTweets().get(2));
    }

    public void testGetCount(){
        TweetList list=  new TweetList();
        Tweet testTweet = new NormalTweet("test");
        Tweet testTweet2 = new NormalTweet("test");
        assertEquals(0,list.getCount());
        list.add(testTweet);
        assertEquals(1,list.getCount());
        list.add(testTweet2);
        assertEquals(2,list.getCount());

    }
    public void testDelete(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("deleteMe");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.contains(tweet));
    }
}
