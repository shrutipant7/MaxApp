package com.example.alisha.four;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    TextView tv;

    /* renamed from: com.example.alisha.four.MainActivity$1 */
    class C03211 extends Thread {
        C03211() {
        }

        public void run() {
            try {
                C03211.sleep(4000);
            } catch (Exception e) {
            } finally {
                MainActivity.this.startActivity(new Intent(MainActivity.this, First.class));
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_main);
        new C03211().start();
        AnimationSet snowMov1 = new AnimationSet(true);
        RotateAnimation rotate1 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotate1.setStartOffset(80);
        rotate1.setDuration(600);
        rotate1.setRepeatCount(4);
        snowMov1.addAnimation(rotate1);
        TranslateAnimation trans1 = new TranslateAnimation(2, 0.3f, 2, 0.1f, 2, 0.9f, 2, 0.0f);
        trans1.setDuration(3500);
        trans1.setRepeatCount(0);
        snowMov1.addAnimation(trans1);
        ((ImageView) findViewById(C0325R.id.im)).startAnimation(snowMov1);
        this.tv = (TextView) findViewById(C0325R.id.tv);
        this.tv.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/duo.ttf"));
        try {
            AssetFileDescriptor afd = getAssets().openFd("backmus.mp3");
            this.player = new MediaPlayer();
            this.player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            this.player.setLooping(true);
            this.player.prepare();
            this.player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.player != null) {
            try {
                this.player.stop();
                this.player.release();
            } finally {
                this.player = null;
            }
        }
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}
