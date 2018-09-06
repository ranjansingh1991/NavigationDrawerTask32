package com.semicolonindia.navigationdrawertask3.drawer;

/**
 * Created by RANJAN SINGH on 8/19/2017.
 */

public class NavDrawerPojo {

    private boolean showNotify;
    private String title;

    public NavDrawerPojo() {

    }
    public NavDrawerPojo(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}