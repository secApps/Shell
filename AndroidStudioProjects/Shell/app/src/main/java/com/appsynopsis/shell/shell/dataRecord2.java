package com.appsynopsis.shell.shell;

/**
 * Created by nila on 4/7/15.
 */
public class dataRecord2 {
    public String  id,address,lat,longi,comtact,services,name,divitions;

    public dataRecord2(String divitions,String id, String address, String lat, String longi, String comtact, String services, String name) {
        this.divitions=divitions;
        this.id = id;
        this.address = address;
        this.lat = lat;
        this.longi = longi;
        this.comtact = comtact;
        this.services = services;
        this.name = name;
    }
    public String getdivitions() {
        return divitions;
    }
    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLongi() {
        return longi;
    }

    public String getComtact() {
        return comtact;
    }

    public String getServices() {
        return services;
    }

    public String getName() {
        return name;
    }
}
