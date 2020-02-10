package de.mapaco.stockwatcher;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class StockRecyclerViewAdapter extends RecyclerView.Adapter<StockRecyclerViewAdapter.StockViewHolder> {

    private Map<String, String> stockMap;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class StockViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public StockViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public StockRecyclerViewAdapter(Map<String, String> stockDataList) {
        stockMap = stockDataList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public StockRecyclerViewAdapter.StockViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_recycler_view, parent, false);

        StockViewHolder vh = new StockViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(stockMap.get(position));
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return stockMap.size();
    }

}
