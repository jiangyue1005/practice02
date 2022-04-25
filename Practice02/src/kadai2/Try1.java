package kadai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Try1 extends Omikuji implements Fortune {

	public void setUnsei() {
		// TODO 自動生成されたメソッド・スタブ

		File file = new File("/Users/y_jiang/Documents/unsei.csv");

		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);

			String date;
			while ((date = in.readLine()) != null) {
				String[] arr = date.split(",");
				String kichi = arr[0];
				if ("中吉".equals(kichi)) {
					System.out.println(kichi);
				}
			}
			fr.close();

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@Override
	public String disp() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

//	public void setUnsei() {
//			// TODO 自動生成されたメソッド・スタブ
//			Random random = new Random();
//			random.nextInt(date.size();
//		}

}
