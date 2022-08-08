package com.payware.ixensorhw.ui.coin;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.payware.ixensorhw.R;
import com.payware.ixensorhw.adapter.CoinAdapter;
import com.payware.ixensorhw.databinding.FragmentChatBinding;
import com.payware.ixensorhw.databinding.FragmentCoinBinding;
import com.payware.ixensorhw.databinding.FragmentWalletBinding;
import com.payware.ixensorhw.ui.wallet.WalletViewModel;

import java.util.List;

public class CoinFragment extends Fragment {

    private FragmentCoinBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CoinViewModel coinViewModel = new ViewModelProvider(this).get(CoinViewModel.class);

        binding = FragmentCoinBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        coinViewModel.cardData.observe(getViewLifecycleOwner(), this::initRecycleView);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecycleView(List cardDataList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvCoin.setLayoutManager(linearLayoutManager);
        CoinAdapter adapter = new CoinAdapter(cardDataList);
        binding.rvCoin.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


}