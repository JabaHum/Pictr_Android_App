package rm.com.microproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShowSelected extends AppCompatActivity {

    String bitmapString;

    ImageView img;

    Button cross,tick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_selected);

        img = findViewById(R.id.img);
        cross = findViewById(R.id.cross);
        tick = findViewById(R.id.tick);


        Intent collectBitmap = getIntent();
        bitmapString = collectBitmap.getStringExtra("imageBitmap");

        img.setImageBitmap(StringToBitMap(bitmapString));




        tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent validation = new Intent();
                setResult(Activity.RESULT_OK,validation);
                finish();
            }
        });



        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent validation = new Intent();
                setResult(Activity.RESULT_CANCELED,validation);
                finish();
            }
        });

    }


    public Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte= Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }
}
