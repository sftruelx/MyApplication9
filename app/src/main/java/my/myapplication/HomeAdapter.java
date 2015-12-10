package my.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Larry on 2015/12/10.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>
{
    private List<Actor> actors;

    private Context mContext;

    public HomeAdapter( Context context , List<Actor> actors)
    {
        this.mContext = context;
        this.actors = actors;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i )
    {
        // 给ViewHolder设置布局文件
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i )
    {
        // 给ViewHolder设置元素
        Actor p = actors.get(i);
        viewHolder.mTextView.setText(p.name);

        viewHolder.mImageView.setImageResource(R.drawable.img1);
    }

    @Override
    public int getItemCount()
    {
        // 返回数据总数
        return actors == null ? 0 : actors.size();
    }

    // 重写的自定义ViewHolder
    public static class ViewHolder
            extends RecyclerView.ViewHolder
    {
        public TextView mTextView;

        public ImageView mImageView;

        public ViewHolder( View v )
        {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.list_text);
            mImageView = (ImageView) v.findViewById(R.id.list_img);
        }
    }
}

