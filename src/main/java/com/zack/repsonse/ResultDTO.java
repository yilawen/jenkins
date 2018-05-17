package com.zack.repsonse;

public class ResultDTO<T> {
    private boolean success;
    private String message;
    private T model;

    private ResultDTO(boolean success, String message, T model) {
        this.success = success;
        this.message = message;
        this.model = model;
    }

    public static <T> ResultDTO<T> success(T model) {
        return new ResultDTO<>(true, null, model);
    }

    public static <T> ResultDTO<T> success(String message) {
        return new ResultDTO<>(true, message, null);
    }

    public static <T> ResultDTO<T> success(T model, String message) {
        return new ResultDTO<>(true, message, model);
    }

    public static <T> ResultDTO<T> fail(T model) {
        return new ResultDTO<>(false, null, model);
    }

    public static <T> ResultDTO<T> fail(String message) {
        return new ResultDTO<>(false, message, null);
    }

    public static <T> ResultDTO<T> fail(T model, String message) {
        return new ResultDTO<>(false, message, model);
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
