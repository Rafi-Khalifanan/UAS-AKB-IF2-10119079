package com.rafi.uts10119079_dailynotes.main.profile;
//07 Juni 2022, 10119079, Rafi Khalifanan Azanan, IF2

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.rafi.uts10119079_dailynotes.R;
import com.rafi.uts10119079_dailynotes.main.diary.CategoriActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.ProfileId);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ProfileId:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.CatatanHarian:
                        startActivity(new Intent(getApplicationContext(), CategoriActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.About:
                        final Dialog dialog = new Dialog(ProfileActivity.this);

                        //Memasang Title / Judul pada Custom Dialog
                        dialog.setTitle("About");

                        //Memasang Desain Layout untuk Custom Dialog
                        dialog.setContentView(R.layout.custom_design_dialog);

                        //Memasang Listener / Aksi saat tombol OK di Klik
                        Button DialogButton = dialog.findViewById(R.id.ok);
                        DialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.show();
                        return true;
                }

                return false;
            }
        });
    }
}