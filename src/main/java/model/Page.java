package model;

import java.io.Serializable;
import java.net.URL;

public class Page implements Serializable {
	private String title; // タイトル
	private URL url; // URL
	private String timestamp; // タイムスタンプ
	
	public Page() {};
	public Page(String title, URL url, String timestamp) {
		this.title = title;
		this.url = url;
		this.timestamp = timestamp;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
