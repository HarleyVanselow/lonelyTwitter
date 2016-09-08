package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Harley Vanselow on 2016-09-07.
 */
public abstract class Mood {
    private Date date;

    public Mood(){
        setDate(new Date(System.currentTimeMillis()));
    }
    public Mood(Date date){
        setDate(date);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public abstract String printMood();
}
