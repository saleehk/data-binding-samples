package com.saleeh.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.saleeh.databinding.databinding.ActivityDataBinding;
import com.saleeh.databinding.models.User;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        User user = new User("Saleeh", 22, "123456789", "https://developer.android.com/assets/images/android_logo.png");
        binding.setUser(user);
    }


}
