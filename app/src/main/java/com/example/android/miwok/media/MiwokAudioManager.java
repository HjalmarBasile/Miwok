package com.example.android.miwok.media;

import android.media.AudioManager;

/**
 * Created by hjalmar
 * On 23/12/2017.
 */

public class MiwokAudioManager {

    private static AudioManager mAudioManager;
    private static boolean setAudioManager = false;

    private static AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                    AudioPlayer.getMediaPlayer().start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    // The AUDIOFOCUS_LOSS case means we've lost audio focus, so we'll
                    // stop playback and clean up resources
                    AudioPlayer.releaseMediaPlayer();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    // Pause playback and reset player to the start of the file. That way, we can
                    // play the word from the beginning when we resume playback.
                    AudioPlayer.getMediaPlayer().pause();
                    AudioPlayer.getMediaPlayer().seekTo(0);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown focus change type: " + focusChange);
            }
        }
    };

    public static synchronized void setAudioManager(AudioManager audioManager) {
        if (!setAudioManager) {
            mAudioManager = audioManager;
            setAudioManager = true;
        }
    }

    static int requestAudioFocus() {
        // The app needs to play short audio files, so we will request audio focus
        // with a short amount of time passing AUDIOFOCUS_GAIN_TRANSIENT as third parameter.
        return mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_NOTIFICATION, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
    }

    static void abandonAudioFocus() {
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }

}
