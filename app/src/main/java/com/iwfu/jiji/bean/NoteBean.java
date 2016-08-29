package com.iwfu.jiji.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Iwfu on 2016/8/8.
 *
 * 笔记的Bean类
 *
 * 简化测试，只给出String类型
 */
public class NoteBean implements Parcelable {

    private String title;
    private String content;
    private String date;

    public NoteBean (String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    protected NoteBean (Parcel in) {
        title = in.readString ();
        content = in.readString ();
        date = in.readString ();
    }

    public static final Creator<NoteBean> CREATOR = new Creator<NoteBean> () {
        @Override
        public NoteBean createFromParcel (Parcel in) {
            return new NoteBean (in);
        }

        @Override
        public NoteBean[] newArray (int size) {
            return new NoteBean[size];
        }
    };

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel (Parcel dest, int flags) {
        dest.writeString (title);
        dest.writeString (content);
        dest.writeString (date);
    }
}

