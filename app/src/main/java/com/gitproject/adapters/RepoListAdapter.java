package com.gitproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gitproject.github.R;
import com.gitproject.interfaces.OnAdapterClick;
import com.gitproject.models.RepoModel;

import java.util.ArrayList;

import static com.gitproject.utils.AppConstants.ADAPTER_DATA_PASS;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> {

    private final String TAG = "RepoListAdapter";
    private Context context;
    private ArrayList<RepoModel> repoModelArrayList;
    private OnAdapterClick onAdapterClick;

    public RepoListAdapter(Context context, ArrayList<RepoModel> repoModelArrayList, OnAdapterClick onAdapterClick) {
        this.context = context;
        this.repoModelArrayList = repoModelArrayList;
        this.onAdapterClick = onAdapterClick;
    }

    public void setRepoData(ArrayList<RepoModel> repoModelArrayList) {
        this.repoModelArrayList = repoModelArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoListAdapter.RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.repo_list_layout, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoListAdapter.RepoViewHolder holder, int position) {
        RepoModel repoModel = repoModelArrayList.get(position);
        holder.tv_project_name.setText(repoModel.getFull_name());
        holder.tv_html_url.setText(repoModel.getHtml_url());
        holder.tv_repo_size.setText(Integer.toString(repoModel.getSize()));
        holder.tv_repo_watchers.setText(Integer.toString(repoModel.getWatchers()));
        holder.tv_repo_open_issues.setText(Integer.toString(repoModel.getOpen_issues()));
    }

    @Override
    public int getItemCount() {
        return repoModelArrayList != null ? repoModelArrayList.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_project_name;
        private TextView tv_html_url;
        private TextView tv_repo_size;
        private TextView tv_repo_watchers;
        private TextView tv_repo_open_issues;
        private View repoView;

        private RepoViewHolder(View view) {
            super(view);
            repoView = view;
            tv_project_name = view.findViewById(R.id.tv_project_name);
            tv_html_url = view.findViewById(R.id.tv_html_url);
            tv_html_url.setMovementMethod(LinkMovementMethod.getInstance());
            tv_repo_size = view.findViewById(R.id.tv_repo_size);
            tv_repo_watchers = view.findViewById(R.id.tv_repo_watchers);
            tv_repo_open_issues = view.findViewById(R.id.tv_repo_open_issues);
            repoView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (repoModelArrayList.get(getAdapterPosition()) != null) {
                onAdapterClick.onAdapterClick(ADAPTER_DATA_PASS, repoModelArrayList.get(getAdapterPosition()).getName());
                Log.d(TAG, repoModelArrayList.get(getAdapterPosition()).getFull_name());
            }
        }
    }
}
