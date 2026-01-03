package com.example.prayer_alert;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prayer_alert.R;

public class PrayerDetailActivity extends AppCompatActivity {

    private TextView prayerName, prayerTime, verseText, motivationQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_detail);

        // Initialize views
        prayerName = findViewById(R.id.prayerName);
        prayerTime = findViewById(R.id.prayerTime);
        verseText = findViewById(R.id.verseText);
        motivationQuote = findViewById(R.id.motivationQuote);

        // Get data from Intent
        String name = getIntent().getStringExtra("prayerName");
        String time = getIntent().getStringExtra("prayerTime");

        // Set values
        prayerName.setText(name);
        prayerTime.setText(time);

        // Set Ayat and quote according to the prayer
        setPrayerDetails(name);
    }

    private void setPrayerDetails(String prayer) {
        switch (prayer.toLowerCase()) {
            case "fajr":
                verseText.setText("“Indeed, prayer prohibits immorality and wrongdoing.”\n— [Surah Al-Ankabut 29:45]");
                motivationQuote.setText("“Wake up for Fajr — victory begins when the world is asleep.”");
                break;
            case "dhuhr":
                verseText.setText("“So glorify Allah when you reach the evening and when you rise in the morning.”\n— [Surah Ar-Rum 30:17]");
                motivationQuote.setText("“Pause your busy day to bow before the One who gave it to you.”");
                break;
            case "asr":
                verseText.setText("“Guard strictly your prayers, especially the middle prayer.”\n— [Surah Al-Baqarah 2:238]");
                motivationQuote.setText("“Asr reminds us — no matter how hectic the day, there’s always time for Allah.”");
                break;
            case "maghrib":
                verseText.setText("“Then exalt Him with praise of your Lord before the setting of the sun.”\n— [Surah Qaf 50:39]");
                motivationQuote.setText("“As the sun sets, let your heart rise in gratitude.”");
                break;
            case "isha":
                verseText.setText("“And establish prayer at the decline of the sun until the darkness of the night.”\n— [Surah Al-Isra 17:78]");
                motivationQuote.setText("“End your day in peace — let Isha wash away your worries.”");
                break;
            default:
                verseText.setText("“Indeed, prayer is the key to success.”");
                motivationQuote.setText("“Stay connected with Allah in every moment.”");
                break;
        }
    }
}
