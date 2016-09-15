package firebase.oxiane.com.oxfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listViewTest;
    private List<Test> tList;
    private TestAdapter testAdapter;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        tList = new ArrayList<Test>();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("tests");
        testAdapter = new TestAdapter(ListActivity.this, tList);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        Test t = snapshot.getValue(Test.class);
                        testAdapter.add(t);
                    }
                    testAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        tList.add(new Test("Ahoga", "Johnny"));
        tList.add(new Test("Rhonf", "Bilou"));


        listViewTest = (ListView) findViewById(R.id.listViewTest);
        listViewTest.setAdapter(testAdapter);
    }
}
