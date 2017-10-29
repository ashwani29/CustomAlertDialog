package com.example.coding.customalertdialog;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView namet, batcht, Adresst;
    AlertDialog alertDialog;
    FloatingActionButton floatingActionButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPreferences = getSharedPreferences("Myapp", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();



         floatingActionButton = (FloatingActionButton) findViewById(R.id.fb);
         button = (Button) findViewById(R.id.button);
        namet = (TextView) findViewById(R.id.Name);
        batcht = (TextView) findViewById(R.id.Batch);
        Adresst = (TextView) findViewById(R.id.Adress);

        alertDialog = new AlertDialog
                .Builder(this).setTitle("Pls enter ur details")
                .setView(R.layout.dialog)
                .setPositiveButton("submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         EditText name = (EditText) alertDialog.findViewById(R.id.name);
                        EditText batch = (EditText) alertDialog.findViewById(R.id.batch);
                        EditText Adress = (EditText) alertDialog.findViewById(R.id.adress);
                        String n=name.getText().toString();
                        String b = batch.getText().toString();
                        String a =Adress.getText().toString();
                        namet.setText(n);
                        batcht.setText(b);
                        Adresst.setText(a);

                        editor.putString("NAME", n);
                        editor.putString("ADRESS", a);
                        editor.putString("BATCH", b);
                        editor.apply();

                        Log.e("TAG", sharedPreferences.getString("NAME", null));
                    }
                })
        .create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });



    }


}
