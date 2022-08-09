package com.payware.ixensorhw.api;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Description :
 *
 * @author 498g0
 * @date 2022/8/9
 */

public class RespondAPI {

    private int status;
    private String token;
    private String error;


    public int getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public String getError() {
        return error;
    }

}
