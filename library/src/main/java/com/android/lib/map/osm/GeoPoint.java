package com.android.lib.map.osm;

import java.io.Serializable;

public class GeoPoint implements Serializable {

	private int latitudeE6 = 0;
    private int longitudeE6 = 0;

    public GeoPoint() { }

    public GeoPoint(int latitudeE6, int longitudeE6) {
        setLatitudeE6(latitudeE6);
        setLongitudeE6(longitudeE6);
    }

    public GeoPoint(double latitude, double longitude) {
        setLatitudeE6((int) (latitude * 1e6));
        setLongitudeE6((int) (longitude * 1e6));
    }

    public int getLatitudeE6() {
        return latitudeE6;
    }

    public void setLatitudeE6(int latitudeE6) {
        this.latitudeE6 = (int)(normalizeLatitude((double)(latitudeE6 / 1E6)));
    }

    public int getLongitudeE6() {
        return longitudeE6;
    }

    public double normalizeLatitude(double latitude) {
    	 
    	if (!Double.isNaN(latitude)) {
	         if (latitude < -90) 
	 	            return -90 * 1E6;
	 		 else if (latitude > 90) 
	 	            return 90 * 1E6;
    	}

    	return latitude * 1E6;
    }

    public double normalizeLongitude(double longitude) {
    	 
    	if (!Double.isNaN(longitude)) {

    		 if (longitude < -180) 
    	            return (((longitude - 180) % 360) + 180 ) * 1E6;
    		 else if (longitude > 180) 
    	            return (((longitude + 180) % 360) - 180 ) * 1E6;
    
    	   	}

    	return longitude * 1E6;
    }

    public void setLongitudeE6(int longitudeE6) {
        this .longitudeE6 =  (int)(normalizeLongitude(longitudeE6 / 1E6));
    }
}