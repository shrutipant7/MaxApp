package com.example.alisha.four;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class First extends AppCompatActivity {
    Button t1;
    Button t2;
    TextView textView2;
    TextView textView5;

    /* renamed from: com.example.alisha.four.First$1 */
    class C03131 implements OnClickListener {
        C03131() {
        }

        public void onClick(View view) {
            First.this.startActivity(new Intent(First.this, SecondActivity.class));
        }
    }

    /* renamed from: com.example.alisha.four.First$2 */
    class C03142 implements OnClickListener {
        C03142() {
        }

        public void onClick(View view) {
            First.this.startActivity(new Intent(First.this, ThirdActivity.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_first);
        this.textView2 = (TextView) findViewById(C0325R.id.textView2);
        this.textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.textView5 = (TextView) findViewById(C0325R.id.textView5);
        this.textView5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t1 = (Button) findViewById(C0325R.id.button11);
        this.t1.setOnClickListener(new C03131());
        this.t2 = (Button) findViewById(C0325R.id.button21);
        this.t2.setOnClickListener(new C03142());
    }
}
