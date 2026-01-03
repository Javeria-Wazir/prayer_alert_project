package com.example.prayer_alert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HadithAdapter extends RecyclerView.Adapter<HadithAdapter.HadithViewHolder> {

    private List<Hadith> hadithList;

    public HadithAdapter(List<Hadith> hadithList) {
        this.hadithList = hadithList;
    }

    @NonNull
    @Override
    public HadithViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hadith, parent, false);
        return new HadithViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HadithViewHolder holder, int position) {
        Hadith hadith = hadithList.get(position);
        holder.hadithText.setText(hadith.text);
        holder.hadithSource.setText("- " + hadith.source);
    }

    @Override
    public int getItemCount() {
        return hadithList.size();
    }

    static class HadithViewHolder extends RecyclerView.ViewHolder {
        TextView hadithText;
        TextView hadithSource;

        public HadithViewHolder(@NonNull View itemView) {
            super(itemView);
            hadithText = itemView.findViewById(R.id.hadithText);
            hadithSource = itemView.findViewById(R.id.hadithSource);
        }
    }
}
