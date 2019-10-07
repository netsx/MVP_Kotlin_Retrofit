
package com.core.kotlin.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("average")
    @Expose
    private Object average;

    public Object getAverage() {
        return average;
    }

    public void setAverage(Object average) {
        this.average = average;
    }

}
