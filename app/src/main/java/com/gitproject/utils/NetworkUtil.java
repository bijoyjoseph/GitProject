package com.gitproject.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.gitproject.gitapplication.GitApplication;
import com.gitproject.interfaces.ResponseCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkUtil {

    private final String BASE_URL = "https://api.github.com/";
    private final String GIT_USER = "users/";
    private final String GIT_REPOS = "repos/";

    private Context mContext;
    private MediaType JSON;

    public NetworkUtil(Context context) {
        this.mContext = context;
        JSON = MediaType.parse("application/json; charset=utf-8");
    }

    public void downloadImage(final String imageUrl, final ResponseCallback responseCallback) {
        try {
            Request request = new Request.Builder().url(imageUrl).build();
            GitApplication.getInstance().getmOkhttpClient().newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException ioException) {
                    GitApplication.getInstance().getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            responseCallback.onError(ioException);
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final InputStream inputStream = response.body().byteStream();
                    final Object[] returnObject = new Object[1];
                    try {
                        returnObject[0] = BitmapFactory.decodeStream(inputStream);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    GitApplication.getInstance().getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            responseCallback.onSuccess(-1, returnObject);
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchUser(String userName, final ResponseCallback responseCallback) {
        try {
            okhttp3.Request request = new Request.Builder().url(BASE_URL + GIT_USER + userName).get().build();
            Log.d("request body", request.toString());
            GitApplication.getInstance().getmOkhttpClient().newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException ioException) {

                    GitApplication.getInstance().getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            responseCallback.onError(ioException);
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String responseData = response.body().string();
                    Object[] returnObject = new Object[1];
                    try {
                        returnObject = new JsonUtils(mContext).parseGitUserInfo(new JSONObject(responseData));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    final Object[] finalReturnObject = returnObject;
                    GitApplication.getInstance().getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            responseCallback.onSuccess(-1, finalReturnObject);
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseRepoInfo(String userName, final ResponseCallback responseCallback) {
        try {
            okhttp3.Request request = new Request.Builder().url(BASE_URL + GIT_USER + userName + AppConstants.USER_REPOS).get().build();
            Log.d("request URL", BASE_URL + GIT_USER + userName + AppConstants.USER_REPOS);
            Log.d("request body", request.toString());
            GitApplication.getInstance().getmOkhttpClient().newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException ioException) {
                    GitApplication.getInstance().getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            responseCallback.onError(ioException);
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String responseData = response.body().string();
                    Object[] returnObject = new Object[1];
                    try {
                        returnObject = new JsonUtils(mContext).parseRepoInfo(new JSONArray(responseData));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    final Object[] finalReturnObject = returnObject;
                    GitApplication.getInstance().getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            responseCallback.onSuccess(-1, finalReturnObject);
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void repoContent(String repoName, String userName, final ResponseCallback responseCallback) {
        try {
            okhttp3.Request request = new Request.Builder().url(BASE_URL + GIT_REPOS + userName + "/" + repoName + "/" + "contents").get().build();
            Log.d("request URL", BASE_URL + GIT_USER + userName + AppConstants.USER_REPOS);
            Log.d("request body", request.toString());
            GitApplication.getInstance().getmOkhttpClient().newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException ioException) {
                    GitApplication.getInstance().getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            responseCallback.onError(ioException);
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String responseData = response.body().string();
                    Object[] returnObject = new Object[1];
                    try {
                        returnObject = new JsonUtils(mContext).parseRepoContentInfo(new JSONArray(responseData));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    final Object[] finalReturnObject = returnObject;
                    GitApplication.getInstance().getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            responseCallback.onSuccess(-1, finalReturnObject);
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
