package my.com.anytek.sliderusingviewpager;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_img = {
            R.drawable.background1,
            R.drawable.background2,
            R.drawable.background3,
            R.drawable.background4,
    };

    // list of titles
    public String[] lst_title = {
            "Title1",
            "Title1",
            "Title1",
            "Title1"
    };

    // list of description
    public String[] lst_desc = {
            "Description 1",
            "Description 2",
            "Description 3",
            "Description 4",
    };

    // list of background colors
    public int[] lst_bgcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container, false);
        LinearLayout layoutslide = view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = view.findViewById(R.id.slideimg);
        TextView txtTitle = view.findViewById(R.id.txttitle);
        TextView txtDesc = view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_bgcolor[position]);
        imgslide.setImageResource(lst_img[position]);
        txtDesc.setText(lst_desc[position]);
        txtTitle.setText(lst_title[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((LinearLayout)object);
    }
}
