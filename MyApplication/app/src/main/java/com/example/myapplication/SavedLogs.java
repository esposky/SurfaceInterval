//package com.example.myapplication;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.SearchView;
//import androidx.coordinatorlayout.widget.CoordinatorLayout;
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.database.Cursor;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Adapter;
//import android.widget.Toast;
//
//import com.example.otherjavafiles.SingleLogTest;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.BaseTransientBottomBar;
//import com.google.android.material.snackbar.Snackbar;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SavedLogs extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    FloatingActionButton addNew_DiveLog_Button;
//    Adapter adapter;
//    List<LogBook_Model> divelogList;
//    AddNewDiveLogDatabase addNewDiveLogDatabase;
//    CoordinatorLayout coordinatorLayout;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_saved_logs);
//
//        recyclerView = findViewById(R.id.recycler_view);
//        addNew_DiveLog_Button = findViewById(R.id.addNewDivelog_Button);
//        coordinatorLayout = findViewById(R.id.layout_main);
//
//
//        addNew_DiveLog_Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SavedLogs.this, AddNewDiveLog.class);
//                startActivity(intent);
//            }
//        });
//
//        divelogList  = new ArrayList<>();
//        addNewDiveLogDatabase = new AddNewDiveLogDatabase(this);
//        fetchAllDivesLogsFromDatabase();
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new Adapter(this, SavedLogs.this, divelogList);
//        recyclerView.setAdapter(adapter);
//
//        ItemTouchHelper helper = new ItemTouchHelper(callback);
//        helper.attachToRecyclerView(recyclerView);
//
//    }
//
//
//    void fetchAllDivesLogsFromDatabase() {
//        Cursor cursor = addNewDiveLogDatabase.readAllData();
//
//        if (cursor.getCount() == 0) {
//            Toast.makeText(this, "No Data to show", Toast.LENGTH_SHORT).show();
//        } else {
//            while (cursor.moveToNext()) {
//                divelogList.add(new LogBook_Model(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
//            }
//        }
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.options_menu, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.searchbar);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setQueryHint("Search DiveLogs Here");
//
//        SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return true;
//            }
//        };
//
//        searchView.setOnQueryTextListener(listener);
//
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if (item.getItemId() == R.id.delete_all_notes) {
//            deleteAllNotes();
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void deleteAllNotes() {
////        AddNewDiveLogDatabase db = new AddNewDiveLogDatabase(MainActivity.this);
////        db.deleteAllNotes();
//        recreate();
//    }
//
//
//    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//            return false;
//        }
//
//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//            int position = viewHolder.getAdapterPosition();
//            SingleLogTest item = adapter.getList().get(position);
//
//            //adapter.removeItem(viewHolder.getAdapterPosition());
//
//            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Item Deleted", Snackbar.LENGTH_LONG)
//                    .setAction("UNDO", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            adapter.restoreItem(item, position);
//                            recyclerView.scrollToPosition(position);
//                        }
//                    }).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
//                        @Override
//                        public void onDismissed(Snackbar transientBottomBar, int event) {
//                            super.onDismissed(transientBottomBar, event);
//
//                            if (!(event == DISMISS_EVENT_ACTION)) {
//                                AddNewDiveLogDatabase db = new AddNewDiveLogDatabase(MainActivity.this);
//                                db.deleteSingleItem(item.getId());
//                            }
//
//
//                        }
//                    });
//
//            snackbar.setActionTextColor(Color.YELLOW);
//            snackbar.show();
//
//        }
//    };
//}