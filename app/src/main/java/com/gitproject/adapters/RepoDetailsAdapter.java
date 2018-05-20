package com.gitproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gitproject.github.R;
import com.gitproject.models.RepoContentModel;

import java.util.ArrayList;

public class RepoDetailsAdapter extends RecyclerView.Adapter<RepoDetailsAdapter.DetailsViewHolder> {

    private final String TAG = "RepoDetailsAdapter";
    private Context context;
    private ArrayList<RepoContentModel> repoContentModelArrayList;

    public RepoDetailsAdapter(Context context, ArrayList<RepoContentModel> repoContentModelArrayList) {
        this.context = context;
        this.repoContentModelArrayList = repoContentModelArrayList;
    }

    public void setRepoDetailsData(ArrayList<RepoContentModel> repoContentModelArrayList) {
        this.repoContentModelArrayList = repoContentModelArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoDetailsAdapter.DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.repo_details_layout, parent, false);
        return new RepoDetailsAdapter.DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoDetailsAdapter.DetailsViewHolder holder, int position) {
        RepoContentModel repoContentModel = repoContentModelArrayList.get(position);
        holder.tv_file_name.setText(repoContentModel.getName());
        holder.tv_repo_sha.setText(repoContentModel.getSha());
        holder.tv_repo_content_size.setText(Integer.toString(repoContentModel.getSize()));
        holder.tv_repo_content_path.setText(repoContentModel.getPath());
        holder.tv_repo_content_type.setText(repoContentModel.getType());
        holder.tv_repo_content_url.setText(repoContentModel.getHtml_url());
    }

    @Override
    public int getItemCount() {
        return repoContentModelArrayList != null ? repoContentModelArrayList.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_file_name;
        private TextView tv_repo_sha;
        private TextView tv_repo_content_size;
        private TextView tv_repo_content_path;
        private TextView tv_repo_content_type;
        private TextView tv_repo_content_url;

        private DetailsViewHolder(View view) {
            super(view);

            tv_file_name = view.findViewById(R.id.tv_file_name);
            tv_repo_sha = view.findViewById(R.id.tv_repo_sha);
            tv_repo_content_size = view.findViewById(R.id.tv_repo_content_size);
            tv_repo_content_path = view.findViewById(R.id.tv_repo_content_path);
            tv_repo_content_type = view.findViewById(R.id.tv_repo_content_type);
            tv_repo_content_url = view.findViewById(R.id.tv_repo_content_url);
            tv_repo_content_url.setMovementMethod(LinkMovementMethod.getInstance());
        }


    }
}
