package com.sangcomz.fishbun.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Album implements Parcelable {
    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
    public final long bucketId;
    public final String bucketName;
    public int counter;
    public String thumbnailPath;

    public Album(long bucketId2, String bucketName2, String thumbnailPath2, int counter2) {
        this.bucketId = bucketId2;
        this.bucketName = bucketName2;
        this.counter = counter2;
        this.thumbnailPath = thumbnailPath2;
    }

    protected Album(Parcel in) {
        this.bucketId = in.readLong();
        this.bucketName = in.readString();
        this.counter = in.readInt();
        this.thumbnailPath = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.bucketId);
        parcel.writeString(this.bucketName);
        parcel.writeInt(this.counter);
        parcel.writeString(this.thumbnailPath);
    }
}
