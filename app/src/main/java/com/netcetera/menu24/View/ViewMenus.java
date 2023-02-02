package com.netcetera.menu24.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.netcetera.menu24.Adapter.MenuRVAdapter;
import com.netcetera.menu24.DBHandler.DBHandler;
import com.netcetera.menu24.Model.MenuModal;
import com.netcetera.menu24.R;

import java.util.ArrayList;

public class ViewMenus extends AppCompatActivity {

    private ArrayList<MenuModal> menuModalArrayList;
    private DBHandler dbHandler;
    private MenuRVAdapter menuRVAdapter;
    private RecyclerView menusRv;

    protected void onCreat(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_menus);

        menuModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewMenus.this);

        menuModalArrayList = dbHandler.readMenus();

        menuRVAdapter = new MenuRVAdapter(menuModalArrayList, ViewMenus.this);
        menusRv = findViewById(R.id.idRVMenus);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMenus.this, RecyclerView.VERTICAL, false);
        menusRv.setLayoutManager(linearLayoutManager);

        menusRv.setAdapter(menuRVAdapter);
    }
}
