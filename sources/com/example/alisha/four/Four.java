package com.example.alisha.four;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Four extends AppCompatActivity {
    Button t1;
    Button t2;
    Button t3;
    TextView textView7;

    /* renamed from: com.example.alisha.four.Four$1 */
    class C03181 implements OnClickListener {
        C03181() {
        }

        public void onClick(View view) {
            Four.this.startActivity(new Intent(Four.this, Four1.class));
        }
    }

    /* renamed from: com.example.alisha.four.Four$2 */
    class C03192 implements OnClickListener {
        C03192() {
        }

        public void onClick(View view) {
            Four.this.startActivity(new Intent(Four.this, Four2.class));
        }
    }

    /* renamed from: com.example.alisha.four.Four$3 */
    class C03203 implements OnClickListener {
        C03203() {
        }

        public void onClick(View view) {
            Four.this.startActivity(new Intent(Four.this, Four3.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_four);
        this.textView7 = (TextView) findViewById(C0325R.id.textView7);
        this.textView7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t1 = (Button) findViewById(C0325R.id.button3);
        this.t1.setOnClickListener(new C03181());
        this.t2 = (Button) findViewById(C0325R.id.button2);
        this.t2.setOnClickListener(new C03192());
        this.t3 = (Button) findViewById(C0325R.id.button111);
        this.t3.setOnClickListener(new C03203());
    }
}
