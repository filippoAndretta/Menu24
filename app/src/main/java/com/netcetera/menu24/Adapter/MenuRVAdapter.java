package com.netcetera.menu24.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.netcetera.menu24.Model.MenuModal;
import com.netcetera.menu24.R;

import java.util.ArrayList;

public class MenuRVAdapter extends RecyclerView.Adapter<MenuRVAdapter.ViewHolder> {

    private ArrayList<MenuModal> menuModalArrayList;
    private Context context;

    public MenuRVAdapter(ArrayList<MenuModal> menuModalArrayList, Context context) {
        this.menuModalArrayList = menuModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuModal modal = menuModalArrayList.get(position);
        holder.menuNameTv.setText(modal.getMenuName());
        holder.menuInhaltTv.setText(modal.getMenuInhalt());
        holder.menuPriceTv.setText(modal.getMenuPrice());
    }

    @Override
    public int getItemCount() {
        return menuModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView menuNameTv, menuInhaltTv, menuPriceTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            menuNameTv = itemView.findViewById(R.id.idTVMenuName);
            menuInhaltTv = itemView.findViewById(R.id.idTVMenuInhalt);
            menuPriceTv = itemView.findViewById(R.id.idTVMenuPrice);
        }
    }
}