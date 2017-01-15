package com.example.symmt.timestamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.symmt.timestamp.R;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btnCurrent);
        btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView txtResult = (TextView) findViewById(R.id.txtResult);
                    txtResult.setText(new Date().toString());

                    Toast toast = Toast.makeText(
                        MainActivity.this, new Date().toString(), Toast.LENGTH_LONG
                    );
                    toast.show();
                    Log.d("CurrentTime", new Date().toString());
                }
            }
        );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        outState.putString("txtResult", txtResult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        txtResult.setText(savedInstanceState.getString("txtResult"));
    }
}