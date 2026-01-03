# Al’Mumin – A Faithful Companion App

**Al’Mumin** is an Android-based, offline-first spiritual companion application designed to assist users with daily Islamic practices.  
The app focuses on privacy, offline usability, and persistent reminders, making it a reliable companion for prayers, Hadith reading, and Quranic reflection.

---

## Project Overview

- **Project Name:** Al’Mumin – A Faithful Companion App  
- **Platform:** Android  
- **Programming Language:** Java  
- **Architecture:** Offline-first  
- **Database:** Room Persistence Library  
- **Target Users:** Muslims seeking a private, offline spiritual assistant  

The application does not require internet access for core features, ensuring complete data privacy and accessibility at all times.

---

## Core Features & Functional Requirements

### Authentication (Offline)
- Offline user registration using email and password  
- Offline user login using locally stored credentials  
- Secure logout that clears session data and prevents back navigation  

### Prayer Time Reminders
- Set or cancel reminders for all five daily prayers  
- Persistent alarm states even after app closure  
- Automatic re-scheduling of alarms after device reboot  
- System notifications with sound and vibration at prayer times  

### Theme Customization
- Runtime switching between:
  - Light Mode
  - Dark Mode
  - System Default  
- Theme preference saved and applied on every app launch  

### Islamic Content (Offline)
- **Hadith Viewer**
  - Scrollable list of pre-populated Hadith  
  - Fully offline using Room Database  
- **Quranic Ayat Viewer**
  - Categorized Ayats (e.g., Peace and Comfort)  
  - Offline access with smooth navigation  

---

## Feasibility Study

| # | Requirement | Technology Used |
|---|------------|-----------------|
| 1 | Offline User Registration & Login | Room DB, Java Logic, EditText, Button |
| 2 | Persistent Prayer Reminders | AlarmManager, PendingIntent, SharedPreferences |
| 3 | Prayer Notifications | NotificationManager, NotificationChannel, BroadcastReceiver |
| 4 | Alarm Re-scheduling on Reboot | BootReceiver (ACTION_BOOT_COMPLETED) |
| 5 | Runtime Theme Switching | AppCompatDelegate, PopupMenu |
| 6 | Persistent Theme Preference | SharedPreferences |
| 7 | Offline Hadith & Ayat Viewers | Room Database, RecyclerView, Custom Adapter |

---

## Technical Implementation Guide

### 1. Persistent Prayer Reminders

**Permissions Used**
```xml
SCHEDULE_EXACT_ALARM
POST_NOTIFICATIONS
RECEIVE_BOOT_COMPLETED
