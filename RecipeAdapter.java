package com.example.pupil.retrofit2;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private List<Result> list;

    public void setList(List<Result> list){
        this.list = list;
        notifyDataSetChanged();
    }
    public RecipeAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.container, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(list.get(i));
    }

    public RecipeAdapter(List<Result> results) {
        this.list = results;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title,url,ingredients;
        private ImageView logo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            title = itemView.findViewById(R.id.title);
            ingredients= itemView.findViewById(R.id.txtIngredients);
        }

        public void bind(Result result){
            title.setText(result.getTitle());
            url.setText(result.getHref());
            ingredients.setText(result.getIngredients());
            Glide.with(itemView.getContext()).load(result.getThumbnail()).into(logo);
        }


    }

}
