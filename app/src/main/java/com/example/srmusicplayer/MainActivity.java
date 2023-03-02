package com.example.srmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.srmusicplayer.databinding.ActivityMainBinding;
import com.example.srmusicplayer.databinding.ActivityMusicPlayerBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.musicBtn.setOnClickListener(v->{

            Intent intent = new Intent(MainActivity.this,MusicPlayerActivity.class);
            startActivity(intent);




        });



    }
}