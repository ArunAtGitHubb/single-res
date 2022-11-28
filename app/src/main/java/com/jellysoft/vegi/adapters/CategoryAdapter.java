package com.jellysoft.vegi.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jellysoft.vegi.R;
import com.jellysoft.vegi.activites.SearchActivity;
import com.jellysoft.vegi.databinding.ItemCategoriesBinding;
import com.jellysoft.vegi.models.CategoryRoot;
import com.jellysoft.vegi.models.HomePageRoot;
import com.jellysoft.vegi.retrofit.Const;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<HomePageRoot.CategoryItem> category;
    private Context context;
    private List<
            CategoryRoot.DataItem> data;

    public CategoryAdapter(List<HomePageRoot.CategoryItem> category) {

        this.category = category;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.binding.tvName.setText(category.get(position).getTitle());
        Glide.with(context).load(Const.IMAGE_URL + category.get(position).getImage()).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder).into(holder.binding.imgCategory);
        holder.binding.getRoot().setOnClickListener(v -> context.startActivity(new Intent(context, SearchActivity.class).putExtra(Const.STR_CNAME, category.get(position).getTitle()).putExtra(Const.STR_CID, String.valueOf(category.get(position).getId()))));

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public void addData(List<CategoryRoot.DataItem> data) {

        this.data = data;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ItemCategoriesBinding binding;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemCategoriesBinding.bind(itemView);


        }
    }
}
