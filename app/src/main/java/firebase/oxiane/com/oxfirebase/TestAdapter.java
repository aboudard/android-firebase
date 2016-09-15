package firebase.oxiane.com.oxfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aboudard on 14/09/2016.
 */

public class TestAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Test> tests;
    private Context context;

    public TestAdapter(Context context, List<Test> tests) {
        this.tests = tests;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return tests.size();
    }

    @Override
    public Test getItem(int position) {
        return tests.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_test, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        Test cTest = getItem(position);
        mViewHolder.texte.setText(cTest.getText());
        mViewHolder.user.setText(cTest.getUser());

        return convertView;
    }

    public void add(Test t) {
        this.tests.add(t);
    }

    private class MyViewHolder {
        TextView texte;
        TextView user;

        public MyViewHolder(View item) {
            texte = (TextView) item.findViewById(R.id.textViewTexteItem);
            user = (TextView) item.findViewById(R.id.textViewUserItem);
        }

    }
}
