package com.example.prayer_alert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.AyatViewHolder> {

    private List<Ayat> ayatList;

    public AyatAdapter(List<Ayat> ayatList) {
        this.ayatList = ayatList;
    }

    @NonNull
    @Override
    public AyatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ayat, parent, false);
        return new AyatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyatViewHolder holder, int position) {
        Ayat ayat = ayatList.get(position);
        holder.ayatText.setText(ayat.text);
        holder.ayatSource.setText("- " + ayat.source);
    }

    @Override
    public int getItemCount() {
        return ayatList.size();
    }

    static class AyatViewHolder extends RecyclerView.ViewHolder {
        TextView ayatText;
        TextView ayatSource;

        public AyatViewHolder(@NonNull View itemView) {
            super(itemView);
            ayatText = itemView.findViewById(R.id.ayatText);
            ayatSource = itemView.findViewById(R.id.ayatSource);
        }
    }
}
