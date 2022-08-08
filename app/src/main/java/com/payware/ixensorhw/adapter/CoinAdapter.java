package com.payware.ixensorhw.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.payware.ixensorhw.R;
import com.payware.ixensorhw.databinding.ItemCoinBinding;

import java.util.List;

/**
 * Description :
 *
 * @author 498g0
 * @date 2022/8/8
 */
public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinViewHolder> {

    private final List<Integer> dataList;
    private ItemCoinBinding binding;

    public CoinAdapter(List<Integer> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coin, parent, false);
        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        final String count = String.valueOf(dataList.get(position));
        binding.tvCardCounter.setText(count);

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

     class  CoinViewHolder extends RecyclerView.ViewHolder {
        public CoinViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemCoinBinding.bind(itemView);
        }
    }
}
