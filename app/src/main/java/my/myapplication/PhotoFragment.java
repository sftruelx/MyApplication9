package my.myapplication;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Larry on 2015/12/9.
 * 放置一张图片和说明文字
 */
public class PhotoFragment extends Fragment {


    private static final String  PHOTO_NAME = "photo_name";
    private static final String  PHOTO_TEXT = "photo_text";

    public static PhotoFragment newInstance(@DrawableRes int resId, String desc ) {
        PhotoFragment fragment = new PhotoFragment();
        Bundle args = new Bundle();
        args.putInt(PHOTO_NAME,resId);
        args.putString(PHOTO_TEXT, desc);
        fragment.setArguments(args);
        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View photoView = inflater.inflate(R.layout.photo_one, container, false);
        ImageView iv = (ImageView) photoView.findViewById(R.id.photo_pic);
        iv.setImageResource(getArguments().getInt(PHOTO_NAME));
        TextView tv = (TextView) photoView.findViewById(R.id.photo_txt);
        tv.setText(getArguments().getString(PHOTO_TEXT));

        return photoView;
    }
}
