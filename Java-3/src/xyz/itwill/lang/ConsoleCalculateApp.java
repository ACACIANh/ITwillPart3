package xyz.itwill.lang;

import java.util.Scanner;

//Ű����� ������� �Է¹޾� �������� ����ϴ� ���α׷��� �ۼ��ϼ���.
//ex) ����� �Է� >> 20 + 10
//    [���]30
// => �Է� ����Ŀ��� ��� ������ �����ڴ� ��Ģ ������(*,/,+,-)�� ���
// => ���Ŀ� ���� ���� ������� �Էµ� ��� ���� �޼��� ��� �� ���α׷� ����
// => �Է� ����Ŀ� ������ �Է� ���� �ϵ��� ó��
public class ConsoleCalculateApp {
	public static void main(String[] args) {
		final int OUT_OF_NUM = -1;
		String[] operators = { "*", "/", "+", "-" };
		int answer = 0;

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine().trim();
		input = input.replace(" ", "");
		String nowOperator = null;

		//ArrayList<String> operatorList = new ArrayList<String>();
		
		int operatorIndex = OUT_OF_NUM;
		for (String operator : operators) {
			if (input.indexOf(operator) != OUT_OF_NUM) {
				operatorIndex = input.indexOf(operator);
				nowOperator = operator;
			}
		}
		
		//����ó��
		if (operatorIndex == -1) {
			System.out.println("������� �߸��Ǿ����ϴ�.");
			scanner.close();
			System.exit(0);
		}
		
		String[] calcArray = new String[2];
		
		switch(nowOperator) {
		case "+":
			calcArray = input.split("\\+");
			break;
		case "-":
			calcArray = input.split("\\-");
			break;
		case "*":
			calcArray = input.split("\\*");
			break;
		case "/":
			calcArray = input.split("\\/");
			break;
		}
		
		//calcArray = input.split(nowOperator);
		
		int calcData[] = new int[calcArray.length];
		
		for(int i=0; i<calcArray.length; ++i) {
			calcData[i] = Integer.parseInt(calcArray[i]); 
		}
		
		
		switch(nowOperator) {
		case "+":
			answer = calcData[0] + calcData[1];
			break;
		case "-":
			answer = calcData[0] - calcData[1];
			break;
		case "*":
			answer = calcData[0] * calcData[1];
			break;
		case "/":
			answer = calcData[0] / calcData[1];
			break;
		}

		System.out.println(answer);
		scanner.close();
	}
}
