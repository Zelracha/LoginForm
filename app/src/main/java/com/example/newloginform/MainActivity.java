package com.example.newloginform;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    Button btnimagepick, login;
    EditText username, password;
    Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars =
                    insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnimagepick = (findViewById(R.id.btnpickimage));
        btnimagepick.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent cameraIntent = new
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, 22);
        }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 22 && resultCode==RESULT_OK) {
            ImageView imgView = findViewById(R.id.imgView);
            img = (Bitmap) data.getExtras().get("data"); // Retrieve the bitmap
            imgView.setImageBitmap(img); // Set the bitmap to the ImageVieWW
        }
        else
        {
            Toast.makeText(this, "The process has been cancelled", Toast.LENGTH_LONG).show();
        }

        login = findViewById(R.id.btnlogin);
        username = findViewById(R.id.txtusername);
        password = findViewById(R.id.txtpassword);

        login.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pw = password.getText().toString();
            // VARIABLE FOR THE CORRECT LOGIN AND PASSWORD
            String us = "Raizel";
            String pws = "Pogi";
            // CHECK IF THE IMAGE IS NULL
            if (user.isEmpty() || pw.isEmpty() || img == null) {
                Toast.makeText(MainActivity.this, "Missing fields or no image selected", Toast.LENGTH_SHORT).show();
            } else {
                if (user.equals(us) && pw.equals(pws)) {
                    Toast.makeText(MainActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Unsuccessful Login", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}