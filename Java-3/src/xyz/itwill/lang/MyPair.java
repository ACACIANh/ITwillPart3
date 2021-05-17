package xyz.itwill.lang;

public class MyPair<T1, T2> {
	T1 operator;
	T2 index;
	
	public MyPair(T1 operator, T2 index) {
		this.operator = operator;
		this.index = index;
	}

	public T1 getOperator() {
		return operator;
	}

	public T2 getIndex() {
		return index;
	}
	
}
