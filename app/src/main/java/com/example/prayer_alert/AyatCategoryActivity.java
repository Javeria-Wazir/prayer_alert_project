package com.example.prayer_alert;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.prayer_alert.databinding.ActivityAyatCategoryBinding;

public class AyatCategoryActivity extends AppCompatActivity {

    private ActivityAyatCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.applyTheme(this);
        binding = ActivityAyatCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupCategoryClickListeners();
    }

    private void setupCategoryClickListeners() {
        binding.cardPeace.setOnClickListener(v -> openDisplayActivity("Peace and Comfort"));
        binding.cardLove.setOnClickListener(v -> openDisplayActivity("God's Love and Nearness"));
        binding.cardHope.setOnClickListener(v -> openDisplayActivity("Hope and Patience"));
        binding.cardBeauty.setOnClickListener(v -> openDisplayActivity("A Note on Beauty"));
    }

    private void openDisplayActivity(String category) {
        Intent intent = new Intent(this, AyatDisplayActivity.class);
        intent.putExtra("CATEGORY", category);
        startActivity(intent);
    }
}
