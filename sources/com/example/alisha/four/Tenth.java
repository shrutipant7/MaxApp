package com.example.alisha.four;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Tenth extends AppCompatActivity {
    Button t1;
    Button t2;
    Button t3;
    TextView textView14;

    /* renamed from: com.example.alisha.four.Tenth$1 */
    class C03321 implements OnClickListener {
        C03321() {
        }

        public void onClick(View view) {
            Tenth.this.startActivity(new Intent(Tenth.this, Tenth1.class));
        }
    }

    /* renamed from: com.example.alisha.four.Tenth$2 */
    class C03332 implements OnClickListener {
        C03332() {
        }

        public void onClick(View view) {
            Tenth.this.startActivity(new Intent(Tenth.this, Tenth2.class));
        }
    }

    /* renamed from: com.example.alisha.four.Tenth$3 */
    class C03343 implements OnClickListener {
        C03343() {
        }

        public void onClick(View view) {
            Tenth.this.startActivity(new Intent(Tenth.this, Tenth3.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_tenth);
        this.textView14 = (TextView) findViewById(C0325R.id.textView14);
        this.textView14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t1 = (Button) findViewById(C0325R.id.btn0);
        this.t1.setOnClickListener(new C03321());
        this.t2 = (Button) findViewById(C0325R.id.btn00);
        this.t2.setOnClickListener(new C03332());
        this.t3 = (Button) findViewById(C0325R.id.btn000);
        this.t3.setOnClickListener(new C03343());
    }
}
