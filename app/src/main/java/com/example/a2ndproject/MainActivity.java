package com.example.a2ndproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AlertDialog.Builder alertDialogBuilder;
    private ArrayAdapter arrayAdapter;
    private String [] all_practice_name;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        listView = (ListView)findViewById(R.id.all_practice_list_id);

        all_practice_name = getResources().getStringArray(R.array.practice_title);
        arrayAdapter = new ArrayAdapter(MainActivity.this,R.layout.practice_list_view_resource,R.id.all_practice_list_resource_id,all_practice_name);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String practice_name = (String) arrayAdapter.getItem(position);
        Intent intent = new Intent(getApplicationContext(),Project_information.class);
        intent.putExtra("Key",practice_name);
        startActivity(intent);
        /*Toast.makeText(getApplicationContext(),practice_name,Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_resource,menu);

        MenuItem menuItem = menu.findItem(R.id.search_button_id);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String queryTextInside) {
                arrayAdapter.getFilter().filter(queryTextInside);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }





    @Override
    public void onBackPressed() {
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setIcon(R.drawable.twond_project_logo_icon);
        alertDialogBuilder.setTitle("Warning");
        alertDialogBuilder.setMessage("Are you sure?");
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilder.create().show();
    }
}