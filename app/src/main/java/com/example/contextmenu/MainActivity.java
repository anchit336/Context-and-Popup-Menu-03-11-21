package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,button2);
                popupMenu.getMenuInflater().inflate(R.menu.c_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.cm1:
                                Toast.makeText(getApplicationContext(), "This is Home menu", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.cm2:
                                Toast.makeText(getApplicationContext(), "This is Insert menu", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.cm3:
                                Toast.makeText(getApplicationContext(), "This is Update menu", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        registerForContextMenu(button1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.c_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int itemid;

        itemid = item.getItemId();

        if (itemid == R.id.cm1)
            Toast.makeText(this, "This is Home menu", Toast.LENGTH_SHORT).show();
        if (itemid == R.id.cm2)
            Toast.makeText(this, "This is Insert menu", Toast.LENGTH_SHORT).show();
        if (itemid == R.id.cm3)
            Toast.makeText(this, "This is Update menu", Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}