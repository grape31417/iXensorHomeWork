package com.payware.ixensorhw.api;

import com.google.gson.annotations.SerializedName;

/**
 * Description :
 *
 * @author 498g0
 * @date 2022/8/9
 */

public class UserInfoAPI {


    @SerializedName("status")
    private Integer status;
    @SerializedName("user_info")
    private UserInfo userInfo;


    public static class UserInfo {
        @SerializedName("mail")
        private String mail;
        @SerializedName("first_name")
        private String firstName;
        @SerializedName("last_name")
        private String lastName;

        public String getMail() {
            return mail;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
