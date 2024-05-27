package com.example.newloginform;

import android.graphics.Bitmap;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class ProfileView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_view);
        // Get the information from the Intent in MainActivity
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        Bitmap image = getIntent().getParcelableExtra("image");

        // Find the views in the layout
        TextView usernameTextView = findViewById(R.id.usernameTextView);
        TextView passwordTextView = findViewById(R.id.passwordTextView);
        ImageView profileImageView = findViewById(R.id.profileImageView);

        // Set the data to the views
        usernameTextView.setText("Username: " + username);
        passwordTextView.setText("Password: " + password);
        profileImageView.setImageBitmap(image);

}
    }
