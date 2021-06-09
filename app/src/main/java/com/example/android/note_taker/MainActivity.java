package com.example.android.note_taker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText topic,notes;
Button save,load;
ShareRef ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Save_value(View view) {
        topic = (EditText)findViewById(R.id.topic);
        notes = (EditText)findViewById(R.id.content);
        ref = new ShareRef(this);
        ref.Save_data(topic.getText().toString(),notes.getText().toString());
        topic.setText("");
        notes.setText("");

    }

    public void Load_value(View view) {
        ref = new ShareRef(this);
        String value = ref.Load_Data();
        topic = (EditText)findViewById(R.id.topic);
        topic.setVisibility(View.INVISIBLE);
        notes = (EditText)findViewById(R.id.content);
        save = (Button)findViewById(R.id.save);
        save.setEnabled(false);
        load = (Button)findViewById(R.id.load);
        load.setEnabled(false);
        notes.setText(value);
    }
}