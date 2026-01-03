package com.example.prayer_alert;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.prayer_alert.databinding.ActivityHadithBinding;
import java.util.List;

public class HadithActivity extends AppCompatActivity {

    private ActivityHadithBinding binding;
    private AppDatabase db;
    private HadithAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.applyTheme(this);
        binding = ActivityHadithBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = AppDatabase.getDatabase(this);

        setupRecyclerView();
        loadHadith();
    }

    private void setupRecyclerView() {
        binding.hadithRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadHadith() {
        // Database operations should be on a background thread.
        new Thread(() -> {
            List<Hadith> hadithList = db.hadithDao().getAllHadith();
            runOnUiThread(() -> {
                adapter = new HadithAdapter(hadithList);
                binding.hadithRecyclerView.setAdapter(adapter);
            });
        }).start();
    }
}
