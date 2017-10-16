package com.example.p3750852.conversation.models;

/**
 * Created by Patrik on 2017. 03. 17..
 */
public class ErrorWrapper {
    private String errorCode;
    private int httpStatus;
    private String message;

    public ErrorWrapper() {
    }

    public ErrorWrapper(String errorCode, int httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean loginRequired() {
        if (errorCode != null) {
            if (errorCode.equals("1.1") || errorCode.equals("1.2") || errorCode.equals("1.4")) {
                return true;
            }
        }
        return false;
    }
}
