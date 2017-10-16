package com.example.p3750852.conversation;

import android.location.Location;

/**
 * Created by P3750852 on 2017.08.24..
 */

public class Device {
    private String deviceToken;
    private Boolean enablePrivateMessageNotification;
    private Location location;
    private Double distanceIn;
    private Double distanceOut;
    private String language;

    public Device() {
    }

    public Device(String oneSignalId, Location location, Double distanceIn, Double distanceOut, String language) {
        this.deviceToken = oneSignalId;
        this.location = location;
        this.distanceIn = distanceIn;
        this.distanceOut = distanceOut;
        this.language = language;
    }

    public Boolean getEnablePrivateMessageNotification() {
        return enablePrivateMessageNotification;
    }

    public void setEnablePrivateMessageNotification(Boolean enablePrivateMessageNotification) {
        this.enablePrivateMessageNotification = enablePrivateMessageNotification;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getDistanceIn() {
        return distanceIn;
    }

    public void setDistanceIn(Double distanceIn) {
        this.distanceIn = distanceIn;
    }

    public Double getDistanceOut() {
        return distanceOut;
    }

    public void setDistanceOut(Double distanceOut) {
        this.distanceOut = distanceOut;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
