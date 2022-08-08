package com.payware.ixensorhw.ui.wallet;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.payware.ixensorhw.R;
import com.payware.ixensorhw.adapter.ViewPaperAdapter;
import com.payware.ixensorhw.databinding.FragmentPhoneBinding;
import com.payware.ixensorhw.databinding.FragmentWalletBinding;
import com.payware.ixensorhw.ui.phone.PhoneViewModel;

import java.util.List;
import java.util.Objects;

public class WalletFragment extends Fragment {

    private FragmentWalletBinding binding;
    private ViewPaperAdapter viewPaperAdapter;
    private TabLayoutMediator tabLayoutMediator;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WalletViewModel walletViewModel =
                new ViewModelProvider(this).get(WalletViewModel.class);

        binding = FragmentWalletBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewPaperAdapter = new ViewPaperAdapter(getChildFragmentManager(), getLifecycle());
        binding.vpWallet.setAdapter(viewPaperAdapter);



        tabLayoutMediator = new TabLayoutMediator(binding.tbWallet, binding.vpWallet, (tab, position) -> {
            if (position == 0)
                tab.setText("COIN");
            else
                tab.setText("COUPON");

        });


        tabLayoutMediator.attach();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tabLayoutMediator=null;
        binding = null;
    }



}