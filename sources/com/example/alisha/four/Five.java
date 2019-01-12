package com.example.alisha.four;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Five extends AppCompatActivity {
    Button t1;
    Button t2;
    Button t3;
    TextView textView77;

    /* renamed from: com.example.alisha.four.Five$1 */
    class C03151 implements OnClickListener {
        C03151() {
        }

        public void onClick(View view) {
            Five.this.startActivity(new Intent(Five.this, Five1.class));
        }
    }

    /* renamed from: com.example.alisha.four.Five$2 */
    class C03162 implements OnClickListener {
        C03162() {
        }

        public void onClick(View view) {
            Five.this.startActivity(new Intent(Five.this, Five2.class));
        }
    }

    /* renamed from: com.example.alisha.four.Five$3 */
    class C03173 implements OnClickListener {
        C03173() {
        }

        public void onClick(View view) {
            Five.this.startActivity(new Intent(Five.this, Five3.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_five);
        this.textView77 = (TextView) findViewById(C0325R.id.textView77);
        this.textView77.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t1 = (Button) findViewById(C0325R.id.button33);
        this.t1.setOnClickListener(new C03151());
        this.t2 = (Button) findViewById(C0325R.id.button22);
        this.t2.setOnClickListener(new C03162());
        this.t3 = (Button) findViewById(C0325R.id.button);
        this.t3.setOnClickListener(new C03173());
    }
}
