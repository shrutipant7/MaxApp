package com.example.alisha.four;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Eleventh extends AppCompatActivity {
    Button t1;
    Button t2;
    Button t3;
    TextView textView14;

    /* renamed from: com.example.alisha.four.Eleventh$1 */
    class C03101 implements OnClickListener {
        C03101() {
        }

        public void onClick(View view) {
            Eleventh.this.startActivity(new Intent(Eleventh.this, Eleven1.class));
        }
    }

    /* renamed from: com.example.alisha.four.Eleventh$2 */
    class C03112 implements OnClickListener {
        C03112() {
        }

        public void onClick(View view) {
            Eleventh.this.startActivity(new Intent(Eleventh.this, Eleven2.class));
        }
    }

    /* renamed from: com.example.alisha.four.Eleventh$3 */
    class C03123 implements OnClickListener {
        C03123() {
        }

        public void onClick(View view) {
            Eleventh.this.startActivity(new Intent(Eleventh.this, Eleven3.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_eleventh);
        this.textView14 = (TextView) findViewById(C0325R.id.textView14);
        this.textView14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t1 = (Button) findViewById(C0325R.id.bb);
        this.t1.setOnClickListener(new C03101());
        this.t2 = (Button) findViewById(C0325R.id.bbb);
        this.t2.setOnClickListener(new C03112());
        this.t3 = (Button) findViewById(C0325R.id.bbbb);
        this.t3.setOnClickListener(new C03123());
    }
}
