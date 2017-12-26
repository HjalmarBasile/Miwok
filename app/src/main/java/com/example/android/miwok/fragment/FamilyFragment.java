package com.example.android.miwok.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.word.Word;
import com.example.android.miwok.word.WordAdapter;
import com.example.android.miwok.media.AudioPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends WordsAbstractFragment {

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        List<Word> words = new ArrayList<>();
        words.add(new Word("әpә", "father", R.raw.family_father, R.drawable.family_father));
        words.add(new Word("әṭa", "mother", R.raw.family_mother, R.drawable.family_mother));
        words.add(new Word("angsi", "son", R.raw.family_son, R.drawable.family_son));
        words.add(new Word("tune", "daughter", R.raw.family_daughter, R.drawable.family_daughter));
        words.add(new Word("taachi", "older brother", R.raw.family_older_brother, R.drawable.family_older_brother));
        words.add(new Word("chalitti", "younger brother", R.raw.family_younger_brother, R.drawable.family_younger_brother));
        words.add(new Word("teṭe", "older sister", R.raw.family_older_sister, R.drawable.family_older_sister));
        words.add(new Word("kolliti", "younger sister", R.raw.family_younger_sister, R.drawable.family_younger_sister));
        words.add(new Word("ama", "grandmother", R.raw.family_grandmother, R.drawable.family_grandmother));
        words.add(new Word("paapa", "grandfather", R.raw.family_grandfather, R.drawable.family_grandfather));

        final WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);
        ListView listView = rootView.findViewById(R.id.words_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = adapter.getItem(position);
                AudioPlayer.playAudioClip(getActivity(), word);
            }
        });

        return rootView;
    }

}
