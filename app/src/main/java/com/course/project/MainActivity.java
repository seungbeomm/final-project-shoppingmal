package com.course.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String myPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:01040299806"));
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });


        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

    }


    protected void sendEmail() {
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                "고객센터 문의");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "문의 내용, 이미지");
        try {
            startActivity(Intent.createChooser(emailIntent, "이메일 보내기..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(MainActivity.this, "이메일 클라이언트가 없네요.", Toast.LENGTH_SHORT).show();
        }
    }


}


