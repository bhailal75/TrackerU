package com.example.himmat.trucktracking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeData {

@SerializedName("imei")
@Expose
private String imei;
@SerializedName("name")
@Expose
private String name;
@SerializedName("dt_server")
@Expose
private String dtServer;
@SerializedName("dt_tracker")
@Expose
private String dtTracker;
@SerializedName("lat")
@Expose
private String lat;
@SerializedName("lng")
@Expose
private String lng;
@SerializedName("port")
@Expose
private String port;
@SerializedName("active")
@Expose
private String active;
@SerializedName("altitude")
@Expose
private String altitude;
@SerializedName("angle")
@Expose
private String angle;
@SerializedName("speed")
@Expose
private String speed;
@SerializedName("address")
@Expose
private String address;
@SerializedName("params")
@Expose
private HomeParams params;
@SerializedName("loc_valid")
@Expose
private String locValid;

public String getImei() {
return imei;
}

public void setImei(String imei) {
this.imei = imei;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDtServer() {
return dtServer;
}

public void setDtServer(String dtServer) {
this.dtServer = dtServer;
}

public String getDtTracker() {
return dtTracker;
}

public void setDtTracker(String dtTracker) {
this.dtTracker = dtTracker;
}

public String getLat() {
return lat;
}

public void setLat(String lat) {
this.lat = lat;
}

public String getLng() {
return lng;
}

public void setLng(String lng) {
this.lng = lng;
}

public String getPort() {
return port;
}

public void setPort(String port) {
this.port = port;
}

public String getActive() {
return active;
}

public void setActive(String active) {
this.active = active;
}

public String getAltitude() {
return altitude;
}

public void setAltitude(String altitude) {
this.altitude = altitude;
}

public String getAngle() {
return angle;
}

public void setAngle(String angle) {
this.angle = angle;
}

public String getSpeed() {
return speed;
}

public void setSpeed(String speed) {
this.speed = speed;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public HomeParams getParams() {
return params;
}

public void setParams(HomeParams params) {
this.params = params;
}

public String getLocValid() {
return locValid;
}

public void setLocValid(String locValid) {
this.locValid = locValid;
}

}