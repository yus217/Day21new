package com.example.yuechengshi.day21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        //String msg = intent.getCharSequenceExtra("Message").toString();


        String value1 = getIntent().getStringExtra("education");
        String value2 = getIntent().getStringExtra("skills");
        String value3 = getIntent().getStringExtra("hobbies");
        String value4 = getIntent().getStringExtra("professional");

        int imageId = getIntent().getIntExtra("image", R.drawable.img1);
        int imageId2 = getIntent().getIntExtra("image", R.drawable.img2);


        TextView txv1 = (TextView) findViewById(R.id.textView1);
        TextView txv2 = (TextView) findViewById(R.id.textView2);
        TextView txv3 = (TextView) findViewById(R.id.textView3);
        TextView txv4 = (TextView) findViewById(R.id.textView4);
        txv1.setText(value1);
        txv2.setText(value2);
        txv3.setText(value3);
        txv4.setText(value4);

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(imageId);
        img.setImageResource(imageId2);


    }

    public void back(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //intent.putExtra("Message", "Hello World");
        startActivity(intent);

    }

}
