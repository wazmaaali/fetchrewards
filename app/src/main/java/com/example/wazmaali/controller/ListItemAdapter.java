package com.example.wazmaali.controller;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wazmaali.R;
import com.example.wazmaali.model.ListItems;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ListItems> listItems;

    public ListItemAdapter(List<ListItems> listItems) {
        this.listItems = listItems;
    }
    public static class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemId;
        TextView itemName;
        public ListItemViewHolder(View itemView) {
            super(itemView);
            itemId = itemView.findViewById(R.id.item_id);
            itemName = itemView.findViewById(R.id.item_name);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListItemViewHolder listItemViewHolder = (ListItemViewHolder) holder;

        ListItems currentItem = listItems.get(position);
        Log.d("TAG", "currentItem.getId(): "+currentItem.getId());
        listItemViewHolder.itemId.setText(currentItem.getListId().toString());
        listItemViewHolder.itemName.setText(currentItem.getName());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
