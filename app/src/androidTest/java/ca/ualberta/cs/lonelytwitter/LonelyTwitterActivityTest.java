package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.RobotiumUtils;
import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    private Solo solo;
    public final static String TWEET = "u";
    public void setUp(){
        Log.d("TAG1","setUp()");
        solo = new Solo(getInstrumentation(),getActivity());
    }
    public void tearDown(){

    }

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity!",LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        solo.enterText((EditText)solo.getView(R.id.body),"Test Tweet!");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText)solo.getView(R.id.body));
        assertTrue(solo.waitForText("Test Tweet!"));
        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!"));
    }
    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity!",LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        String tweetMessage = "Test Tweet!";
        addTweet(tweetMessage);
        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet)oldTweetsList.getItemAtPosition(0);
        assertEquals(tweetMessage,tweet.getMessage());
        solo.clickInList(0);
        solo.assertCurrentActivity("Wrong Activity!",EditTweetActivity.class);
        assertTrue(solo.waitForText(tweetMessage));
        solo.goBack();
        solo.clickOnButton("Clear");
        String altTweetMessage = "New Text";
        addTweet(altTweetMessage);
        solo.clickInList(0);
        solo.assertCurrentActivity("Wrong Activity!",EditTweetActivity.class);
        assertTrue(solo.waitForText(altTweetMessage));
        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity",LonelyTwitterActivity.class);
    }

    private void addTweet(String tweetMessage) {
        solo.enterText((EditText)solo.getView(R.id.body), tweetMessage);
        solo.clickOnButton("Save");
        solo.waitForText(tweetMessage);
    }

    /**
     * Test start.
     *
     * @throws Exception the exception
     */
    public void testStart() throws Exception {
        Activity activity = getActivity();

    }
}