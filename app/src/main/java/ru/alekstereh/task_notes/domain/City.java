package ru.alekstereh.task_notes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

public class City implements Parcelable {
    private final String name;

    @DrawableRes
    private final int icon;


    public City(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    protected City(Parcel in) {
        name = in.readString();
        icon = in.readInt();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
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
