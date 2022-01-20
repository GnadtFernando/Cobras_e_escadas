package com.example.snakesleaders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SnakeLeader extends AppCompatActivity {

    Button player1, player2;
    TextView viewer;
    ImageButton redButton, blueButton;
    ImageView layout;
    int randomNumber;
    float side = 5.0F;
    float xLayout, yLayout, increment;
    float x1, x2, x3, x4, x5, x6, x7, x8, x9, x10;
    float y1, y2, y3, y4, y5, y6, y7, y8, y9, y10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_leader);

        player1 = (Button) findViewById(R.id.dado1);
        player2 = (Button) findViewById(R.id.dado2);
        viewer = (TextView) findViewById(R.id.viewer);
        redButton = (ImageButton) findViewById(R.id.redButton);
        blueButton = (ImageButton) findViewById(R.id.blueButton);
        layout = (ImageView) findViewById(R.id.snakeLayout);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                xLayout = layout.getX();
                yLayout = layout.getY();

                float xPercent = layout.getWidth() * 0.033F;
                x1 = xLayout + xPercent;
                x10 = x1 + layout.getWidth() - xPercent * 2 - blueButton.getWidth();
                increment = (x10 - x1) / 9F;

                x2 = x1 + increment;
                x3 = x2 + increment;
                x4 = x3 + increment;
                x5 = x4 + increment;
                x6 = x5 + increment;
                x7 = x6 + increment;
                x8 = x7 + increment;
                x9 = x8 + increment;
                x10 = x9 + increment;

                y10 = yLayout;
                y1 = yLayout + layout.getWidth() - blueButton.getHeight() - xPercent;
                y9 = y10 + increment;
                y8 = y9 + increment;
                y7 = y8 + increment;
                y6 = y7 + increment;
                y5 = y6 + increment;
                y4 = y5 + increment;
                y3 = y4 + increment;
                y2 = y3 + increment;
                redButton.setX(x1);
                redButton.setY(y1);


            }
        },10);

        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RandomNumber();
                PlaceUpdate(redButton);
            }
        });
    }

    private void RandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(6)+1;
        viewer.setText(randomNumber + "");
    }

    private void PlaceUpdate(ImageButton button) {
        float buttonX,buttonY;
        for (int i = 0; i < randomNumber; i++) {

            buttonX = button.getX();
            buttonY = button.getY();

            if (buttonY > y1 - side && buttonY < y1 + side) {
                if (buttonX < x10 - side)
                    buttonX += increment;
                else if (buttonX > x10 - side && buttonX < x10 + side)
                    buttonY -= increment;
            } else if (buttonY > y2 - side && buttonY < y2 + side) {
                if (buttonX > x1 + side)
                    buttonX += increment;
                else if (buttonX > x1 - side && buttonX < x10 + side)
                    buttonY += increment;
            } else if (buttonY > y3 - side && buttonY < y3 + side) {
                if (buttonX < x10 - side)
                    buttonX += increment;
                else if (buttonX > x10 - side && buttonX < x10 + side)
                    buttonY -= increment;
            } else if (buttonY > y4 - side && buttonY < y4 + side) {
                if (buttonX > x1 + side)
                    buttonX += increment;
                else if (buttonX > x1 - side && buttonX < x10 + side)
                    buttonY += increment;
            } else if (buttonY > y5 - side && buttonY < y5 + side) {
                if (buttonX < x10 - side)
                    buttonX += increment;
                else if (buttonX > x10 - side && buttonX < x10 + side)
                    buttonY -= increment;
            } else if (buttonY > y6 - side && buttonY < y6 + side) {
                if (buttonX > x1 + side)
                    buttonX += increment;
                else if (buttonX > x1 - side && buttonX < x10 + side)
                    buttonY += increment;
            } else if (buttonY > y7 - side && buttonY < y7 + side) {
                if (buttonX < x10 - side)
                    buttonX += increment;
                else if (buttonX > x10 - side && buttonX < x10 + side)
                    buttonY -= increment;
            } else if (buttonY > y8 - side && buttonY < y8 + side) {
                if (buttonX > x1 + side)
                    buttonX += increment;
                else if (buttonX > x1 - side && buttonX < x10 + side)
                    buttonY += increment;
            } else if (buttonY > y9 - side && buttonY < y9 + side) {
                if (buttonX < x10 - side)
                    buttonX += increment;
                else if (buttonX > x10 - side && buttonX < x10 + side)
                    buttonY -= increment;
            } else if (buttonY > y10 - side && buttonY < y10 + side) {
                if (buttonX > x1 + side)
                    buttonX -= increment;
            }
            button.setX(buttonX);
            button.setY(buttonY);
        }
    }
}