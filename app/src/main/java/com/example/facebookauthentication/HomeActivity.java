package com.example.facebookauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {
        private final String TAG = "HomeActivity";

        AccessTokenTracker accessTokenTracker;
        AccessToken accessToken;

        TextView emaiInfoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        emaiInfoTextView = (TextView) findViewById(R.id.email_info);

        fillUserInfo();
    }

    private void fillUserInfo(){
        accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken == null){
            Log.d(TAG, "Something went wrong, please re-log.");
        }
        else{
            GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback(){
                @Override
                public void onCompleted(JSONObject object, GraphResponse response){
                    displayUserInfo(object);
                }
            });
        }
    }
}
