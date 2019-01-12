package com.example.alisha.four;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Nine extends AppCompatActivity {
    Button t1;
    Button t2;
    Button t3;

    /* renamed from: com.example.alisha.four.Nine$1 */
    class C03221 implements OnClickListener {
        C03221() {
        }

        public void onClick(View view) {
            Nine.this.startActivity(new Intent(Nine.this, Nine1.class));
        }
    }

    /* renamed from: com.example.alisha.four.Nine$2 */
    class C03232 implements OnClickListener {
        C03232() {
        }

        public void onClick(View view) {
            Nine.this.startActivity(new Intent(Nine.this, Nine2.class));
        }
    }

    /* renamed from: com.example.alisha.four.Nine$3 */
    class C03243 implements OnClickListener {
        C03243() {
        }

        public void onClick(View view) {
            Nine.this.startActivity(new Intent(Nine.this, Nine3.class));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_nine);
        this.t1 = (Button) findViewById(C0325R.id.btn0);
        this.t1.setOnClickListener(new C03221());
        this.t2 = (Button) findViewById(C0325R.id.btn00);
        this.t2.setOnClickListener(new C03232());
        this.t3 = (Button) findViewById(C0325R.id.btn000);
        this.t3.setOnClickListener(new C03243());
    }
}
