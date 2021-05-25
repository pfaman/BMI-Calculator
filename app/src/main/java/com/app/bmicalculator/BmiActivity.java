package com.app.bmicalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    android.widget.Button mRecalculateBMI;

    TextView mBmiDisplay,mBmiCategory,mGender;
    Intent intent;
    ImageView mImageView;
    String mBMI;
    float intBMI;
    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();
        mBmiDisplay=(TextView)findViewById(R.id.bmiDisplay);
        mBmiCategory=(TextView)findViewById(R.id.bmiCategory);
        mGender=(TextView) findViewById(R.id.genderDisplay);
        mBackground=(RelativeLayout) findViewById(R.id.contentLayout);
        mImageView=( ImageView)findViewById(R.id.imageView);
        mRecalculateBMI=(Button)findViewById(R.id.RecalculationBMI);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");
        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);
        intheight=intheight/100;
        intBMI=intweight/(intheight*intheight);
        mBMI=Float.toString(intBMI);
        if(intBMI<16)
        {
            mBmiCategory.setText("Servere Thinnesss!");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }
        else if(intBMI<16.9 && intBMI>16){
            mBmiCategory.setText("Moderate Thinnesss!");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);

        }
        else if(intBMI<18.4 &&intBMI>17){
            mBmiCategory.setText("Mild Thinnesss!");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else if(intBMI<25 && intBMI >18.4){

            mBmiCategory.setText("Normal");
       //     mBackground.setBackgroundColor(Color.YELLOW);
            mImageView.setImageResource(R.drawable.ok);
        }
        else if(intBMI<29.4 && intBMI >25){
            mBmiCategory.setText("OverWeight");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else{
            mBmiCategory.setText("Obese Class I");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }
        mGender.setText(intent.getStringExtra("gender"));
        mBmiDisplay.setText(mBMI);
        mRecalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BmiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}