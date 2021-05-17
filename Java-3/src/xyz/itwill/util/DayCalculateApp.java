package xyz.itwill.util;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//Ű����� ��������� �Է¹޾� ���ñ��� ��ƿ� ��¥(��)�� ����Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���.
//ex) ������� �Է�[ex.2000-01-01] >> 2021-05-16
//    [���]�¾�� 1�� �������ϴ�.
// => ���Ŀ� ���� ���� ��������� �Է��� ��� ���� �޼��� ��� �� ���α׷� ����
public class DayCalculateApp {
	public static void main(String[] args) {

		Date birthDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("������� �Է�[ex.2000-01-01] >> ");
			String input = scanner.nextLine();
			try {
				birthDate = dateFormat.parse(input);
				break;
			} catch (Exception e) {
				if (e instanceof ParseException)
					System.out.println("������ �����ּ���");
				else {
					System.out.println("�ٸ� ����");
				}
			} 
		}
		scanner.close();
		
		long birthTime = birthDate.getTime();
		long pastSecond = (System.currentTimeMillis() - birthTime) / 1000;
		long pastDay = (pastSecond / 60 / 60 / 24);

		System.out.println("[���] �¾�� " + pastDay + "�� �������ϴ�.");
	}
}
