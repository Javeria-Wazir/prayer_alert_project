package com.example.prayer_alert;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface HadithDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Hadith> hadiths);

    @Query("SELECT * FROM hadith")
    List<Hadith> getAllHadith();
}
