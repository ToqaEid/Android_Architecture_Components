package com.aboughalymotors.lifecyclearchitecturedemo.model.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Toqa on 9/26/2017.
 */

public class GeneralResponseError {

    @SerializedName("id")
    private int errorId;

    @SerializedName("message")
    private String errorMsg;

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
