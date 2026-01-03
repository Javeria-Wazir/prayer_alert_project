package com.example.prayer_alert;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.prayer_alert.databinding.ActivityAyatDisplayBinding;
import java.util.List;
import java.util.Map;

public class AyatDisplayActivity extends AppCompatActivity {

    private ActivityAyatDisplayBinding binding;
    private AyatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.applyTheme(this);
        binding = ActivityAyatDisplayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String category = getIntent().getStringExtra("CATEGORY");
        binding.categoryTitle.setText(category);

        setupRecyclerView();
        loadAyats(category);
    }

    private void setupRecyclerView() {
        binding.ayatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadAyats(String category) {
        Map<String, List<Ayat>> allAyats = AyatDataSource.getAyats();
        List<Ayat> ayatsForCategory = allAyats.get(category);

        if (ayatsForCategory != null) {
            adapter = new AyatAdapter(ayatsForCategory);
            binding.ayatRecyclerView.setAdapter(adapter);
        }
    }
}
