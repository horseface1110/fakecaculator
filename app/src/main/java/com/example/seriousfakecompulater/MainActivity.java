//此為計算機畫面
package com.example.seriousfakecompulater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.seriousfakecompulater.*;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_seven , button_eight , button_nine , button_multiply , button_four;
    Button button_five , button_six , button_Subtract , button_one , button_two , button_three ;
    Button button_plus , button_zero , button_dot , button_equal , button_cancel , button_division;
    Button button_brackets , button_percent ,button_changetoken;
    boolean equalHadPress = false , operaHasPress = false , bracketsHasPress = false; //opera避免連續的運算符號
    boolean canEnterPassword = true ;
    SharedPreferences calculator ;       //sharepreference 要在開始時宣告，在開啟時製作
    SharedPreferences.Editor calculator2 ;
    private EditText et_calc ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        calculator = getSharedPreferences("calculator", MODE_PRIVATE);
        calculator2 = calculator.edit();
        if(!calculator.getBoolean("usedused",false))
        calculator2.putBoolean("used",false).apply();  //為啥是apply  //put會改到原本的偏好設定，超靠杯，待改
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtonListener();     //呼叫創造事件監聽的函式讓按紐和code連結
        if(!calculator.getBoolean("used",false))teach();

    }


    private void initButtonListener() {
        button_cancel = (Button)findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(this);

        button_seven = (Button)findViewById(R.id.button_seven);
        button_seven.setOnClickListener(this);

        button_eight = (Button)findViewById(R.id.button_eight);
        button_eight.setOnClickListener(this);

        button_nine = (Button)findViewById(R.id.button_nine);
        button_nine.setOnClickListener(this);

        button_six = (Button)findViewById(R.id.button_six);
        button_six.setOnClickListener(this);

        button_five = (Button)findViewById(R.id.button_five);
        button_five.setOnClickListener(this);

        button_four = (Button)findViewById(R.id.button_four);
        button_four.setOnClickListener(this);

        button_three = (Button)findViewById(R.id.button_three);
        button_three.setOnClickListener(this);

        button_two = (Button)findViewById(R.id.button_two);
        button_two.setOnClickListener(this);

        button_one = (Button)findViewById(R.id.button_one);
        button_one.setOnClickListener(this);

        button_zero = (Button)findViewById(R.id.button_zero);
        button_zero.setOnClickListener(this);

        button_equal = (Button)findViewById(R.id.button_equal);
        button_equal.setOnClickListener(this);

        button_plus = (Button)findViewById(R.id.button_plus);
        button_plus.setOnClickListener(this);

        button_Subtract = (Button)findViewById(R.id.button_Subtract);
        button_Subtract.setOnClickListener(this);

        button_multiply = (Button)findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(this);

        button_division = (Button)findViewById(R.id.button_division);
        button_division.setOnClickListener(this);

        button_percent = (Button)findViewById(R.id.button_percent);
        button_percent.setOnClickListener(this);

        button_brackets = (Button)findViewById(R.id.button_brackets);
        button_brackets.setOnClickListener(this);

        button_dot = (Button)findViewById(R.id.button_dot);
        button_dot.setOnClickListener(this);

        button_changetoken = (Button)findViewById(R.id.button_changetoken);
        button_changetoken.setOnClickListener(this);

        et_calc = (EditText)findViewById(R.id.manifest);
        et_calc.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String currentText = et_calc.getText().toString();
        String OperatorNumber = "";
        if(currentText.equals("0") || equalHadPress){
            et_calc.setText("");
            equalHadPress = false;
        }

        switch (v.getId()){
            case R.id.button_eight:
                operaHasPress = false;
                et_calc.setText(et_calc.getText() + "8");
                break;
            case R.id.button_nine:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"9");
                break;
            case R.id.button_seven:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"7");
                break;
            case R.id.button_six:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"6");
                break;
            case R.id.button_five:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"5");
                break;
            case R.id.button_four:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"4");
                break;
            case R.id.button_three:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"3");
                break;
            case R.id.button_two:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"2");
                break;
            case R.id.button_one:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"1");
                break;
            case R.id.button_zero:
                operaHasPress = false;
                et_calc.setText(et_calc.getText()+"0");
                break;
            case R.id.button_cancel:
                operaHasPress = false;
                canEnterPassword = false;
                et_calc.setText("");
                break;
            case R.id.button_plus:
                if(!operaHasPress){
                et_calc.setText(et_calc.getText()+"+");
                }
                canEnterPassword = false;
                operaHasPress = true ;
                break;
            case R.id.button_Subtract:
                if(!operaHasPress){
                et_calc.setText(et_calc.getText()+"-");
                }
                canEnterPassword = false;
                operaHasPress = true ;
                break;
            case R.id.button_multiply:
                if(!operaHasPress){
                et_calc.setText(et_calc.getText()+"*");
                }
                canEnterPassword = false;
                operaHasPress = true ;
                break;
            case R.id.button_division:
                if(!operaHasPress){
                et_calc.setText(et_calc.getText()+"/");
                }
                canEnterPassword = false;
                operaHasPress = true ;
                break;
//            case R.id.button_brackets:
//                operaHasPress = false;
//                if(!bracketsHasPress){
//                    et_calc.setText(et_calc.getText()+"(");    能力不足，無法DEBUG
//                    bracketsHasPress = true;
//                }
//                else{
//                    bracketsHasPress = false ;
//                    et_calc.setText(et_calc.getText()+")");
//                }
            case R.id.button_equal:
                equalHadPress = true;
                if(canEnterPassword && !calculator.getBoolean("used",false) ){
                   calculator2.putString("password",et_calc.getText().toString());
                   calculator2.putBoolean("used",true);
                   calculator2.putBoolean("usedused",true);
                   calculator2.commit();
                   et_calc.setText("");
                   Toast.makeText(this,calculator.getString("password",""),Toast.LENGTH_SHORT).show();
                }
                else if(canEnterPassword && calculator.getString("password","").equals(et_calc.getText().toString())){
                    Toast.makeText(this,"認證",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this,inter1.class);
                    startActivity(intent);
                }
                else if(!operaHasPress) {
                    canEnterPassword = false;
                    et_calc.setText(Double.toString(eval.eval(String.valueOf(et_calc.getText()))));
                    operaHasPress = true ;
                }

                break;

        }

    }
    public void teach(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("使用教學");
        alert.setMessage("鍵入密碼按下等號，密碼即設定完成");
        alert.setCancelable(false).setPositiveButton("理解", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(),"設定密碼",Toast.LENGTH_SHORT).show();
            }
        });
        alert.setCancelable(true).setNeutralButton("取消", (dialogInterface, i) -> {
            MainActivity.this.finish();
        });
        alert.setCancelable(false);
        alert.show();

    }




    //public void
}