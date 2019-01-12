package com.example.alisha.four;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView t11;
    TextView t22;
    TextView t33;
    TextView t44;

    /* renamed from: com.example.alisha.four.ThirdActivity$1 */
    class C03351 implements OnClickListener {
        C03351() {
        }

        public void onClick(View view) {
            ThirdActivity.this.startActivity(new Intent(ThirdActivity.this, Four.class));
        }
    }

    /* renamed from: com.example.alisha.four.ThirdActivity$2 */
    class C03362 implements OnClickListener {
        C03362() {
        }

        public void onClick(View view) {
            ThirdActivity.this.startActivity(new Intent(ThirdActivity.this, Five.class));
        }
    }

    /* renamed from: com.example.alisha.four.ThirdActivity$3 */
    class C03373 implements OnClickListener {
        C03373() {
        }

        public void onClick(View view) {
            ThirdActivity.this.startActivity(new Intent(ThirdActivity.this, Six.class));
            ThirdActivity.this.t44 = (TextView) ThirdActivity.this.findViewById(C0325R.id.textView10);
            ThirdActivity.this.t44 = (TextView) ThirdActivity.this.findViewById(C0325R.id.textView10);
            ThirdActivity.this.t44.setTypeface(Typeface.createFromAsset(ThirdActivity.this.getAssets(), "fonts/falkin.ttf"));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0325R.layout.activity_third);
        this.t11 = (TextView) findViewById(C0325R.id.textView6);
        this.t11.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t11 = (TextView) findViewById(C0325R.id.textView6);
        this.t11.setOnClickListener(new C03351());
        this.t22 = (TextView) findViewById(C0325R.id.textView9);
        this.t22.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t22 = (TextView) findViewById(C0325R.id.textView9);
        this.t22.setOnClickListener(new C03362());
        this.t33 = (TextView) findViewById(C0325R.id.textView4);
        this.t33 = (TextView) findViewById(C0325R.id.textView4);
        this.t33.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/falkin.ttf"));
        this.t33.setOnClickListener(new C03373());
    }
}
