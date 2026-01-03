package com.example.prayer_alert;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.prayer_alert.databinding.ActivityForgotPasswordBinding;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResetPasswordActivity extends AppCompatActivity {

    private ActivityForgotPasswordBinding binding;
    private AppDatabase db;
    private final ExecutorService databaseExecutor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeManager.applyTheme(this);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = AppDatabase.getDatabase(this);

        binding.resetPasswordBtn.setOnClickListener(v -> {
            String email = binding.emailReset.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                binding.emailReset.setError("Email is required");
                return;
            }

            databaseExecutor.execute(() -> {
                User user = db.userDao().findByEmail(email);
                if (user == null) {
                    runOnUiThread(() -> Toast.makeText(this, "This email is not registered.", Toast.LENGTH_SHORT).show());
                } else {
                    // In a real app, you would send a reset link.
                    // For this project, we'll just show a success message.
                    runOnUiThread(() -> {
                        Toast.makeText(this, "A password reset link has been sent (simulation).", Toast.LENGTH_LONG).show();
                        finish();
                    });
                }
            });
        });
    }
}
