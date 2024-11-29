package test;

import java.io.IOException;
import java.net.URL;

import model.Page;
import model.TitleGetter;

public class TestTitleGetter {

	public static void main(String[] args) {

		// URLの指定
		URL url;
		
		try {
			url = new URL("https://ja.wikipedia.org/wiki/Special:Random");
			Page page = TitleGetter.makePage(url);
			System.out.println(page.getTitle());
			System.out.println("成功: タイトルの取得に成功しました。");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("失敗: タイトルの取得に失敗しました。");
		}		
	}

}
