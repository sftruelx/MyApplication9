package my.myapplication;


import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 067231 on 2015/12/9.
 */
public class ImgListFragment extends Fragment {


    public static ImgListFragment newInstance( ) {
        ImgListFragment channel = new ImgListFragment();
        return  channel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.channel_one, container, false);
        LinearLayout linear = (LinearLayout)rootView.findViewById(R.id.photo_list);
        String desc = "可是这只是指定了HTTP请求方式是POST，那么我们要提交给服务器的参数又该怎么设置呢";
        View photo = getView(inflater, container, R.drawable.img1,desc);
        linear.addView(photo);
        View photo2 = getView(inflater, container, R.drawable.img2,desc);
        linear.addView(photo2);
        View photo3 = getView(inflater, container, R.drawable.img3,desc);
        linear.addView(photo3);
        View photo4 = getView(inflater, container, R.drawable.img4,desc);
        linear.addView(photo4);
        View photo5 = getView(inflater, container, R.drawable.img5,desc);
        linear.addView(photo5);
        View photo6 = getView(inflater, container, R.drawable.img6,desc);
        linear.addView(photo6);
        View photo7 = getView(inflater, container, R.drawable.img7,desc);
        linear.addView(photo7);
        View photo8 = getView(inflater, container, R.drawable.img8,desc);
        linear.addView(photo8);
        View photo9 = getView(inflater, container, R.drawable.img9,desc);
        linear.addView(photo9);

        return rootView;
    }

    private View getView(LayoutInflater inflater, ViewGroup container, @DrawableRes int resId, String desc) {
        View photo = inflater.inflate(R.layout.photo_small, container, false);
        ImageView iv = (ImageView) photo.findViewById(R.id.photo_pic);
        iv.setImageResource(resId);
        TextView tv = (TextView) photo.findViewById(R.id.photo_txt);
        tv.setText(desc);
        return photo;
    }
}
