package com.gitproject.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.gitproject.adapters.RepoDetailsAdapter;
import com.gitproject.github.R;
import com.gitproject.interfaces.ResponseCallback;
import com.gitproject.models.RepoContentModel;
import com.gitproject.utils.AppConstants;
import com.gitproject.utils.NetworkUtil;
import com.gitproject.utils.SharedPrefs;

import java.util.ArrayList;

public class RepoDetailsActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private View parentLayout;
    private ArrayList<RepoContentModel> repoContentModelArrayList;
    private RepoDetailsAdapter repoDetailsAdapter;
    private RecyclerView rv_repo_content_recycler_view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        parentLayout = findViewById(android.R.id.content);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            Log.d(TAG, " RepoName " + extra.getString(AppConstants.REPO_NAME));
            handleRepoContent(extra.getString(AppConstants.REPO_NAME), SharedPrefs.fetchPrefString(getApplicationContext(), AppConstants.USER_DETAILS, AppConstants.USER_NAME));
        }

        initUI();
    }

    private void initUI() {

        rv_repo_content_recycler_view = findViewById(R.id.rv_repo_content_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        repoDetailsAdapter = new RepoDetailsAdapter(this, repoContentModelArrayList);
        rv_repo_content_recycler_view.setLayoutManager(linearLayoutManager);
        rv_repo_content_recycler_view.setAdapter(repoDetailsAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    private void handleRepoContent(final String repoName, final String userName) {
        new NetworkUtil(RepoDetailsActivity.this).repoContent(repoName, userName, new ResponseCallback() {
            @Override
            public void onSuccess(int type, Object... object) {
                try {
                    if (repoContentModelArrayList == null) {
                        repoContentModelArrayList = new ArrayList<>();
                    }
                    repoContentModelArrayList.addAll((ArrayList<RepoContentModel>) object[0]);
                    if (repoContentModelArrayList != null) {
                        repoDetailsAdapter.setRepoDetailsData(repoContentModelArrayList);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception exception) {
                Snackbar.make(parentLayout, "Something went wrong", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
