package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vanselow on 9/15/16.
 */
public abstract class Tweet implements Tweetable{
    private String message;
    private Mood mood;
    private Date creationDate;
    private List<Mood> moodList;

    public Tweet(String message, Mood mood) {
        this.message = message;
        this.creationDate=new Date();
        this.mood = mood;
    }
    public abstract Boolean isImportant();

    public Tweet(String text,Date date){
        this.message=text;
    }
    public Tweet(String text) {
        this.message=text;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return creationDate;
    }

    public void setMoodList(List<Mood> moodList) {
        this.moodList = moodList;
    }
}
