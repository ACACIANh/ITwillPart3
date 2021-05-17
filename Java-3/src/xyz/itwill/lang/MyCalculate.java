package xyz.itwill.lang;

import java.util.Iterator;
import java.util.LinkedList;

public class MyCalculate {
	public static final int OUT_OF_RANGE = -1;
	public static final String[] operators = { "*", "/", "+", "-" };

	LinkedList<String> strList = null;
	// new LinkedList<String>();

	public LinkedList<String> getStrList() {
		return strList;
	}

	public MyCalculate(String str) {
		strList = new LinkedList<String>();
		strList.add(str);
		devideProgress();
		printState();
		priorityCalcProgress();
		printState();
		normalCalcProgress();
		printState();
	}

	void devideProgress() {
		loopWhile: 
		while (true) {
			Iterator<String> iter = strList.iterator();
			for (int index = 0; iter.hasNext(); ++index) {
				String iterStr = iter.next();
				int stateIndex = hasOperator(iterStr);
				if (0 == stateIndex) {
					// 연산자가 바로 만나면 다음순회
					continue;
				} else if (-1 == stateIndex) {
					// 나눌게 없다면
					// break loopWhile;
					continue;
				} else {
					// 나눌게 있다면
					devide(index, stateIndex, iterStr);
					continue loopWhile;
				}
			}
			break;
		}
	}

	boolean hasPriorityOperator(String str) {
		for (int i = 0; i < 2; ++i) {
			if (str.equals(MyCalculate.operators[i])) {
				return true;
			}
		}
		return false;
	}
	
	int hasOperator(String str) {
		int index = MyCalculate.OUT_OF_RANGE;
		for (String operator : MyCalculate.operators) {
			if (str.indexOf(operator) != MyCalculate.OUT_OF_RANGE) {
				index = str.indexOf(operator);
				break;
			}
		}
		return index;
	}

	void devide(int listIndex, int stateIndex, String str) {
		// 연산자 한번 더 찾는게 불합리함
		int index = MyCalculate.OUT_OF_RANGE;
		for (String operator : MyCalculate.operators) {
			if (str.indexOf(operator) != MyCalculate.OUT_OF_RANGE) {
				strList.remove(listIndex);
				index = str.indexOf(operator);
				String str1 = str.substring(0, index);
				String str2 = str.substring(index + 1);
				strList.add(listIndex, str2);
				strList.add(listIndex, operator);
				strList.add(listIndex, str1);
				break;
			}
		}
	}

	void priorityCalcProgress() {
		loopWhile: 
			while (true) {
				Iterator<String> iter = strList.iterator();
				for (int index = 0; iter.hasNext(); ++index) {
					String iterStr = iter.next();
					if(hasPriorityOperator(iterStr)) {
						priorityCalc(index);
						continue loopWhile;
					}
				}
				break;
			}
	}
	
	void priorityCalc(int index) {
		String str1 = strList.remove(index - 1);
		String operator = strList.remove(index - 1);
		String str2 = strList.remove(index - 1);

		double t1 = Double.parseDouble(str1);
		double t2 = Double.parseDouble(str2);
		double result = 0;
		if (operator.equals("*")) {
			result = t1 * t2;
		} else if (operator.equals("/")) {
			result = t1 / t2;
		}
		strList.add(index - 1, ((Double) result).toString());
	}

	void normalCalcProgress() {
		loopWhile: 
			while (true) {
				Iterator<String> iter = strList.iterator();
				for (int index = 0; iter.hasNext(); ++index) {
					String iterStr = iter.next();
					if(hasOperator(iterStr) == 0) {
						normalCalc(index);
						continue loopWhile;
					}
				}
				break;
			}
	}
	
	void normalCalc(int index) {
		String str1 = strList.remove(index - 1);
		String operator = strList.remove(index - 1);
		String str2 = strList.remove(index - 1);

		double t1 = Double.parseDouble(str1);
		double t2 = Double.parseDouble(str2);
		double result = 0;
		if (operator.equals("+")) {
			result = t1 + t2;
		} else if (operator.equals("-")) {
			result = t1 - t2;
		}
		strList.add(index - 1, ((Double) result).toString());
	}

	public void printState() {
		System.out.print("현재 상태 :  ");
		for (String str : strList) {
			System.out.print(str);
		}	
		System.out.println("");
	}
	
}
