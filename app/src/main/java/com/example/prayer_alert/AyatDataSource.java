package com.example.prayer_alert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AyatDataSource {

    public static Map<String, List<Ayat>> getAyats() {
        Map<String, List<Ayat>> categoryMap = new HashMap<>();

        // On Peace and Comfort
        List<Ayat> peaceAyats = new ArrayList<>();
        peaceAyats.add(new Ayat("Verily, in the remembrance of Allah do hearts find rest.", "Qur'an 13:28"));
        peaceAyats.add(new Ayat("And He is with you wherever you are.", "Qur'an 57:4"));
        categoryMap.put("Peace and Comfort", peaceAyats);

        // On God's Love and Nearness
        List<Ayat> loveAyats = new ArrayList<>();
        loveAyats.add(new Ayat("My Mercy embraces all things.", "Qur'an 7:156"));
        loveAyats.add(new Ayat("And We are closer to him than his jugular vein.", "Qur'an 50:16"));
        categoryMap.put("God's Love and Nearness", loveAyats);

        // On Hope and Patience
        List<Ayat> hopeAyats = new ArrayList<>();
        hopeAyats.add(new Ayat("So, verily, with every difficulty, there is relief.", "Qur'an 94:5"));
        hopeAyats.add(new Ayat("And be patient, for indeed, Allah does not allow to be lost the reward of the doers of good.", "Qur'an 11:115"));
        categoryMap.put("Hope and Patience", hopeAyats);

        // A Note on Beauty
        List<Ayat> beautyAyats = new ArrayList<>();
        beautyAyats.add(new Ayat("He is the One Who has created you and made for you the ears and the eyes and the hearts.", "Qur'an 67:23"));
        categoryMap.put("A Note on Beauty", beautyAyats);

        return categoryMap;
    }
}
