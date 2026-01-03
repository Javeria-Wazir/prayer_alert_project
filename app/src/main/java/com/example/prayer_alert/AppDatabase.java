package com.example.prayer_alert;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Hadith.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract HadithDao hadithDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "prayer_alert_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadExecutor().execute(() -> prepopulateHadith(INSTANCE));
                                }
                            })
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static void prepopulateHadith(AppDatabase db) {
        List<Hadith> hadiths = new ArrayList<>();
        
        Hadith hadith1 = new Hadith();
        hadith1.text = "The best among you are those who have the best manners and character.";
        hadith1.source = "Bukhari";
        hadiths.add(hadith1);

        Hadith hadith2 = new Hadith();
        hadith2.text = "A man's true wealth is the good he does in this world.";
        hadith2.source = "Muslim";
        hadiths.add(hadith2);
        
        // Add more hadith here...

        db.hadithDao().insertAll(hadiths);
    }
}
