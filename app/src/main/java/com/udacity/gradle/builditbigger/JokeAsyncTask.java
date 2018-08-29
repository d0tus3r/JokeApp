package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import net.digitalswarm.mylibrary.*;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class JokeAsyncTask extends AsyncTask<Object, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;

    @Override
    protected String doInBackground(Object...params) {
        mContext = (Context)params[0];
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(),
                    null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.genJoke().execute().getJoke();
        } catch (IOException e) {
            //log error message and return empty string
            Log.d(TAG, "doInBackground: " + e.getMessage());
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(mContext, AndroidLibraryActivity.class);
        intent.putExtra(AndroidLibraryActivity.CLOUD_JOKE_KEY, result);
        mContext.startActivity(intent);
    }
}
