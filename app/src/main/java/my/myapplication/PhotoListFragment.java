package my.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import my.myapplication.my.myapplication.list.PullToRefreshListActivity;

/**
 * Created by 067231 on 2015/12/9.
 */
public class PhotoListFragment extends Fragment {


    public static PhotoListFragment newInstance( ) {
        PhotoListFragment channel = new PhotoListFragment();
        return  channel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.channel_two, container, false);
        LinearLayout linear = (LinearLayout)rootView.findViewById(R.id.photo_list2);
        String desc = "可是这只是指定了HTTP请求方式是POST，那么我们要提交给服务器的参数又该怎么设置呢";
        View photo = getView(inflater, container, R.drawable.pic1,desc);
        linear.addView(photo);
        View photo2 = getView(inflater, container, R.drawable.pic2,desc);
        linear.addView(photo2);
        View photo3 = getView(inflater, container, R.drawable.pic3,desc);
        linear.addView(photo3);
        View photo4 = getView(inflater, container, R.drawable.pic4,desc);
        linear.addView(photo4);
        return rootView;
    }

    @NonNull
    private View getView(LayoutInflater inflater, ViewGroup container, @DrawableRes int resId, String desc) {
        View photo = inflater.inflate(R.layout.photo_one, container, false);
        ImageView iv = (ImageView) photo.findViewById(R.id.photo_pic);
        iv.setImageResource(resId);
        TextView tv = (TextView) photo.findViewById(R.id.photo_txt);
        tv.setText(desc);
        return photo;
    }


}
