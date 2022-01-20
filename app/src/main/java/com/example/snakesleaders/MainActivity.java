package com.example.snakesleaders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button snakeGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snakeGame = (Button) findViewById(R.id.snakeStart);

        snakeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSnakeGame();
            }
        });
    }

    private void startSnakeGame(){
        Intent intent = new Intent( this, SnakeLeader.class);
        startActivity(intent);
    }
}