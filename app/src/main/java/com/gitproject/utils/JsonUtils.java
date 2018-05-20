package com.gitproject.utils;

import android.content.Context;

import com.gitproject.models.RepoContentModel;
import com.gitproject.models.RepoModel;
import com.gitproject.models.UserModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {


    // user keys
    private final String TAG_USER_LOGIN = "login";
    private final String TAG_USER_ID = "id";
    private final String TAG_USER_AVATAR_URL = "avatar_url";
    private final String TAG_USER_GAVATAR_ID = "gravatar_id";
    private final String TAG_USER_URL = "url";
    private final String TAG_USER_HTML_URL = "html_url";
    private final String TAG_USER_FOLLOWERS_URL = "followers_url";
    private final String TAG_USER_FOLLOWING_URL = "following_url";
    private final String TAG_USER_GISTS_URL = "gists_url";
    private final String TAG_USER_STARRED_URL = "starred_url";
    private final String TAG_USER_SUBSCRIPTIONS_URL = "subscriptions_url";
    private final String TAG_USER_ORGANIZATIONS_URL = "organizations_url";
    private final String TAG_USER_REPOS_URL = "repos_url";
    private final String TAG_USER_EVENTS_URL = "events_url";
    private final String TAG_USER_RECEIVED_EVENTS_URL = "received_events_url";
    private final String TAG_USER_TYPE = "type";
    private final String TAG_USER_SITE_ADMIN = "site_admin";
    private final String TAG_USER_NAME = "name";
    private final String TAG_USER_COMPANY = "company";
    private final String TAG_USER_BLOG = "blog";
    private final String TAG_USER_LOCATION = "location";
    private final String TAG_USER_EMAIL = "email";
    private final String TAG_USER_HIREABLE = "hireable";
    private final String TAG_USER_BIO = "bio";
    private final String TAG_USER_PUBLIC_REPOS = "public_repos";
    private final String TAG_USER_PUBLIC_GISTS = "public_gists";
    private final String TAG_USER_FOLLOWERS = "followers";
    private final String TAG_USER_FOLLOWING = "following";
    private final String TAG_USER_CREATED_AT = "created_at";
    private final String TAG_USER_UPDATED_AT = "updated_at";

    // repo keys
    private final String TAG_REPO_ID = "id";
    private final String TAG_REPO_NAMAE = "name";
    private final String TAG_REPO_FULL_NAME = "full_name";
    private final String TAG_REPO_OWNER = "owner";
    private final String TAG_REPO_LOGIN = "login";
    private final String TAG_REPO_OWNER_ID = "id";
    private final String TAG_REPO_AVATAR_URL = "avatar_url";
    private final String TAG_REPO_OWNER_URL = "url";
    private final String TAG_REPO_OWNER_HTML_URL = "html_url";
    private final String TAG_REPO_TYPE = "type";
    private final String TAG_REPO_SITE_ADMIN = "site_admin";
    private final String TAG_REPO_IS_PRIVATE = "is_private";
    private final String TAG_REPO_HTML_URL = "html_url";
    private final String TAG_REPO_DESCRIPTION = "description";
    private final String TAG_REPO_FORK = "fork";
    private final String TAG_REPO_URL = "url";
    private final String TAG_REPO_CREATED_AT = "created_at";
    private final String TAG_REPO_UPDATED_AT = "updated_at";
    private final String TAG_REPO_PUSHED_AT = "pushed_at";
    private final String TAG_REPO_GIT_URL = "git_url";
    private final String TAG_REPO_SSH_URL = "ssh_url";
    private final String TAG_REPO_CLONE_URL = "clone_url";
    private final String TAG_REPO_SVN_URL = "svn_url";
    private final String TAG_REPO_HOMEPAGE = "homepage";
    private final String TAG_REPO_SIZE = "size";
    private final String TAG_REPO_STRAGAZERS_COUNT = "stargazers_count";
    private final String TAG_REPO_WATCHERS_COUNT = "watchers_count";
    private final String TAG_REPO_LANGUAGE = "language";
    private final String TAG_REPO_HAS_ISSUES = "has_issues";
    private final String TAG_REPO_HAS_PROJECTS = "has_projects";
    private final String TAG_REPO_HAS_DOWNLOADS = "has_downloads";
    private final String TAG_REPO_HAS_WIKI = "has_wiki";
    private final String TAG_REPO_HAS_PAGES = "has_pages";
    private final String TAG_REPO_FORKS_COUNT = "forks_count";
    private final String TAG_REPO_MIRROR_COUNT = "mirror_url";
    private final String TAG_REPO_ARCHIVED = "archived";
    private final String TAG_REPO_OPEN_ISSUES_COUNT = "open_issues_count";
    private final String TAG_REPO_LICENSE = "license";
    private final String TAG_REPO_FORKS = "forks";
    private final String TAG_REPO_OPEN_ISSUES = "open_issues";
    private final String TAG_REPO_WACHERS = "watchers";
    private final String TAG_REPO_DEFAULT_BRANCH = "default_branch";

    // repo content keys
    private final String TAG_REPO_CONTENT_NAME = "name";
    private final String TAG_REPO_CONTENT_PATH = "path";
    private final String TAG_REPO_CONTENT_SHA = "sha";
    private final String TAG_REPO_CONTENT_SIZE = "size";
    private final String TAG_REPO_CONTENT_URL = "url";
    private final String TAG_REPO_CONTENT_HTML_URL = "html_url";
    private final String TAG_REPO_CONTENT_GIT_URL = "git_url";
    private final String TAG_REPO_CONTENT_DOWNLOAD_URL = "download_url";
    private final String TAG_REPO_CONTENT_TYPE = "type";
    private final String TAG_REPO_CONTENT_SELF = "self";
    private final String TAG_REPO_CONTENT_GIT = "git";
    private final String TAG_REPO_CONTENT_HTML = "html";


    private Context context;

    public JsonUtils(Context context) {
        this.context = context;
    }

    public Object[] parseGitUserInfo(JSONObject userInfoResponse) throws Exception {

        String login = "";
        long id = 0L;
        String avatar_url = "";
        String gravatar_id = "";
        String url = "";
        String html_url = "";
        String followers_url = "";
        String following_url = "";
        String gists_url = "";
        String starred_url = "";
        String subscriptions_url = "";
        String organizations_url = "";
        String repos_url = "";
        String events_url = "";
        String received_events_url = "";
        String type = "";
        boolean site_admin = false;
        String name = "";
        String company = "";
        String blog = "";
        String location = "";
        String email = "";
        boolean hireable = false;
        String bio = "";
        int public_repo = 0;
        int public_gists = 0;
        int followers = 0;
        int following = 0;
        String created_at = "";
        String updated_at = "";

        try {
            if (userInfoResponse.has(TAG_USER_LOGIN)) {
                String temp = userInfoResponse.getString(TAG_USER_LOGIN);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    login = temp;
            }
        } catch (Exception e) {
            login = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_ID)) {
                id = userInfoResponse.getInt(TAG_USER_ID);
            }
        } catch (Exception e) {
            id = -1;
        }

        try {
            if (userInfoResponse.has(TAG_USER_AVATAR_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_AVATAR_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    avatar_url = temp;
            }
        } catch (Exception e) {
            avatar_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_GAVATAR_ID)) {
                String temp = userInfoResponse.getString(TAG_USER_GAVATAR_ID);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    gravatar_id = temp;
            }
        } catch (Exception e) {
            gravatar_id = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    url = temp;
            }
        } catch (Exception e) {
            url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_HTML_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_HTML_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    html_url = temp;
            }
        } catch (Exception e) {
            html_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_FOLLOWERS_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_FOLLOWERS_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    followers_url = temp;
            }
        } catch (Exception e) {
            followers_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_FOLLOWING_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_FOLLOWING_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    following_url = temp;
            }
        } catch (Exception e) {
            following_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_GISTS_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_GISTS_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    gists_url = temp;
            }
        } catch (Exception e) {
            gists_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_STARRED_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_STARRED_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    starred_url = temp;
            }
        } catch (Exception e) {
            starred_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_SUBSCRIPTIONS_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_SUBSCRIPTIONS_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    subscriptions_url = temp;
            }
        } catch (Exception e) {
            subscriptions_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_ORGANIZATIONS_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_ORGANIZATIONS_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    organizations_url = temp;
            }
        } catch (Exception e) {
            organizations_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_REPOS_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_REPOS_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    repos_url = temp;
            }
        } catch (Exception e) {
            repos_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_EVENTS_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_EVENTS_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    events_url = temp;
            }
        } catch (Exception e) {
            events_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_RECEIVED_EVENTS_URL)) {
                String temp = userInfoResponse.getString(TAG_USER_RECEIVED_EVENTS_URL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    received_events_url = temp;
            }
        } catch (Exception e) {
            received_events_url = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_TYPE)) {
                String temp = userInfoResponse.getString(TAG_USER_TYPE);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    type = temp;
            }
        } catch (Exception e) {
            type = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_SITE_ADMIN)) {
                site_admin = userInfoResponse.getBoolean(TAG_USER_SITE_ADMIN);
            }
        } catch (Exception e) {
            site_admin = false;
        }

        try {
            if (userInfoResponse.has(TAG_USER_NAME)) {
                String temp = userInfoResponse.getString(TAG_USER_NAME);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    name = temp;
            }
        } catch (Exception e) {
            name = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_COMPANY)) {
                String temp = userInfoResponse.getString(TAG_USER_COMPANY);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    company = temp;
            }
        } catch (Exception e) {
            company = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_BLOG)) {
                String temp = userInfoResponse.getString(TAG_USER_BLOG);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    blog = temp;
            }
        } catch (Exception e) {
            blog = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_LOCATION)) {
                String temp = userInfoResponse.getString(TAG_USER_LOCATION);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    location = temp;
            }
        } catch (Exception e) {
            location = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_EMAIL)) {
                String temp = userInfoResponse.getString(TAG_USER_EMAIL);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    email = temp;
            }
        } catch (Exception e) {
            email = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_HIREABLE)) {
                hireable = userInfoResponse.getBoolean(TAG_USER_HIREABLE);
            }
        } catch (Exception e) {
            hireable = false;
        }

        try {
            if (userInfoResponse.has(TAG_USER_BIO)) {
                String temp = userInfoResponse.getString(TAG_USER_BIO);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    bio = temp;
            }
        } catch (Exception e) {
            bio = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_PUBLIC_REPOS)) {
                public_repo = userInfoResponse.getInt(TAG_USER_PUBLIC_REPOS);
            }
        } catch (Exception e) {
            public_repo = -1;
        }

        try {
            if (userInfoResponse.has(TAG_USER_PUBLIC_GISTS)) {
                public_gists = userInfoResponse.getInt(TAG_USER_PUBLIC_GISTS);
            }
        } catch (Exception e) {
            public_gists = -1;
        }

        try {
            if (userInfoResponse.has(TAG_USER_FOLLOWERS)) {
                followers = userInfoResponse.getInt(TAG_USER_FOLLOWERS);
            }
        } catch (Exception e) {
            followers = -1;
        }

        try {
            if (userInfoResponse.has(TAG_USER_FOLLOWING)) {
                following = userInfoResponse.getInt(TAG_USER_FOLLOWING);
            }
        } catch (Exception e) {
            following = -1;
        }

        try {
            if (userInfoResponse.has(TAG_USER_CREATED_AT)) {
                String temp = userInfoResponse.getString(TAG_USER_CREATED_AT);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    created_at = temp;
            }
        } catch (Exception e) {
            created_at = "";
        }

        try {
            if (userInfoResponse.has(TAG_USER_UPDATED_AT)) {
                String temp = userInfoResponse.getString(TAG_USER_UPDATED_AT);
                if (temp != null && temp.length() != 0 && !temp.equals("null"))
                    updated_at = temp;
            }
        } catch (Exception e) {
            updated_at = "";
        }

        UserModel userModel = new UserModel();
        userModel.setLogin(login);
        userModel.setId(id);
        userModel.setAvatar_url(avatar_url);
        userModel.setUrl(url);
        userModel.setHtml_url(html_url);
        userModel.setFollowers_url(followers_url);
        userModel.setFollowing_url(following_url);
        userModel.setGists_url(gists_url);
        userModel.setStarred_url(starred_url);
        userModel.setSubscriptions_url(subscriptions_url);
        userModel.setOrganizations_url(organizations_url);
        userModel.setRepos_url(repos_url);
        userModel.setEvents_url(events_url);
        userModel.setReceived_events_url(received_events_url);
        userModel.setType(type);
        userModel.setSite_admin(site_admin);
        userModel.setName(name);
        userModel.setCompany(company);
        userModel.setBlog(blog);
        userModel.setLocation(location);
        userModel.setEmail(email);
        userModel.setHireable(hireable);
        userModel.setBio(bio);
        userModel.setPublic_repo(public_repo);
        userModel.setPublic_gists(public_gists);
        userModel.setFollowers(followers);
        userModel.setFollowing(following);
        userModel.setCreated_at(created_at);
        userModel.setUpdated_at(updated_at);

        Object[] returnObject = new Object[1];
        returnObject[0] = userModel;

        return returnObject;
    }

    public Object[] parseRepoInfo(JSONArray repoInfoResponse) throws Exception {
        ArrayList<RepoModel> repoModelArrayList = new ArrayList<>();

        try {
            for (int i = 0; i < repoInfoResponse.length(); i++) {
                JSONObject repoObject = repoInfoResponse.getJSONObject(i);

                String id = "";
                String name = "";
                String full_name = "";
                int size = 0;
                int watchers_count = 0;
                int open_issues_count = 0;
                String html_url = "";

                RepoModel repoModel = new RepoModel();

                try {
                    if (repoObject.has(TAG_REPO_ID)) {
                        String temp = repoObject.getString(TAG_REPO_ID);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            id = temp;
                    }
                } catch (Exception e) {
                    id = "";
                }

                try {
                    if (repoObject.has(TAG_REPO_CONTENT_NAME)) {
                        String temp = repoObject.getString(TAG_REPO_CONTENT_NAME);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            name = temp;
                    }
                } catch (Exception e) {
                    name = "";
                }

                try {
                    if (repoObject.has(TAG_REPO_FULL_NAME)) {
                        String temp = repoObject.getString(TAG_REPO_FULL_NAME);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            full_name = temp;
                    }
                } catch (Exception e) {
                    full_name = "";
                }

//                if(repoInfoResponse.has(TAG_REPO_OWNER)) {
//
//                    JSONObject ownerObject = repoInfoResponse.getJSONObject(TAG_REPO_OWNER);
//                    try {
//                        if (ownerObject.has(TAG_USER_CREATED_AT)) {
//                            String temp = ownerObject.getString(TAG_USER_CREATED_AT);
//                            if (temp != null && temp.length() != 0 && !temp.equals("null"))
//                                login = temp;
//                        }
//                    } catch (Exception e) {
//                        login = "";
//                    }
//
//                    try {
//                        if (ownerObject.has(TAG_USER_FOLLOWERS)) {
//                            owner_id = ownerObject.getInt(TAG_USER_FOLLOWERS);
//                        }
//                    } catch (Exception e) {
//                        owner_id = 0L;
//                    }
//
//                    try {
//                        if (ownerObject.has(TAG_USER_CREATED_AT)) {
//                            String temp = ownerObject.getString(TAG_USER_CREATED_AT);
//                            if (temp != null && temp.length() != 0 && !temp.equals("null"))
//                                avatar_url = temp;
//                        }
//                    } catch (Exception e) {
//                        avatar_url = "";
//                    }
//
//                    try {
//                        if (ownerObject.has(TAG_USER_CREATED_AT)) {
//                            String temp = ownerObject.getString(TAG_USER_CREATED_AT);
//                            if (temp != null && temp.length() != 0 && !temp.equals("null"))
//                                owner_url = temp;
//                        }
//                    } catch (Exception e) {
//                        owner_url = "";
//                    }
//
//                    try {
//                        if (ownerObject.has(TAG_USER_CREATED_AT)) {
//                            String temp = ownerObject.getString(TAG_USER_CREATED_AT);
//                            if (temp != null && temp.length() != 0 && !temp.equals("null"))
//                                owner_html_url = temp;
//                        }
//                    } catch (Exception e) {
//                        owner_html_url = "";
//                    }
//
//                    try {
//                        if (ownerObject.has(TAG_USER_CREATED_AT)) {
//                            String temp = ownerObject.getString(TAG_USER_CREATED_AT);
//                            if (temp != null && temp.length() != 0 && !temp.equals("null"))
//                                type = temp;
//                        }
//                    } catch (Exception e) {
//                        type = "";
//                    }
//
//                    try {
//                        if (ownerObject.has(TAG_USER_FOLLOWERS)) {
//                            site_admin = ownerObject.getBoolean(TAG_USER_FOLLOWERS);
//                        }
//                    } catch (Exception e) {
//                        site_admin = false;
//                    }
//                }

                try {
                    if (repoObject.has(TAG_REPO_HTML_URL)) {
                        String temp = repoObject.getString(TAG_REPO_HTML_URL);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            html_url = temp;
                    }
                } catch (Exception e) {
                    html_url = "";
                }

                try {
                    if (repoObject.has(TAG_REPO_SIZE)) {
                        size = repoObject.getInt(TAG_REPO_SIZE);
                    }
                } catch (Exception e) {
                    size = 0;
                }

                try {
                    if (repoObject.has(TAG_REPO_WATCHERS_COUNT)) {
                        watchers_count = repoObject.getInt(TAG_REPO_WATCHERS_COUNT);
                    }
                } catch (Exception e) {
                    watchers_count = 0;
                }

                try {
                    if (repoObject.has(TAG_REPO_OPEN_ISSUES_COUNT)) {
                        open_issues_count = repoObject.getInt(TAG_REPO_OPEN_ISSUES_COUNT);
                    }
                } catch (Exception e) {
                    open_issues_count = 0;
                }

                repoModel.setId(id);
                repoModel.setName(name);
                repoModel.setFull_name(full_name);
                repoModel.setHtml_url(html_url);
                repoModel.setSize(size);
                repoModel.setWatchers_count(watchers_count);
                repoModel.setOpen_issues_count(open_issues_count);
                repoModelArrayList.add(repoModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[] returnObject = new Object[1];
        returnObject[0] = repoModelArrayList;

        return returnObject;
    }

    public Object[] parseRepoContentInfo(JSONArray repoContentInfoResponse) throws Exception {

        ArrayList<RepoContentModel> repoContentModelArrayList = new ArrayList<>();

        try {
            for (int i = 0; i < repoContentInfoResponse.length(); i++) {
                JSONObject repoContentObject = repoContentInfoResponse.getJSONObject(i);

                String name = "";
                String path = "";
                String sha = "";
                int size = 0;
                String url = "";
                String html_url = "";
                String type = "";

                RepoContentModel repoContentModel = new RepoContentModel();

                try {
                    if (repoContentObject.has(TAG_REPO_CONTENT_NAME)) {
                        String temp = repoContentObject.getString(TAG_REPO_CONTENT_NAME);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            name = temp;
                    }
                } catch (Exception e) {
                    name = "";
                }

                try {
                    if (repoContentObject.has(TAG_REPO_CONTENT_PATH)) {
                        String temp = repoContentObject.getString(TAG_REPO_CONTENT_PATH);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            path = temp;
                    }
                } catch (Exception e) {
                    path = "";
                }

                try {
                    if (repoContentObject.has(TAG_REPO_CONTENT_SHA)) {
                        String temp = repoContentObject.getString(TAG_REPO_CONTENT_SHA);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            sha = temp;
                    }
                } catch (Exception e) {
                    sha = "";
                }

                try {
                    if (repoContentObject.has(TAG_REPO_CONTENT_SIZE)) {
                        size = repoContentObject.getInt(TAG_REPO_CONTENT_SIZE);
                    }
                } catch (Exception e) {
                    size = 0;
                }

                try {
                    if (repoContentObject.has(TAG_REPO_CONTENT_URL)) {
                        String temp = repoContentObject.getString(TAG_REPO_CONTENT_URL);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            url = temp;
                    }
                } catch (Exception e) {
                    url = "";
                }

                try {
                    if (repoContentObject.has(TAG_REPO_CONTENT_HTML_URL)) {
                        String temp = repoContentObject.getString(TAG_REPO_CONTENT_HTML_URL);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            html_url = temp;
                    }
                } catch (Exception e) {
                    html_url = "";
                }

                try {
                    if (repoContentObject.has(TAG_REPO_CONTENT_TYPE)) {
                        String temp = repoContentObject.getString(TAG_REPO_CONTENT_TYPE);
                        if (temp != null && temp.length() != 0 && !temp.equals("null"))
                            type = temp;
                    }
                } catch (Exception e) {
                    type = "";
                }

                repoContentModel.setName(name);
                repoContentModel.setPath(path);
                repoContentModel.setSha(sha);
                repoContentModel.setSize(size);
                repoContentModel.setUrl(url);
                repoContentModel.setType(type);
                repoContentModel.setHtml_url(html_url);

                repoContentModelArrayList.add(repoContentModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[] returnObject = new Object[1];
        returnObject[0] = repoContentModelArrayList;

        return returnObject;
    }
}
