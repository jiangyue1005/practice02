package kadai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Chukichi extends Omikuji implements Fortune {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		File file = new File("/Users/y_jiang/Documents/unsei.csv");
		

		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);

			String date;
			while ((date = in.readLine()) != null) {
				String[] arr = date.split(",");
				// String chukichi = arr[0];
				if ("中吉".equals(arr[0])) {
					System.out.println(date);

				}
			}

			fr.close();

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void setUnsei() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public String disp() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
