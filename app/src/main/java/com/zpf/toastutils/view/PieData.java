package com.zpf.toastutils.view;

import android.support.annotation.NonNull;

/**
 * Created by zpf on 2018/9/2.
 */

public class PieData {

    private String name;
    private float value;
    private float percenttage;

    private int color;
    private float angle;


    public PieData(@NonNull String name,@NonNull  float value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercenttage() {
        return percenttage;
    }

    public void setPercenttage(float percenttage) {
        this.percenttage = percenttage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "PieData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", percenttage=" + percenttage +
                ", color=" + color +
                ", angle=" + angle +
                '}';
    }
}
