package com.example.newcatalogapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddCategoryActivity extends AppCompatActivity {

    EditText cat_name;

    Button addcategorybtn;

    String url="https://catlognew2040.000webhostapp.com/insertcategory.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        cat_name = findViewById(R.id.addcategorytext);
        addcategorybtn = findViewById(R.id.addcategorybtn);

        addcategorybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mycatname = cat_name.getText().toString();
                ProgressDialog myprogress = new ProgressDialog(AddCategoryActivity.this);
                myprogress.setTitle("Please wait");
                myprogress.setMessage("Please wait process start");
                myprogress.show();
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    myprogress.dismiss();
                        if (response.equalsIgnoreCase("sucess")) {
                            Toast.makeText(AddCategoryActivity.this, "Category Added Sucessfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddCategoryActivity.this, "Category Added un - Sucessfully", Toast.LENGTH_SHORT).show();

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddCategoryActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        myprogress.dismiss();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parms = new HashMap<>();
                        parms.put("cat_name",mycatname);

                        return parms;
                    }
                };
            }
        });
    }
}