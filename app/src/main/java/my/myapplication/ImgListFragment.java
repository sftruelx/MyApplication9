package my.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img1,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img2,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img3,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img4,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img4,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img5,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img6,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img7,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img8,"This is a test!"));
        transaction.add(R.id.photo_list, PhotoFragment.newInstance(R.drawable.img9,"This is a test!"));
        transaction.commit();

        return rootView;
    }
}
