package com.example.android.miwok.word;

/**
 * Created by hjalmar
 * On 17/12/2017.
 * <p>
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Miwok translation for that word and an image representing the word.
 */
public class Word {

    private final static int INVALID_IMAGE_ID = 0;

    private final String mMiwokTranslation;
    private final String mDefaultTranslation;
    private final int mAudioClipResourceId;
    private final int mImageResourceId;

    /**
     * Create a new Word object.
     *
     * @param miwokTranslation    is the word in the Miwok language
     * @param defaultTranslation  is the word in a language that the user is already familiar with (such as English)
     * @param audioClipResourceId is the resource id of the word audio clip
     */
    public Word(String miwokTranslation, String defaultTranslation, int audioClipResourceId) {
        this.mMiwokTranslation = miwokTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mAudioClipResourceId = audioClipResourceId;
        this.mImageResourceId = INVALID_IMAGE_ID;
    }

    /**
     * Create a new Word object.
     *
     * @param miwokTranslation    is the word in the Miwok language
     * @param defaultTranslation  is the word in a language that the user is already familiar with (such as English)
     * @param audioClipResourceId is the resource id of the word audio clip
     * @param imageResourceId     is the resource id of the image we want to display
     */
    public Word(String miwokTranslation, String defaultTranslation, int audioClipResourceId, int imageResourceId) {
        this.mMiwokTranslation = miwokTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mAudioClipResourceId = audioClipResourceId;
        this.mImageResourceId = imageResourceId;
    }

    /**
     * Get the Miwok translation of the word.
     */
    String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the default translation of the word.
     */
    String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the resource id of the word audio clip.
     */
    public int getAudioClipResourceId() {
        return mAudioClipResourceId;
    }

    /**
     * Get the resource id of the image representing the word.
     */
    int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not this word has an associated image or not.
     */
    boolean hasImage() {
        return mImageResourceId != INVALID_IMAGE_ID;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mAudioClipResourceId=" + mAudioClipResourceId +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
