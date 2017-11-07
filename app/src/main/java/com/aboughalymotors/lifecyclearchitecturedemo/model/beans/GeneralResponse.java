package com.aboughalymotors.lifecyclearchitecturedemo.model.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Toqa on 9/26/2017.
 */

public class GeneralResponse<T> {

    public final int SUCCESSFUL_200 = 1;
    public final int INFORMAL_100 = 2;
    public final int REDIRECTION_300 = 3;
    public final int CLIENT_ERROR_400 = 4;
    public final int SERVER_ERROR_500 = 5;

    public static final int HTTP_ERROR = 100;
    public static final int BACKEND_RESPONSE_ERROR = 300;
    public static final int RESPONSE_SUCCESS = 200;


    @SerializedName("data")
    private T model;

    @SerializedName("status")
    private int status;

    @SerializedName("errors")
    private ArrayList<GeneralResponseError> errors;

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<GeneralResponseError> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<GeneralResponseError> errors) {
        this.errors = errors;
    }
}
