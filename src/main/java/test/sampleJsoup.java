package test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class sampleJsoup {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://ja.wikipedia.org/wiki/Special:Random").get();

		String title = doc.title();

		System.out.println(title);
	}
}
