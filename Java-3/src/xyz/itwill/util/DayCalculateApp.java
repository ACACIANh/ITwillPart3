package xyz.itwill.util;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램을 작성하세요.
//ex) 생년월일 입력[ex.2000-01-01] >> 2021-05-16
//    [결과]태어난지 1일 지났습니다.
// => 형식에 맞지 않은 생년월일을 입력한 경우 에러 메세지 출력 후 프로그램 종료
public class DayCalculateApp {
	public static void main(String[] args) {

		Date birthDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("생년월일 입력[ex.2000-01-01] >> ");
			String input = scanner.nextLine();
			try {
				birthDate = dateFormat.parse(input);
				break;
			} catch (Exception e) {
				if (e instanceof ParseException)
					System.out.println("형식을 맞춰주세요");
				else {
					System.out.println("다른 오류");
				}
			} 
		}
		scanner.close();
		
		long birthTime = birthDate.getTime();
		long pastSecond = (System.currentTimeMillis() - birthTime) / 1000;
		long pastDay = (pastSecond / 60 / 60 / 24);

		System.out.println("[결과] 태어난지 " + pastDay + "일 지났습니다.");
	}
}
