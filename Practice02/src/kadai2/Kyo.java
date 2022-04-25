package kadai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Kyo extends Omikuji implements Fortune{
	
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
				String kichi = arr[0];
				if ("凶".equals(kichi)) {
					
					System.out.println(date);
				}
			}
			fr.close();

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	@Override
	public void setUnsei() {
		// TODO 自動生成されたメソッド・スタブ
		
		
	}
	@Override
	public String disp() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
