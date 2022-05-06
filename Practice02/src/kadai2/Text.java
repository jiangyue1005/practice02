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
		// TODO 自動生成されたメソッド・スタブ

		File file1 = new File("/Users/y_jiang/Documents/unsei.csv");

		FileReader fr1;

		File file2 = new File("/Users/y_jiang/Documents/kekka.txt");

		FileWriter fw;

		FileReader fr2;

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
			fr1.close();

			// ここは日付入力/////////////////////////////////////////////////////////////////////////////////
			System.out.println("誕生日を入力してください。");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String key = br.readLine();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			sdf.setLenient(false);
			// setLenient(false)を呼び出すことによって、このフォーマットを厳密に要求できます。
			sdf.parse(key);

			// ここはさっきの内容をファイルに書き込む//////////////////////////////////////////////////////////////

			fw = new FileWriter(file2, true);
			fr2 = new FileReader(file2);
			BufferedReader on = new BufferedReader(fr2);

			Date d = new Date();

			fw.write(sdf.format(d) + "," + key + ",");

			String date2;
			Random random = new Random();
			while ((date2 = on.readLine()) != null) {
				String[] abb = date2.split(",");
				String td = abb[0];
				String bd = abb[1];
				Omikuji re = list.get(random.nextInt(list.size()));
				String result = re.disp() + "," + re.getNegaigoto() + "," + re.getAkinai() + "," + re.getGakumon();

				if (td.equals(sdf.format(d))) {
					if (bd.equals(key)) {
						if (abb[2] != "") {
							String us = abb[2] + "," + abb[3] + "," + abb[4] + "," + abb[5];
							System.out.println(us.replace(",", "\n"));

						}
					}

				} else {
					fw.write(result + "\n");
					System.out.println(result.replace(",", "\n"));

				}

//				if (abb[0] != sdf.format(d)) {
//
//					fw.write(result + "\n");
//					System.out.println(result.replace(",", "\n"));
//				} else if ((abb[0].equals(sdf.format(d))) && abb[1] != key) {
//
//					fw.write(result + "\n");
//					System.out.println(result.replace(",", "\n"));
//
//				} else if (td.equals(sdf.format(d))) {
//					if (bd.equals(key)) {
//						if (abb[2] != null) {
//
//							String us = abb[2] + "," + abb[3] + "," + abb[4] + "," + abb[5];
//							System.out.println(us.replace(",", "\n"));
//						}
//					}
//
//				}else
//					fw.write(result + "\n");
//				System.out.println(result.replace(",", "\n"));

//

			}
			fw.close();

			fr2.close();

		} catch (

		IOException e) {
			System.out.println("入力された日付は存在しません。");

		} catch (ParseException e) {
			System.out.println("入力された日付は存在しません。");
		}

	}

}
