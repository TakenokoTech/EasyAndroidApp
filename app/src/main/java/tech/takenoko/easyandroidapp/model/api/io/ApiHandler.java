package tech.takenoko.easyandroidapp.model.api.io;

public interface ApiHandler<T> {
    void success(T model);
    void failure();
}
