package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;


    public static class AddTweetsTask extends AsyncTask<NormalTweet,Void,Void>{
        protected Void doInBackground(NormalTweet... tweets) {
            verifySettings();
            for (NormalTweet tweet : tweets) {
                Index index = new Index.Builder(tweets[0]).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        tweet.setId(result.getId());
                    }
                } catch (Exception e) {
                    Log.i("Error", "The application failed to build and send the tweet");
                }
            }
            return null;
        }
    }
    public static class GetTweetsTask extends AsyncTask<String,Void,ArrayList<NormalTweet>>{

        protected ArrayList<NormalTweet> doInBackground(String... searchParameters) {
            verifySettings();
            ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();
            //Assumptions: only the first search parameters is used.
            Search search = new Search.Builder(searchParameters[0])
                    .addIndex("testing")
                    .addType("tweet")
                    .build();
            try{
                SearchResult result=  client.execute(search);
                if(result.isSucceeded()){
                    List<NormalTweet> foundTweets = result.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(foundTweets);
                }else{
                    Log.i("Error","The search execued but didn't work");
                }
            }catch (Exception e){
                Log.i("Error","Executing the get tweets method failed");
            }
            return tweets;
        }
    }
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
