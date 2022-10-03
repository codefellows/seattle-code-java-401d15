package com.zork.zork_demo;

import android.app.Application;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;

public class SuperFurBoyAmplifyApplication extends Application {
    public static final String Tag = "PokemanApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        try{
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());
        } catch(AmplifyException ae) {
            Log.e(Tag, "Error initializing Amplify: " + ae.getMessage(), ae);
        }
    }
}
