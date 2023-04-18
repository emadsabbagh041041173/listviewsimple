package com.example.listviewsimple;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.my_list_view);
        // Create an ArrayAdapter for the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                new String[]{"Item 1", "Item 2", "Item 3"}
        );

        // Set the ArrayAdapter on the ListView
        listView.setAdapter(adapter);

        // Set an onItemClickListener on the ListView
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            Toast.makeText(MainActivity.this, selectedItem + " clicked!", Toast.LENGTH_SHORT).show();
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) { // check if the first item was clicked
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com"));
                    startActivity(browserIntent);
                } else {
                    String selectedItem = (String) parent.getItemAtPosition(position);
                    Toast.makeText(MainActivity.this, selectedItem + " clicked!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

