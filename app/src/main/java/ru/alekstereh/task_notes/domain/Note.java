package ru.alekstereh.task_notes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

public class Note implements Parcelable {
    private final String name;

    @DrawableRes
    private final int icon;


    public Note(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    protected Note(Parcel in) {
        name = in.readString();
        icon = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getIcon() {
        return icon;
    }

    public String getName(){
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(icon);
    }
}
