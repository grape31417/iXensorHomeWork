package com.payware.ixensorhw.ui.coin;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CoinViewModel extends ViewModel {
   public MutableLiveData<List<Integer>> cardData;

    public CoinViewModel() {
        cardData = new MutableLiveData<>();
        List<Integer> cardDataList=new ArrayList<>();
        for (int i=0 ;i<5;i++)
        {
            cardDataList.add(i);
        }
        cardData.setValue(cardDataList);

    }

}