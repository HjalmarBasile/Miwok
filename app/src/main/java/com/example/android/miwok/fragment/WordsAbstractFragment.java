package com.example.android.miwok.fragment;

import android.support.v4.app.Fragment;

import com.example.android.miwok.media.AudioPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class WordsAbstractFragment extends Fragment {

    public WordsAbstractFragment() {
        // Required empty public constructor
    }

    @Override
    public void onPause() {
        super.onPause();
        AudioPlayer.releaseMediaPlayer();
    }

    @Override
    public void onResume() {
        super.onResume();
        AudioPlayer.releaseMediaPlayer();
    }

}
