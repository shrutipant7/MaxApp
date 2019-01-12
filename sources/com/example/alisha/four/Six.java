package com.example.alisha.four;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Six extends AppCompatActivity {
    Button t1;
    Button t2;
    Button t3;
    TextView textView14;

    /* renamed from: com.example.alisha.four.Six$1 */
    class C03291 implements OnClickListener {
        C03291() {
        }

        public void onClick(View view) {
            Six.this.startActivity(new Intent(Six.this, Six1.class));
        }
    }

    /* renamed from: com.example.alisha.four.Six$2 */
    class C03302 implements OnClickListener {
        C03302() {
        }

        public void onClick(View view) {
            Six.this.startActivity(new Intent(Six.this, Six2.class));
        }
    }

    /* renamed from: com.example.alisha.four.Six$3 */
    class C03313 implements OnClickListener {
        C03313() {
        }

        public void onClick(View view) {
            Six.this.startActivity(new Intent(Six.this, Six3.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_six);
        this.t1 = (Button) findViewById(C0325R.id.btn1);
        this.t1.setOnClickListener(new C03291());
        this.textView14 = (TextView) findViewById(C0325R.id.textView14);
        this.textView14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t2 = (Button) findViewById(C0325R.id.btn2);
        this.t2.setOnClickListener(new C03302());
        this.t3 = (Button) findViewById(C0325R.id.btn3);
        this.t3.setOnClickListener(new C03313());
    }
}
