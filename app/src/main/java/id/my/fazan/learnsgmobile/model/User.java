package id.my.fazan.learnsgmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public String nama, gender;
    public int umur;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.gender);
        dest.writeInt(this.umur);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.nama = in.readString();
        this.gender = in.readString();
        this.umur = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
