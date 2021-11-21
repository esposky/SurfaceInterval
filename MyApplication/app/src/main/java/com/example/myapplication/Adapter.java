package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otherjavafiles.SingleLogTest;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements Filterable {

    Context context;
    Activity activity;
    List<SingleLogTest> DiveLogList;
    List<SingleLogTest> newList;

    public Adapter(Context context, Activity activity, List<SingleLogTest> notesList) {
        this.context = context;
        this.activity = activity;
        this.DiveLogList = notesList;
        newList = new ArrayList<>(notesList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(DiveLogList.get(position).getLocation().getLocation());
        holder.description.setText(DiveLogList.get(position).getDive().getDuration());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateDiveLog.class);

                intent.putExtra("title", DiveLogList.get(position).getLocation().getLocation());
                intent.putExtra("description", DiveLogList.get(position).getDive().getDuration());
                intent.putExtra("id", DiveLogList.get(position).getLocation().getTime());

                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DiveLogList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SingleLogTest> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(newList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (SingleLogTest item : newList) {
                    if (item.getLocation().getLocation().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }

            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            DiveLogList.clear();
            DiveLogList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;
        RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            layout = itemView.findViewById(R.id.note_layout);
        }
    }


    public List<SingleLogTest> getList() {
        return DiveLogList;
    }

    public void removeItem(int position) {
        DiveLogList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(SingleLogTest item, int position) {
        DiveLogList.add(position, item);
        notifyItemInserted(position);
    }
}