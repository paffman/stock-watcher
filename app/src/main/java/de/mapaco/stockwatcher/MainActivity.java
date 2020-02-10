package de.mapaco.stockwatcher;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.stock_recycler_view)
    RecyclerView stockRecyclerView;

    @BindView(R.id.tv_stock_detail)
    TextView stockView;

    private Map<String, String> stockMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        createStocksMap();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        stockRecyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        RecyclerView.Adapter adapter = new StockRecyclerViewAdapter(stockMap);
        stockRecyclerView.setAdapter(adapter);


    }

    private void createStocksMap() {
        this.stockMap.put("GOOGL", "Google");
        this.stockMap.put("SHS", "Siemens Healthineers");
    }
}
