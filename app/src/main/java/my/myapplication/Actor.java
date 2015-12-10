package my.myapplication;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Larry on 2015/12/10.
 */
public class Actor {
    String name;

    String picName;

    public Actor(String name, String picName)
    {
        this.name = name;
        this.picName = picName;
    }

    public int getImageResourceId( Context context )
    {
        try
        {
            Resources resources = context.getResources();
            int indentify= resources.getIdentifier(this.picName, "drawable",  context.getPackageName());
            return context.getResources().getIdentifier(this.picName, "drawable", context.getPackageName());

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

}
