package com.example.user.mvpsorter.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NetObject {

    @SerializedName("type")
    String type;
    @SerializedName("length")
    int length;
    @SerializedName("data")
    ArrayList<Integer> numbers;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }
}
