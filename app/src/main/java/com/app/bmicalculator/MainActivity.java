package com.app.bmicalculator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mCalculateBMI;

    TextView mcurrentHeight;
    TextView mcurrentAge,mcurrentWeight;
    ImageView mincrementAge,mincrementWeight,mDecrementWeight,mdecrementAge;
    SeekBar mseekbarforHeight;
    RelativeLayout mmale,mfemale;

    int intweight=55;
    int intage=25;
    int currentprogress;
    String mintprogress="160";
    String typeofuser="0";
    String weight2="55";
    String age2="25";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        mCalculateBMI=(Button)findViewById(R.id.calculateBMI);
        mcurrentAge=(TextView)findViewById(R.id.currentAge);
        mcurrentHeight=(TextView)findViewById(R.id.currentHeight);
        mcurrentWeight=(TextView)findViewById(R.id.currentWeight);
        mincrementAge=(ImageView)findViewById(R.id.incrementAge);
        mincrementWeight=(ImageView)findViewById(R.id.incrementWeight);
        mdecrementAge=(ImageView)findViewById(R.id.decrementAge);
        mDecrementWeight=(ImageView)findViewById(R.id.decrementWeight);
        mseekbarforHeight=(SeekBar)findViewById(R.id.seekBarHeight);
        mmale= (RelativeLayout)findViewById(R.id.male);
        mfemale=(RelativeLayout)findViewById(R.id.female);



        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });
        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Female";
            }
        });

        mseekbarforHeight.setMax(300);
        mseekbarforHeight.setProgress(160);
        mseekbarforHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                mcurrentHeight.setText(mintprogress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mincrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrentAge.setText(age2);

            }
        });
        mdecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrentAge.setText(age2);

            }
        });

        mincrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentWeight.setText(weight2);

            }
        });

        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentWeight.setText(weight2);

            }
        });
        


        mCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                }
                else if(intage==0||intage<0){
                    Toast.makeText(getApplicationContext(), "Age is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else if(intweight==0||intweight<0){
                    Toast.makeText(getApplicationContext(), "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(MainActivity.this,BmiActivity.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }
              /*  Intent intent=new Intent(MainActivity.this,BmiActivity.class);
                startActivity(intent);
                finish();*/
            }
        });
    }
}