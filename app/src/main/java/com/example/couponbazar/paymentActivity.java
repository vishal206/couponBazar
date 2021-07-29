package com.example.couponbazar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class paymentActivity extends AppCompatActivity implements PaymentResultListener {

    private EditText edt_amount;
    private Button btn_pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        edt_amount=findViewById(R.id.edt_amount);
        btn_pay=findViewById(R.id.btn_pay);


        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edt_amount.getText().toString()))
                    Toast.makeText(paymentActivity.this, "amount is empty", Toast.LENGTH_SHORT).show();
                else{
                    startPayment();
                }
            }
        });
    }

    public void startPayment(){
        Checkout co=new Checkout();

        co.setKeyID("rzp_test_VoqS6Oniu7XpkV");
        try {

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("name","COUPON BAZAR");
//            orderRequest.put("amount", 50000); // amount in the smallest currency unit
            orderRequest.put("currency", "INR");
//            orderRequest.put("receipt", "order_rcptid_11");

            String payment=edt_amount.getText().toString();
            double total=Double.parseDouble(payment);
            total=total*100;
            orderRequest.put("Amount",total);

            JSONObject preFill=new JSONObject();
            preFill.put("email","vishal206ani@gmail.com");
            preFill.put("contact","7555102046");

            orderRequest.put("prefill",preFill);

            co.open(this,orderRequest);



        }catch (Exception e){

        }
    }

    @Override
    public void onPaymentSuccess(String s) {

    }

    @Override
    public void onPaymentError(int i, String s) {

    }
}