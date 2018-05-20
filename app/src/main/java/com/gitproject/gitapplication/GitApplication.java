package com.gitproject.gitapplication;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import okhttp3.OkHttpClient;

public class GitApplication extends Application {

    private static GitApplication mGitApplication = null;
    private OkHttpClient mOkhttpClient = null;
    private Handler mHandler = null;

    public static synchronized GitApplication getInstance() {
        if (mGitApplication == null) {
            return mGitApplication = new GitApplication();
        }
        return mGitApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mGitApplication = this;
    }

    public OkHttpClient getmOkhttpClient() {
        if (mOkhttpClient == null) {
            mOkhttpClient = new OkHttpClient.Builder().build();
        }
        return mOkhttpClient;
    }

    public Handler getHandler() {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
        return mHandler;
    }
}
