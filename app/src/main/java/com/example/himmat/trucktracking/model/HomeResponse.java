package com.example.himmat.trucktracking.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeResponse {

@SerializedName("data")
@Expose
private List<HomeData> data = null;

public List<HomeData> getData() {
return data;
}

public void setData(List<HomeData> data) {
this.data = data;
}

}