package com.example.android.miwok.media;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.example.android.miwok.word.Word;

/**
 * Created by hjalmar
 * On 23/12/2017.
 */

public class AudioPlayer {

    private AudioPlayer() {
    }

    private static MediaPlayer mMediaPlayer;
    private final static MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public static synchronized void playAudioClip(Context context, Word word) {
        releaseMediaPlayer();

        // Request audio focus in order to play the audio file.
        int result = MiwokAudioManager.requestAudioFocus();
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mMediaPlayer = MediaPlayer.create(context, word.getAudioClipResourceId());
            mMediaPlayer.setOnCompletionListener(mCompletionListener);
            mMediaPlayer.start();
        }
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    public static synchronized void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            MiwokAudioManager.abandonAudioFocus();
        }
    }

    static MediaPlayer getMediaPlayer() {
        return mMediaPlayer;
    }

}
