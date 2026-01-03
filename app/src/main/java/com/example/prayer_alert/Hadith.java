package com.example.prayer_alert;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hadith")
public class Hadith {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String text;
    public String source;
}
