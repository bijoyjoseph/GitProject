package com.gitproject.models;

import android.os.Parcel;
import android.os.Parcelable;

public class RepoModel implements Parcelable {

    public static final Creator<RepoModel> CREATOR = new Creator<RepoModel>() {
        @Override
        public RepoModel createFromParcel(Parcel in) {
            return new RepoModel(in);
        }

        @Override
        public RepoModel[] newArray(int size) {
            return new RepoModel[size];
        }
    };
    String id;
    String name;
    String full_name;
    String login;
    long owner_id;
    String avatar_url;
    String owner_url;
    String owner_html_url;
    String type;
    boolean site_admin;
    boolean is_private;
    String html_url;
    String description;
    boolean fork;
    String url;
    String created_at;
    String updated_at;
    String pushed_at;
    String git_url;
    String ssh_url;
    String clone_url;
    String svn_url;
    String homepage;
    int size;
    int stargazers_count;
    int watchers_count;
    String language;
    boolean has_issues;
    boolean has_projects;
    boolean has_downloads;
    boolean has_wiki;
    boolean has_pages;
    int forks_count;
    String mirror_url;
    boolean archived;
    int open_issues_count;
    String license;
    int forks;
    int open_issues;
    int watchers;
    String default_branch;


    public RepoModel() {
        id = "";
        name = "";
        full_name = "";
        login = "";
        owner_id = 0L;
        avatar_url = "";
        owner_url = "";
        owner_html_url = "";
        type = "";
        site_admin = false;
        is_private = false;
        html_url = "";
        description = "";
        fork = false;
        url = "";
        created_at = "";
        updated_at = "";
        pushed_at = "";
        git_url = "";
        ssh_url = "";
        clone_url = "";
        svn_url = "";
        homepage = "";
        size = 0;
        stargazers_count = 0;
        watchers_count = 0;
        language = "";
        has_issues = false;
        has_projects = false;
        has_downloads = false;
        has_wiki = false;
        has_pages = false;
        forks_count = 0;
        mirror_url = "";
        archived = false;
        open_issues_count = 0;
        license = "";
        forks = 0;
        open_issues = 0;
        watchers = 0;
        default_branch = "";
    }

    protected RepoModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        full_name = in.readString();
        login = in.readString();
        owner_id = in.readLong();
        avatar_url = in.readString();
        owner_url = in.readString();
        owner_html_url = in.readString();
        type = in.readString();
        site_admin = in.readByte() != 0;
        is_private = in.readByte() != 0;
        html_url = in.readString();
        description = in.readString();
        fork = in.readByte() != 0;
        url = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        pushed_at = in.readString();
        git_url = in.readString();
        ssh_url = in.readString();
        clone_url = in.readString();
        svn_url = in.readString();
        homepage = in.readString();
        size = in.readInt();
        stargazers_count = in.readInt();
        watchers_count = in.readInt();
        language = in.readString();
        has_issues = in.readByte() != 0;
        has_projects = in.readByte() != 0;
        has_downloads = in.readByte() != 0;
        has_wiki = in.readByte() != 0;
        has_pages = in.readByte() != 0;
        forks_count = in.readInt();
        mirror_url = in.readString();
        archived = in.readByte() != 0;
        open_issues_count = in.readInt();
        license = in.readString();
        forks = in.readInt();
        open_issues = in.readInt();
        watchers = in.readInt();
        default_branch = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(full_name);
        parcel.writeString(login);
        parcel.writeLong(owner_id);
        parcel.writeString(avatar_url);
        parcel.writeString(owner_url);
        parcel.writeString(owner_html_url);
        parcel.writeString(type);
        parcel.writeByte((byte) (site_admin ? 1 : 0));
        parcel.writeByte((byte) (is_private ? 1 : 0));
        parcel.writeString(html_url);
        parcel.writeString(description);
        parcel.writeByte((byte) (fork ? 1 : 0));
        parcel.writeString(url);
        parcel.writeString(created_at);
        parcel.writeString(updated_at);
        parcel.writeString(pushed_at);
        parcel.writeString(git_url);
        parcel.writeString(ssh_url);
        parcel.writeString(clone_url);
        parcel.writeString(svn_url);
        parcel.writeString(homepage);
        parcel.writeInt(size);
        parcel.writeInt(stargazers_count);
        parcel.writeInt(watchers_count);
        parcel.writeString(language);
        parcel.writeByte((byte) (has_issues ? 1 : 0));
        parcel.writeByte((byte) (has_projects ? 1 : 0));
        parcel.writeByte((byte) (has_downloads ? 1 : 0));
        parcel.writeByte((byte) (has_wiki ? 1 : 0));
        parcel.writeByte((byte) (has_pages ? 1 : 0));
        parcel.writeInt(forks_count);
        parcel.writeString(mirror_url);
        parcel.writeByte((byte) (archived ? 1 : 0));
        parcel.writeInt(open_issues_count);
        parcel.writeString(license);
        parcel.writeInt(forks);
        parcel.writeInt(open_issues);
        parcel.writeInt(watchers);
        parcel.writeString(default_branch);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getOwner_url() {
        return owner_url;
    }

    public void setOwner_url(String owner_url) {
        this.owner_url = owner_url;
    }

    public String getOwner_html_url() {
        return owner_html_url;
    }

    public void setOwner_html_url(String owner_html_url) {
        this.owner_html_url = owner_html_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSite_admin() {
        return site_admin;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public boolean isIs_private() {
        return is_private;
    }

    public void setIs_private(boolean is_private) {
        this.is_private = is_private;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public String getSsh_url() {
        return ssh_url;
    }

    public void setSsh_url(String ssh_url) {
        this.ssh_url = ssh_url;
    }

    public String getClone_url() {
        return clone_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    public String getSvn_url() {
        return svn_url;
    }

    public void setSvn_url(String svn_url) {
        this.svn_url = svn_url;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(int watchers_count) {
        this.watchers_count = watchers_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHas_issues() {
        return has_issues;
    }

    public void setHas_issues(boolean has_issues) {
        this.has_issues = has_issues;
    }

    public boolean isHas_projects() {
        return has_projects;
    }

    public void setHas_projects(boolean has_projects) {
        this.has_projects = has_projects;
    }

    public boolean isHas_downloads() {
        return has_downloads;
    }

    public void setHas_downloads(boolean has_downloads) {
        this.has_downloads = has_downloads;
    }

    public boolean isHas_wiki() {
        return has_wiki;
    }

    public void setHas_wiki(boolean has_wiki) {
        this.has_wiki = has_wiki;
    }

    public boolean isHas_pages() {
        return has_pages;
    }

    public void setHas_pages(boolean has_pages) {
        this.has_pages = has_pages;
    }

    public int getForks_count() {
        return forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }

    public String getMirror_url() {
        return mirror_url;
    }

    public void setMirror_url(String mirror_url) {
        this.mirror_url = mirror_url;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public int getOpen_issues_count() {
        return open_issues_count;
    }

    public void setOpen_issues_count(int open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }
}
