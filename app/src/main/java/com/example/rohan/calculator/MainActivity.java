package com.example.rohan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView screen; //current number screen
    private TextView history;
    private float numberFirst;
    private ButtonClickListener btnClick;
    private String opt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen=(TextView)findViewById(R.id.textView);
        int idList[]={R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.buttonAdd,R.id.buttonSub,R.id.buttonMulti,R.id.buttonDiv,R.id.buttonDot,R.id.buttonC,R.id.buttonEquals};
        for (int id:idList) {
        View v=(View) findViewById(id);
        v.setOnClickListener(btnClick);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Recognise operator

    //Listener Class
    private class ButtonClickListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonC:
                    screen.setText("0");
                    numberFirst=0;
                    opt="";
                    break;
                case R.id.buttonAdd;
                    operatorMath("+");
                    break;
                case R.id.buttonSub;
                    operatorMath("-");
                    break;
                case R.id.buttonMulti;
                    operatorMath("*");
                    break;
                case R.id.buttonDiv;
                    operatorMath("/");
                    break;
                case R.id.buttonEquals;
                    calculate();
                    break;
                default:
                    String numb=((Button)v).getText().toString();
                    getDigit(numb);
                    break;
            }
        }
        }
    }

