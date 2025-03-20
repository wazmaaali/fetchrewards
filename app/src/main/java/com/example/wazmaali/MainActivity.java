package com.example.wazmaali;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.wazmaali.controller.ListItemAdapter;
import com.example.wazmaali.controller.ListItemController;
import com.example.wazmaali.model.ListItems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListItemController itemController;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager( peekAvailableContext().getApplicationContext()));

        itemController = new ListItemController();
        itemController.getListItems(new ListItemController.ListItemsCallback() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onItemsFetched(List<ListItems> listItems) {
                Log.d("TAG", "ListItems: "+ listItems.get(1).getId());

                if (listItems != null) {

                    List<ListItems> validItems = new ArrayList<>();
                    Map<Integer, List<ListItems>> groupedByListId = new HashMap<>();

                    for (ListItems item : listItems) {
                        if (item.getName() != null && !item.getName().isEmpty()) {
                            if (!groupedByListId.containsKey(item.getListId())) {
                                groupedByListId.put(item.getListId(), new ArrayList<>());
                            }

                            groupedByListId.get(item.getListId()).add(item);
                        }
                    }
              List<Map.Entry<Integer, List<ListItems>>> sortedGroups = new ArrayList<>(groupedByListId.entrySet());
                    sortedGroups.sort(Comparator.comparingInt(Map.Entry::getKey));

                    for (Map.Entry<Integer, List<ListItems>> entry : sortedGroups) {
                        List<ListItems> itemsList = entry.getValue();
                        itemsList.sort(Comparator.comparing(ListItems::getId));
                        for (ListItems item : itemsList) {
                            validItems.add(item);
                            Log.d("TAG", "ListItems name: "+ item.getName());
                        }
                    }


                    ListItemAdapter adapter = new ListItemAdapter(validItems);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onError(String error) {
                Log.e("TAG", "Error: " + error);
            }
        });

        }


}