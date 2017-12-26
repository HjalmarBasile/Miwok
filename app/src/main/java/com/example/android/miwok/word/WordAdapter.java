package com.example.android.miwok.word;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.miwok.R;

import java.util.List;

/**
 * Created by hjalmar
 * On 17/12/2017.
 * <p>
 * Check Google Developers video "Google I/O 2010 - The world of ListView" on YouTube for explanation.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private final LayoutInflater mInflater = LayoutInflater.from(getContext());
    private final int mColorResourceId;

    private static class ViewHolder {
        LinearLayout textLinearLayout;
        TextView miwokTranslation;
        TextView defaultTranslation;
        ImageView wordImage;
    }

    public WordAdapter(Context context, List<Word> words, int colorResourceId) {
        // Because this is a custom adapter, it is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.textLinearLayout = convertView.findViewById(R.id.item_text_linear_layout);
            holder.miwokTranslation = convertView.findViewById(R.id.miwok_text_view);
            holder.defaultTranslation = convertView.findViewById(R.id.default_text_view);
            holder.wordImage = convertView.findViewById(R.id.item_pic);
            holder.textLinearLayout.setBackgroundResource(mColorResourceId);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Word word = getItem(position);
        holder.miwokTranslation.setText(word.getMiwokTranslation());
        holder.defaultTranslation.setText(word.getDefaultTranslation());
        if (word.hasImage()) {
            holder.wordImage.setImageResource(word.getImageResourceId());
            holder.wordImage.setVisibility(View.VISIBLE);
        } else {
            holder.wordImage.setVisibility(View.GONE);
        }

        return convertView;
    }

}
