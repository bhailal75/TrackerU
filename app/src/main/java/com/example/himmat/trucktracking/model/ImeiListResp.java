package com.example.himmat.trucktracking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImeiListResp {

@SerializedName("imei")
@Expose
private String imei;
@SerializedName("protocol")
@Expose
private String protocol;
@SerializedName("ip")
@Expose
private String ip;
@SerializedName("port")
@Expose
private String port;
@SerializedName("active")
@Expose
private String active;
@SerializedName("object_expire")
@Expose
private String objectExpire;
@SerializedName("object_expire_dt")
@Expose
private String objectExpireDt;
@SerializedName("name")
@Expose
private String name;

public String getImei() {
return imei;
}

public void setImei(String imei) {
this.imei = imei;
}

public String getProtocol() {
return protocol;
}

public void setProtocol(String protocol) {
this.protocol = protocol;
}

public String getIp() {
return ip;
}

public void setIp(String ip) {
this.ip = ip;
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

public String getObjectExpire() {
return objectExpire;
}

public void setObjectExpire(String objectExpire) {
this.objectExpire = objectExpire;
}

public String getObjectExpireDt() {
return objectExpireDt;
}

public void setObjectExpireDt(String objectExpireDt) {
this.objectExpireDt = objectExpireDt;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

}