package com.larriu.in3model.intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.larriu.in3model.R;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter {

    private Context myContext;
    private List<IntroScreenItem> list;

    public IntroViewPagerAdapter(Context myContext, List<IntroScreenItem> list) {
        this.myContext = myContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen, null);

        ImageView imageSlide = layoutScreen.findViewById(R.id.introImage);
        TextView tittle = layoutScreen.findViewById(R.id.introTittle);
        TextView description = layoutScreen.findViewById(R.id.introDescription);

        tittle.setText(list.get(position).getTittle());
        description.setText(list.get(position).getDescription());
        imageSlide.setImageResource(list.get(position).getScreenImage());

        container.addView(layoutScreen);

        return layoutScreen;

    }
}
