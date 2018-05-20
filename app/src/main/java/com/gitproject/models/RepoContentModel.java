package com.gitproject.models;

import android.os.Parcel;
import android.os.Parcelable;

public class RepoContentModel implements Parcelable {

    public static final Creator<RepoContentModel> CREATOR = new Creator<RepoContentModel>() {
        @Override
        public RepoContentModel createFromParcel(Parcel in) {
            return new RepoContentModel(in);
        }

        @Override
        public RepoContentModel[] newArray(int size) {
            return new RepoContentModel[size];
        }
    };

    String name;
    String path;
    String sha;
    int size;
    String url;
    String html_url;
    String git_url;
    String download_url;
    String type;
    String self;
    String git;
    String html;

    public RepoContentModel() {
        name = "";
        path = "";
        sha = "";
        size = 0;
        url = "";
        html_url = "";
        git_url = "";
        download_url = "";
        type = "";
        self = "";
        git = "";
        html = "";
    }


    protected RepoContentModel(Parcel in) {
        name = in.readString();
        path = in.readString();
        sha = in.readString();
        size = in.readInt();
        url = in.readString();
        html_url = in.readString();
        git_url = in.readString();
        download_url = in.readString();
        type = in.readString();
        self = in.readString();
        git = in.readString();
        html = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(path);
        parcel.writeString(sha);
        parcel.writeInt(size);
        parcel.writeString(url);
        parcel.writeString(html_url);
        parcel.writeString(git_url);
        parcel.writeString(download_url);
        parcel.writeString(type);
        parcel.writeString(self);
        parcel.writeString(git);
        parcel.writeString(html);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
