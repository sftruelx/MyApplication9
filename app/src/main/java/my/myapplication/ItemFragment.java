package my.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Larry on 2015/12/8.
 */
public class ItemFragment extends Fragment {

    //标题
    private String title = "";



    public ItemFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.item_main, container, false);
        ImageView iv = (ImageView) rootView.findViewById(R.id.item_icon);
        iv.setImageResource(R.drawable.ic_item);
        TextView textView = (TextView) rootView.findViewById(R.id.item_title);
        textView.setText("奶爸频道");
        return rootView;

    }



}
