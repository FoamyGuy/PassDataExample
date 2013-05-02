package com.makemyandroidapp.passdata.example;

import android.os.Parcel;
import android.os.Parcelable;

public class MyDataObject implements Parcelable{

	String name = "";
	String favoriteWord = "";
	
	
	public MyDataObject(){
		
	}
	
	public MyDataObject(Parcel p){
		this.name = p.readString();
		this.favoriteWord = p.readString();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavoriteWord() {
		return favoriteWord;
	}

	public void setFavoriteWord(String favoriteWord) {
		this.favoriteWord = favoriteWord;
	}

	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel parcel, int flag) {
		parcel.writeString(name);
		parcel.writeString(favoriteWord);
	}
	
	
	public static Parcelable.Creator<MyDataObject> CREATOR  = new Parcelable.Creator<MyDataObject>(){
	      public MyDataObject createFromParcel(Parcel source) {
	            return new MyDataObject(source);
	      }
	      public MyDataObject[] newArray(int size) {
	            return new MyDataObject[size];
	      }
	};
}
