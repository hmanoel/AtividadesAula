package com.example.alunos.androidtoolbar;

import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;

import android.support.v4.view.GravityCompat;

import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBar;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import android.view.Menu;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        configureNavigationDrawer();

        configureToolbar();

        Fragment aux = new ViewItensFragment();

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frame, aux);

        transaction.addToBackStack(null);

        transaction.commit();
    }

    private void configureToolbar(){

        Toolbar top_toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(top_toolbar);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){

            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);

            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void configureNavigationDrawer(){

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navView = findViewById(R.id.navigation);

        navView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        Fragment aux = null;

                        int Id = menuItem.getItemId();

                        if (Id == R.id.action_new_item){

                            aux = new AddItemsFragment();

                        }else if(Id == R.id.action_view_items){

                            aux = new ViewItensFragment();

                        }else if(Id == R.id.settings){

                            aux = new SettingsFragment();

                        }

                        if(aux != null){

                            FragmentTransaction transaction =
                                    getSupportFragmentManager().beginTransaction();

                            transaction.replace(R.id.frame,aux);

                            transaction.commit();

                            drawerLayout.closeDrawers();

                            return true;

                        }

                        return false;

                    }
                });

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.empty_menu_comum, menu);

        return true;

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item){

        int Id = item.getItemId();

        switch (Id){

            case android.R.id.home:

                drawerLayout.openDrawer(GravityCompat.START);

                return true;

        }

        return true;

    }

}
