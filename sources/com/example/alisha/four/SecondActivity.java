package com.example.alisha.four;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView a1;
    TextView a2;
    TextView a3;
    TextView a4;

    /* renamed from: com.example.alisha.four.SecondActivity$1 */
    class C03261 implements OnClickListener {
        C03261() {
        }

        public void onClick(View view) {
            SecondActivity.this.startActivity(new Intent(SecondActivity.this, Nine.class));
        }
    }

    /* renamed from: com.example.alisha.four.SecondActivity$2 */
    class C03272 implements OnClickListener {
        C03272() {
        }

        public void onClick(View view) {
            SecondActivity.this.startActivity(new Intent(SecondActivity.this, Tenth.class));
        }
    }

    /* renamed from: com.example.alisha.four.SecondActivity$3 */
    class C03283 implements OnClickListener {
        C03283() {
        }

        public void onClick(View view) {
            SecondActivity.this.startActivity(new Intent(SecondActivity.this, Eleventh.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_second);
        this.a1 = (TextView) findViewById(C0325R.id.textView11);
        this.a2 = (TextView) findViewById(C0325R.id.textView12);
        this.a3 = (TextView) findViewById(C0325R.id.textView);
        this.a4 = (TextView) findViewById(C0325R.id.textView13);
        this.a1 = (TextView) findViewById(C0325R.id.textView11);
        this.a1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.a2 = (TextView) findViewById(C0325R.id.textView12);
        this.a2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.a3 = (TextView) findViewById(C0325R.id.textView);
        this.a3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.a4 = (TextView) findViewById(C0325R.id.textView13);
        this.a4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.a1.setOnClickListener(new C03261());
        this.a2.setOnClickListener(new C03272());
        this.a3.setOnClickListener(new C03283());
    }
}
