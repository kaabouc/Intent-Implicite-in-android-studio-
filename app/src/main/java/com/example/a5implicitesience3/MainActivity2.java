package com.example.a5implicitesience3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
   Button camera , facebook , main , gmail, appel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        camera = findViewById(R.id.btn_camera);
        facebook= findViewById(R.id.btn_facebook);
        appel = findViewById(R.id.btn_appel);
        gmail = findViewById(R.id.btn_gmail);
        main = findViewById(R.id.btn_main);
        appel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:0612345678");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


         gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kaabouchmohamed13@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Sujet ");
                intent.putExtra(Intent.EXTRA_TEXT, "Corps de l'e-mail");

                startActivity(Intent.createChooser(intent, "Envoyer un e-mail"));
            }
        });
         facebook.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://facebook.com/"));
                 startActivity(intent);
             }
         });

         main.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:+212 708182405"));
                 intent.putExtra("sms_body", "Message texte à envoyer");
                 startActivity(intent);
             }
         });
         camera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 startActivity(takePictureIntent);
             }
         });
    }
}