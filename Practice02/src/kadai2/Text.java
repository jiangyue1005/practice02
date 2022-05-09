package kadai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Text {

	public static void main(String[] args) {

		File file1 = new File("/Users/y_jiang/Documents/unsei.csv");

		FileReader fr1 = null;

		File file2 = new File("/Users/y_jiang/Documents/result.txt");

		FileWriter fw = null;

		FileReader fr2 = null;

		List<Omikuji> list = new ArrayList<Omikuji>();
		Omikuji omikuji = null;

		try {

			fr1 = new FileReader(file1);
			BufferedReader in = new BufferedReader(fr1);

			String date;
			while ((date = in.readLine()) != null) {
				String[] arr = date.split(",");
				// System.out.println(arr[0]);

				switch (arr[0]) {
				case "大吉":
					omikuji = new Daikichi();
					break;
				case "中吉":
					omikuji = new Chukichi();
					break;
				case "小吉":
					omikuji = new Shokichi();
					break;
				case "末吉":
					omikuji = new Suekichi();
					break;
				case "吉":
					omikuji = new Kichi();
					break;
				case "凶":
					omikuji = new Kyo();
					break;

				}

				omikuji.setUnsei();
				omikuji.setNegaigoto(arr[1]);
				omikuji.setAkinai(arr[2]);
				omikuji.setGakumon(arr[3]);

				list.add(omikuji);

			}

			// ここは日付入力/////////////////////////////////////////////////////////////////////////////////
			System.out.println("誕生日を入力してください。");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String key = br.readLine();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			sdf.setLenient(false);
			// setLenient(false)を呼び出すことによって、このフォーマットを厳密に要求できます。
			sdf.parse(key);

			fw = new FileWriter(file2, true);
			fr2 = new FileReader(file2);
			BufferedReader on = new BufferedReader(fr2);

			Random random = new Random();
			Date d = new Date();
			// fw1.write(sdf.format(d) + "," + key + ",");

			String date2;
			boolean resultFlg = false;
			while ((date2 = on.readLine()) != null) {
				String[] abb = date2.split(",");
				String td = abb[0];
				String bd = abb[1];

				if (td.equals(sdf.format(d))) {
					if (bd.equals(key)) {
						String us = abb[2] + "," + abb[3] + "," + abb[4] + "," + abb[5];
						System.out.println(us.replace(",", "\n"));
						resultFlg = true;
					}
				}
			}
			if (!resultFlg) {
				Omikuji re = list.get(random.nextInt(list.size()));
				String result = re.disp() + "," + re.getNegaigoto() + "," + re.getAkinai() + "," + re.getGakumon();
				fw.write(sdf.format(d) + "," + key + "," + result + "\n");
				System.out.println(result.replace(",", "\n"));
			}

		} catch (IOException e) {
			System.out.println("入力された日付は存在しません。");

		} catch (ParseException e) {
			System.out.println("入力された日付は存在しません。");
		} finally {
			try {
				fr1.close();
				fw.close();
				fr2.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

}
