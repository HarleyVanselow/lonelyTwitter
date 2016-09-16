package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by vanselow on 9/15/16.
 */
public class ImportantTweet extends Tweet{

    public ImportantTweet(String message, Mood mood) {
        super(message, mood);
    }

    public ImportantTweet(String text, Date date) {
        super(text, date);
    }

    public ImportantTweet(String text) {
        super(text);
    }
    public Boolean isImportant(){
        return Boolean.TRUE;
    }


    public Date getDate() {
        return null;
    }
}
