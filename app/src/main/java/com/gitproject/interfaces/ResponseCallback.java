package com.gitproject.interfaces;

public interface ResponseCallback {
    void onSuccess(int type, Object... object);
    void onError(Exception exception);
}
