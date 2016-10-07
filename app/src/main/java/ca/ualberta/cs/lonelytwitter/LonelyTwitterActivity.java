package ca.ualberta.cs.lonelytwitter;
/*
Copyright (C) 2016 Team 20, CMPUT301, University of Alberta - All Rights Reserved.
You may use, copy or distribute this code under the terms and conditions of University of Alberta
and Code of Student Behavior.
Please contact abc@abc.ca for more details or questions.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * This class is the main view class in lonelyTwitter class.
 * It deals with user inputs, saves/loads them in/from the file FILE_NAME (file.sav)
 * <p>You can access this file from Android Device Monitor</p>
 * <code>
 * pseudo-code that is used in this class is as follows:
 * step 1 <br>
 * step 2 <br>
 * </code>
 * <ol>
 * <li>first item</li>
 * <li>second item</li>
 * <li>third item</li>
 * <p>
 * </ol>
 *
 * @author Harley
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * This is the name of the file that is saved in your virtual device.
	 * You can access it through Android Device Monitor by selecting your app,
	 * then data -> data -> file.sav
	 * @see NormalTweet
	 */
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	
	/*
	Testing multi-line documentations
	Testing.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		loadFromFile();
		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				tweetList.clear();
				adapter.notifyDataSetChanged();
				deleteFile(FILENAME);
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item,tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This method loads the json file and generates the tweets from its contents
	 * @throws RuntimeException
	 * @exception FileNotFoundException
	 */
	private void loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList=gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweetList,writer);
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}