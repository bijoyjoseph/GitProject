package com.gitproject.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.gitproject.github.R;
import com.gitproject.interfaces.ResponseCallback;
import com.gitproject.models.UserModel;
import com.gitproject.utils.AppConstants;
import com.gitproject.utils.NetworkUtil;
import com.gitproject.utils.SharedPrefs;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";
    private View parentLayout;
    private EditText et_search_user;
    private ImageView iv_search_user_button;
    private ImageView iv_user_avatar;
    private TextView tv_user_name;
    private TextView user_type;
    private TextView user_location;
    private TextView user_followers;
    private TextView user_following;
    private TextView user_public_repos;
    private TextView user_public_gists;
    private Button btn_view_user_repos;
    private LinearLayout ll_error_layout;
    private LinearLayout user_details_layout;
    private TableLayout table_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentLayout = findViewById(android.R.id.content);
        initUI();
        //handleFetchUser("bijoyjoseph");
    }

    private void initUI() {
        et_search_user = findViewById(R.id.et_search_user);
        iv_search_user_button = findViewById(R.id.iv_search_user_button);
        et_search_user = findViewById(R.id.et_search_user);
        iv_search_user_button = findViewById(R.id.iv_search_user_button);
        iv_user_avatar = findViewById(R.id.iv_user_avatar);
        tv_user_name = findViewById(R.id.tv_user_name);
        user_type = findViewById(R.id.user_type);
        user_location = findViewById(R.id.user_location);
        user_followers = findViewById(R.id.user_followers);
        user_following = findViewById(R.id.user_following);
        user_public_repos = findViewById(R.id.user_public_repos);
        user_public_gists = findViewById(R.id.user_public_gists);
        btn_view_user_repos = findViewById(R.id.btn_view_user_repos);
        user_details_layout = findViewById(R.id.user_details_layout);

        table_layout = findViewById(R.id.table_layout);
        ll_error_layout = findViewById(R.id.ll_error_layout);

        ll_error_layout.setVisibility(View.VISIBLE);
        table_layout.setVisibility(View.GONE);

        btn_view_user_repos.setOnClickListener(this);
        iv_search_user_button.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    private void handleFetchUser(final String userName) {
        new NetworkUtil(MainActivity.this).fetchUser(userName, new ResponseCallback() {
            @Override
            public void onSuccess(int type, Object... object) {
                ll_error_layout.setVisibility(View.GONE);
                table_layout.setVisibility(View.VISIBLE);
                try {
                    UserModel userModel = (UserModel) object[0];
                    Log.d(TAG, "user model " + userModel.getLogin());

                    handleDownloadImage(iv_user_avatar, userModel.getAvatar_url());
                    tv_user_name.setText(userModel.getLogin());
                    user_type.setText(userModel.getType());
                    user_location.setText(userModel.getLocation());
                    user_followers.setText(Integer.toString(userModel.getFollowers()));
                    user_following.setText(Integer.toString(userModel.getFollowing()));
                    user_public_repos.setText(Integer.toString(userModel.getPublic_repo()));
                    user_public_gists.setText(Integer.toString(userModel.getPublic_gists()));
                    btn_view_user_repos.setText("View " + userModel.getLogin() + "'s " + "Repos");
                    SharedPrefs.saveSignupCredentials(getApplicationContext(), AppConstants.USER_DETAILS, userModel.getLogin());
                    if (parentLayout != null) {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(parentLayout.getWindowToken(), 0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception exception) {
                ll_error_layout.setVisibility(View.VISIBLE);
                table_layout.setVisibility(View.GONE);
                Snackbar.make(parentLayout, "Something went wrong", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void handleDownloadImage(final ImageView imageView, String imageUrl) {
        new NetworkUtil(MainActivity.this).downloadImage(imageUrl, new ResponseCallback() {
            @Override
            public void onSuccess(int type, Object... object) {
                try {
                    Bitmap bitmap = (Bitmap) object[0];
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    } else {
                        imageView.setImageResource(R.drawable.github_logo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception exception) {
                Snackbar.make(parentLayout, "Unable to fetch image", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search_user_button:
                handleFetchUser(et_search_user.getText().toString().trim());
                Log.d(TAG, " UserName " + SharedPrefs.fetchPrefString(getApplicationContext(), AppConstants.USER_DETAILS, AppConstants.USER_NAME));

                break;

            case R.id.btn_view_user_repos:
                Intent intent = new Intent(MainActivity.this, RepoListActivity.class);
                intent.putExtra(AppConstants.USER_NAME, SharedPrefs.fetchPrefString(getApplicationContext(), AppConstants.USER_DETAILS, AppConstants.USER_NAME));
                startActivity(intent);
                break;
        }
    }
}
