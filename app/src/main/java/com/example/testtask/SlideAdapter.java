package com.example.testtask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SlideAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<Item> itemList;

    public SlideAdapter(Context mContext, List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_card, container, false);
        ImageView slideImage = (ImageView) view.findViewById(R.id.image_slide);
        TextView slideTitle = (TextView) view.findViewById(R.id.image_title_slide);
        TextView slideAuthorsName = (TextView) view.findViewById(R.id.image_authors_name_slide);
        TextView slideImageLikes = (TextView) view.findViewById(R.id.image_quantity_of_likes_slide);

        Glide.with(mContext)
                .load(itemList.get(position).getImageURL())
                .into(slideImage);
        slideTitle.setText(itemList.get(position).getImageTitle());
        slideAuthorsName.setText(itemList.get(position).getImageAuthorsName());
        slideImageLikes.setText(itemList.get(position).getImageLikes() + " likes");
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
