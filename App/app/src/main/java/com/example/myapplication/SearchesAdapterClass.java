package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchesAdapterClass extends RecyclerView.Adapter <SearchesAdapterClass.RowViewHolder> {
    ArrayList <SearchResultRow > SearchResultList = new ArrayList<>();
    Context ctx;

    public SearchesAdapterClass (Context ctx, ArrayList<SearchResultRow> SearchResultList) {
        this.ctx = ctx;
        this.SearchResultList = SearchResultList;

    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.search_result_row_view, parent , false);
        RowViewHolder holder = new RowViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        final SearchResultRow row = SearchResultList.get(position);
        holder.TitleView.setText(row.getTitle());
        holder.TitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(row.getUrl());
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        ctx.startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public int getItemCount() {
        return SearchResultList.size ();
    }

    class RowViewHolder extends RecyclerView.ViewHolder {
        TextView TitleView;

        public RowViewHolder(@NonNull View itemView) {
            super(itemView);
            TitleView = itemView.findViewById(R.id.TitleRowView);
        }
    }

}
