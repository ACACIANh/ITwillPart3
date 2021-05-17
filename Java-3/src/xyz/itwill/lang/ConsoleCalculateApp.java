package xyz.itwill.lang;

import java.util.Scanner;


//키보드로 연산식을 입력받아 연산결과를 출력하는 프로그램을 작성하세요.
//ex) 연산식 입력 >> 20 + 10
//    [결과]30
// => 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)만 허용
// => 형식에 맞지 않은 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 종료
// => 입력 연산식에 공백이 입력 가능 하도록 처리
public class ConsoleCalculateApp {
	public static void main(String[] args) {
		//int answer = 0;
		System.out.println( "수식을 입력 하세요. ");
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine().replace(" ", "");

		MyCalculate calculator = new MyCalculate(input);

		calculator.printState();

		scanner.close();

//		int operatorIndex = OUT_OF_RANGE;
//		for (String operator : operators) {
//			if (input.indexOf(operator) != OUT_OF_RANGE) {
//				operatorIndex = input.indexOf(operator);
//			}
//		}
//		
//		//예외처리
//		if (operatorIndex == -1) {
//			System.out.println("연산식이 잘못되었습니다.");
//			scanner.close();
//			System.exit(0);
//		}
//		
//		String[] calcArray = new String[2];
//		
//		switch(nowOperator) {
//		case "+":
//			calcArray = input.split("\\+");
//			break;
//		case "-":
//			calcArray = input.split("\\-");
//			break;
//		case "*":
//			calcArray = input.split("\\*");
//			break;
//		case "/":
//			calcArray = input.split("\\/");
//			break;
//		}
//		
//		//calcArray = input.split(nowOperator);
//		
//		int calcData[] = new int[calcArray.length];
//		
//		for(int i=0; i<calcArray.length; ++i) {
//			calcData[i] = Integer.parseInt(calcArray[i]); 
//		}
//		
//		switch(nowOperator) {
//		case "+":
//			answer = calcData[0] + calcData[1];
//			break;
//		case "-":
//			answer = calcData[0] - calcData[1];
//			break;
//		case "*":
//			answer = calcData[0] * calcData[1];
//			break;
//		case "/":
//			answer = calcData[0] / calcData[1];
//			break;
//		}
//		System.out.println(answer);
	}
}
