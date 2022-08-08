package com.payware.ixensorhw.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.payware.ixensorhw.ui.coin.CoinFragment;

import java.util.ArrayList;

/**
 * Description :
 *
 * @author 498g0
 * @date 2022/8/8
 */
public class ViewPaperAdapter extends FragmentStateAdapter {

    private ArrayList <Fragment> fragmentArrayList;

    public ViewPaperAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        fragmentArrayList= new ArrayList<>();
        fragmentArrayList.add(new CoinFragment());
        fragmentArrayList.add(new CoinFragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentArrayList.size();
    }
}
