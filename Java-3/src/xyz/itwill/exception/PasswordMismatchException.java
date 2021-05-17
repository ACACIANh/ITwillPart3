package xyz.itwill.exception;

//Exception 클래스 상속 받아 예외 클래스 작성 
public class PasswordMismatchException extends Exception {
	private static final long serialVersionUID = 1L;

	public PasswordMismatchException() {
		// 
	}
	
	public PasswordMismatchException(String message) {
		super(message);
	}
}
