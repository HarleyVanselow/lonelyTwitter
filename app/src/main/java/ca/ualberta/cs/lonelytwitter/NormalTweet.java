package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/15/16.
 * An instantiable class extending the abstract Tweet class
 * @see Tweet
 */
public class NormalTweet extends Tweet {

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     */
    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
