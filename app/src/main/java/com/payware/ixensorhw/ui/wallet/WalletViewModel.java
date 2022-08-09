package com.payware.ixensorhw.ui.wallet;

import static com.payware.ixensorhw.api.RetrofitManager.STATUS_SUCCESS;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.payware.ixensorhw.api.RetrofitManager;
import com.payware.ixensorhw.api.UserInfoAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WalletViewModel extends ViewModel {

    private final MutableLiveData<String> userName;


    public WalletViewModel() {
        userName = new MutableLiveData<>();
    }


    public void getUserInfo(String token) {
        RetrofitManager.getRetrofitClient().getUserInfo(token).enqueue(new Callback<UserInfoAPI>() {
            @Override
            public void onResponse(Call<UserInfoAPI> call, Response<UserInfoAPI> response) {
                UserInfoAPI userInfoAPI = response.body();
                if (userInfoAPI.getStatus() == STATUS_SUCCESS) {
                    String name = userInfoAPI.getUserInfo().getFirstName() + " " + userInfoAPI.getUserInfo().getLastName();
                    userName.setValue(name);

                }
            }

            @Override
            public void onFailure(Call<UserInfoAPI> call, Throwable t) {

            }
        });
    }


    public LiveData<String> getUserName ()
    {
        return userName;
    }
}


