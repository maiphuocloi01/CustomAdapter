package com.groupone.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.groupone.customadapter.databinding.ItemPhoneBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    Context context;
    private ArrayList<Smartphone> listPhone;

    public MyCustomAdapter(Context context, ArrayList<Smartphone> listPhone) {
        this.context = context;
        this.listPhone = listPhone;
    }

    @NonNull
    @Override
    public MyCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhoneBinding binding = ItemPhoneBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomAdapter.MyViewHolder holder, int position) {
        Smartphone sm = listPhone.get(position);

        holder.binding.tvName.setText(sm.getName());
        holder.binding.tvPrice.setText(convertPrice(sm.getPrice()));
        holder.binding.tvType.setText(sm.getType());
        if(sm.getOperation() == 1){
            holder.binding.ivPhoto.setImageResource(R.drawable.ic_android);
        }
    }

    @Override
    public int getItemCount() {
        return listPhone.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemPhoneBinding binding;
        public MyViewHolder(ItemPhoneBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static String convertPrice(double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(price) + "₫";
    }
}
