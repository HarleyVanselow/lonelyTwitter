package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by vanselow on 9/15/16.
 */
public class NormalTweet extends Tweet{

    @Override
    public Boolean isImportant() {
        return false;
    }

    public NormalTweet(String text) {
        super(text);
    }
}
