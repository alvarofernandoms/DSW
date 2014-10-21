package db;

import java.util.*;

import video.Video;

public class VideoDB {
	HashMap<String, Video> theVideoDB = new HashMap<String, Video>();

	public VideoDB() {
	}

	public void addVideo(Video videoObject01) {
		theVideoDB.put(videoObject01.getCountry(), videoObject01);
	}

	public Video getCountry(String country01) {
		return theVideoDB.get(country01);
	}
}