package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    //TODO: A function that gets tweets
    public static class AddTweetsTask extends AsyncTask<NormalTweet,Void,Void>{
        protected Void doInBackground(NormalTweet... tweets) {
            Index index = new Index.Builder(tweets[0]).index("testing").type("tweet").build();
            try{

            }catch(Exception e){
                Log.i("Error","The application failed to build and send the tweet");
            }
            return null;
        }
    }
    //TODO: A function that adds a tweet
    public static void verifySettings(){
        if(client == null){
            DroidClientConfig.Builder builder =new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();
            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient)factory.getObject();
        }
    }
}
