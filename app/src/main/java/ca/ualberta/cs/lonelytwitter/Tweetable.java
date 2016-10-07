package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * Created by watts1 on 9/15/16.
 * An interface for any object that can be tweeted
 */
public interface Tweetable {
    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate();

}
