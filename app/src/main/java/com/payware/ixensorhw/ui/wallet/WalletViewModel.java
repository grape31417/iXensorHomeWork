package com.payware.ixensorhw.ui.wallet;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class WalletViewModel extends ViewModel {
    private final MutableLiveData<List<Integer>> cardData;

    public WalletViewModel() {
        cardData = new MutableLiveData<>();
        List<Integer> cardDataList=new ArrayList<>();
        for (int i=0 ;i<5;i++)
        {
            cardDataList.add(i);
        }
        cardData.setValue(cardDataList);

    }

    public MutableLiveData<List<Integer>> getCardData() {
        return cardData;
    }
}