package com.example.fblogincheckin;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;


//instead of android.app.Activity, facebook uses:
import com.facebook.FacebookActivity;
import com.facebook.ProfilePictureView;
//to allow sessions (login) with facebook:
import com.facebook.SessionState;
import com.facebook.GraphUser;
import com.facebook.Request;
import com.facebook.Response;


public class MainActivity extends FacebookActivity { //notice parent class, FacebookActivity
	
	//private ProfilePictureView profilePictureView;
	//private TextView userNameView;
									
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        		//this.openSession >>> facebook login, begins session w/fb
        this.openSession(); 
        		//Once the user is logged in, 
        		//the onSessionStateChange method of the activity will be called.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    protected void onSessionStateChange(SessionState state, Exception exception) {
      // after login or no login
	  if (state.isOpened()) {
		    // make request to the /me API
		    Request request = Request.newMeRequest(
		      this.getSession(),
		      new Request.GraphUserCallback() {
		        // callback after Graph API response with user object
		        @Override
		        public void onCompleted(GraphUser user, Response response) {
		          if (user != null) {
		           // TextView welcome = (TextView) findViewById(R.id.welcome);
		           // welcome.setText("Hello " + user.getName() + "!");
		          }
		        }
		      }
		    );
		    Request.executeBatchAsync(request);
		  }
    }
}
