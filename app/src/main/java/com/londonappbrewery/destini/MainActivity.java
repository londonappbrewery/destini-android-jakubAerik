package com.londonappbrewery.destini;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyTextView;
    Button buttonTop;
    Button buttonBottom;
    Button buttonPlayAgain;
    Button buttonEndGame;
    int mStoryIndex;
    boolean buttonTopPressed;
    boolean buttonBottomPressed;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mStoryIndex = 1;
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);

        buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
        buttonEndGame = (Button) findViewById(R.id.buttonEnd);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonTopPressed = true;
                updateStory();
                Log.i(TAG, "mStoryIndex: " + String.valueOf(mStoryIndex));
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBottomPressed = true;
                updateStory();
                Log.i(TAG, "mStoryIndex: " + String.valueOf(mStoryIndex));
            }
        });
    }

    public void updateStory() {
        switch (mStoryIndex) {
            case 1:
                if (buttonTopPressed) {
                    this.mStoryIndex = 3;
                    storyTextView.setText(R.string.T3_Story);
                    buttonTop.setText(R.string.T3_Ans1);
                    buttonBottom.setText(R.string.T3_Ans2);
                } else if (buttonBottomPressed) {
                    this.mStoryIndex = 2;
                    storyTextView.setText(R.string.T2_Story);
                    buttonTop.setText(R.string.T2_Ans1);
                    buttonBottom.setText(R.string.T2_Ans2);
                }
                break;
            case 2:
                if (buttonTopPressed) {
                    this.mStoryIndex = 3;
                    storyTextView.setText(R.string.T3_Story);
                    buttonTop.setText(R.string.T3_Ans1);
                    buttonBottom.setText(R.string.T3_Ans2);
                } else if (buttonBottomPressed) {
                    buttonBottom.setText(R.string.T4_End);
                    buttonTop.setVisibility(View.INVISIBLE);
                    buttonBottom.setVisibility(View.INVISIBLE);
                    endStory();
                }
                break;
            case 3:
                if (buttonTopPressed) {
                    storyTextView.setText(R.string.T6_End);
                    buttonTop.setVisibility(View.INVISIBLE);
                    buttonBottom.setVisibility(View.INVISIBLE);
                    endStory();
                } else if (buttonBottomPressed) {
                    storyTextView.setText(R.string.T5_End);
                    buttonTop.setVisibility(View.INVISIBLE);
                    buttonBottom.setVisibility(View.INVISIBLE);
                    endStory();
                }
                break;
        }
    }

    public void endStory() {
        buttonPlayAgain.setVisibility(View.VISIBLE);
        buttonEndGame.setVisibility(View.VISIBLE);

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });

        buttonEndGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void restart() {
        this.mStoryIndex = 1;
        storyTextView.setText(R.string.T1_Story);
        buttonTop.setText(R.string.T1_Ans1);
        buttonBottom.setText(R.string.T1_Ans2);

        // setting the answers buttons visible again
        buttonTop.setVisibility(View.VISIBLE);
        buttonBottom.setVisibility(View.VISIBLE);

        // setting PlayAgain and EndGame buttons invisible again
        buttonPlayAgain.setVisibility(View.INVISIBLE);
        buttonEndGame.setVisibility(View.INVISIBLE);

        Log.i(TAG, "After restart() index: " + String.valueOf(mStoryIndex));
    }

//     only tracking which metods has been called after set landscape mode or another activities
//     has been opened
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");

    }

    public void setmStoryIndex(int mStoryIndex) {
        this.mStoryIndex = mStoryIndex;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.i(TAG, "onCreate()");
    }
}
