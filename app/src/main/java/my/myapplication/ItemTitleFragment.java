package my.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 067231 on 2015/12/9.
 */
public  class ItemTitleFragment extends Fragment {

    View rootView;
    private static final String  TITLE = "item_title";

    public static ItemTitleFragment newInstance( String title) {
        ItemTitleFragment fragment = new ItemTitleFragment();
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //获取布局
        rootView = inflater.inflate(R.layout.fragment_item_title, container, false);
        //设置字段
        TextView tv = (TextView) rootView.findViewById(R.id.item_title);
        tv.setText(getArguments().getString(TITLE));

        return rootView;
    }

}
