package com.example.mydairy;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MineActivity extends AppCompatActivity {

    private TextView writer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mine);
        writer=(TextView)findViewById(R.id.writer);

        writer.setText(LoginActivity.username);
    }

}
