package model;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TitleGetter {
	public static Page makePage(URL url) throws IOException {	
		Document doc = Jsoup.connect(url.toString()).get();
		String title = doc.title();

		// タイトル要素を タイトル用にトリミングする
		String[] trims = title.split(" ");
		title = trims[0];

		// タイムスタンプを取得する
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh時mm分ss秒");
		String timestamp = sdf.format(date);

		// ランダムにアクセスした先の URL を取得する
		String encoded = URLEncoder.encode(title, "UTF-8");
		String titleUrl = "https://ja.wikipedia.org/wiki/" + encoded;
		url = new URL(titleUrl);

		// Page オブジェクトにしてリターン
		Page page = new Page(title, url, timestamp);
		return page;
	}
}
