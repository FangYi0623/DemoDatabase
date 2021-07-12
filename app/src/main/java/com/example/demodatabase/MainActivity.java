package com.example.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ListView lv;
    ArrayList<Task> al;
    ArrayAdapter<Task> aa;
    EditText etDescription, etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        btnInsert = findViewById(R.id.btnInsert);
        tvResults = findViewById(R.id.tvResults);
        etDate = findViewById(R.id.etDate);
        etDescription = findViewById(R.id.etDescription);

        al = new ArrayList<>();
        aa = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask(etDescription.getText().toString(), etDate.getText().toString());
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the activity's Context
                DBHelper dbh = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> tasks = dbh.getTaskContent();

                String txt = "";
                for (int i = 0; i < tasks.size(); i++) {
                    txt += i + ". " + tasks.get(i) + "\n";
                }
                tvResults.setText(txt);

                al.clear();
                al.addAll(dbh.getTasks());
                aa.notifyDataSetChanged();
            }
        });
    }
}