package com.gitproject.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.gitproject.adapters.RepoListAdapter;
import com.gitproject.github.R;
import com.gitproject.interfaces.OnAdapterClick;
import com.gitproject.interfaces.ResponseCallback;
import com.gitproject.models.RepoModel;
import com.gitproject.utils.AppConstants;
import com.gitproject.utils.NetworkUtil;

import java.util.ArrayList;

public class RepoListActivity extends AppCompatActivity implements OnAdapterClick {

    private final String TAG = "RepoListActivity";
    private View parentLayout;
    private OnAdapterClick onAdapterClick;
    private ArrayList<RepoModel> repoModelArrayList;
    private RepoListAdapter repoListAdapter;
    private RecyclerView rv_repo_list_recycler_view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        onAdapterClick = this;
        parentLayout = findViewById(android.R.id.content);
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            Log.d(TAG, " UserName " + extra.getString(AppConstants.USER_NAME));
            handleRepoInfo(extra.getString(AppConstants.USER_NAME));
        }
        initUI();
    }

    private void initUI() {

        rv_repo_list_recycler_view = findViewById(R.id.rv_repo_list_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        repoListAdapter = new RepoListAdapter(this, repoModelArrayList, onAdapterClick);
        rv_repo_list_recycler_view.setLayoutManager(linearLayoutManager);
        rv_repo_list_recycler_view.setAdapter(repoListAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    private void handleRepoInfo(final String userName) {
        new NetworkUtil(RepoListActivity.this).parseRepoInfo(userName, new ResponseCallback() {
            @Override
            public void onSuccess(int type, Object... object) {
                try {
                    if (repoModelArrayList == null) {
                        repoModelArrayList = new ArrayList<>();
                    }
                    repoModelArrayList.addAll((ArrayList<RepoModel>) object[0]);
                    if (repoModelArrayList != null) {
                        repoListAdapter.setRepoData(repoModelArrayList);
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

    @Override
    public void onAdapterClick(Object... objects) {
        try {
            int value = (int) objects[0];
            switch (value) {
                case AppConstants.ADAPTER_DATA_PASS:
                    Log.d(TAG, " repo Name " + (String) objects[1]);
                    Intent intent = new Intent(RepoListActivity.this, RepoDetailsActivity.class);
                    intent.putExtra(AppConstants.REPO_NAME, (String) objects[1]);
                    startActivity(intent);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
