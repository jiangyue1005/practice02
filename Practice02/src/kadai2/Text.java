package kadai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Text {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// boolean dateFlg = true;
		Omikuji[] omikuji = { new Daikichi(), new Chukichi(), new Shokichi(),new Suekichi(),new Kichi(),new Kyo() };
		for (int i = 0; i < omikuji.length; i++) {
			omikuji[i].setUnsei();
		}
		try {
			System.out.println("誕生日を入力してください。");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String key = br.readLine();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			sdf.setLenient(false);
			// setLenient(false)を呼び出すことによって、このフォーマットを厳密に要求できます。
			// java.util.Date j =
			sdf.parse(key);

			System.out.println("入力された日付は存在します。");

		} catch (IOException e) {
			System.out.println("入力された日付は存在しません。");

		} catch (ParseException e) {
			System.out.println("入力された日付は存在しません。");
		}

		}

}
