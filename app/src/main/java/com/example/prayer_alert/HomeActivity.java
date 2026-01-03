package com.example.prayer_alert;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.prayer_alert.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.applyTheme(this); // Apply saved theme
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupClickListeners();
    }

    private void setupClickListeners() {
        binding.btnSalahReminder.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, PrayerTimesActivity.class));
        });

        binding.btnBeautifulAyats.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, AyatCategoryActivity.class));
        });

        binding.btnHadith.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, HadithActivity.class));
        });

        binding.btnLogout.setOnClickListener(v -> {
            // Navigate back to LoginActivity
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        binding.settingsIcon.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(this, v);
            popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(this::onOptionsItemSelected);
            popup.show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int themeMode = -1;
        if (item.getItemId() == R.id.theme_light) {
            themeMode = AppCompatDelegate.MODE_NIGHT_NO;
        } else if (item.getItemId() == R.id.theme_dark) {
            themeMode = AppCompatDelegate.MODE_NIGHT_YES;
        } else if (item.getItemId() == R.id.theme_system_default) {
            themeMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
        }

        if (themeMode != -1) {
            ThemeManager.setTheme(this, themeMode);
            recreate(); // This is the crucial step to apply the theme immediately.
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
