package com.example.srmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.srmusicplayer.databinding.ActivityMusicPlayerBinding;

public class MusicPlayerActivity extends AppCompatActivity {

    ActivityMusicPlayerBinding binding;
    MediaPlayer mediaPlayer;
    int playingPosition=0;

    Integer [] allMusic={R.raw.dimaak,R.raw.majnu,R.raw.menina,R.raw.raavana,R.raw.written};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMusicPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.playBtn.setOnClickListener(v-> {

            if(binding.playBtn.getTag().equals("play")){
                playMusic(playingPosition);
                binding.playBtn.setTag("pause");

            }else{
                binding.playBtn.setTag("play");
                binding.playBtn.setImageResource(R.drawable.ic_play_24);
                mediaPlayer.pause();



            }



        });

        //binding.pauseBtn.setOnClickListener(v-> {
           // binding.playBtn.setImageResource(R.drawable.ic_play_24);
           // mediaPlayer.pause();

        //});

        binding.stopBtn.setOnClickListener(v-> {

            mediaPlayer.stop();

        });

        binding.nextBtn.setOnClickListener(v-> {

            if(playingPosition<allMusic.length-1){
                playingPosition++;
                playMusic(playingPosition);

            }else{

                Toast.makeText(this, "All Music has been played", Toast.LENGTH_SHORT).show();
                
            }

binding.playBtn.setTag("play");


        });


        binding.prevBtn.setOnClickListener(v-> {
            playingPosition--;
            playMusic(playingPosition);


        });


    }

    private void playMusic(int playingPosition) {

        if(mediaPlayer!=null ){
            mediaPlayer.pause();
            mediaPlayer.stop();
            mediaPlayer.release();

            mediaPlayer=MediaPlayer.create(this,allMusic[playingPosition]);
            mediaPlayer.start();
            binding.playBtn.setImageResource(R.drawable.ic_pause_24);
        }else{

            mediaPlayer=MediaPlayer.create(this,allMusic[playingPosition]);
            mediaPlayer.start();
            binding.playBtn.setImageResource(R.drawable.ic_pause_24);

        }




    }
}