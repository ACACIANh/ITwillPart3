package xyz.itwill.exception;

//Exception Ŭ���� ��� �޾� ���� Ŭ���� �ۼ� 
public class PasswordMismatchException extends Exception {
	private static final long serialVersionUID = 1L;

	public PasswordMismatchException() {
		// 
	}
	
	public PasswordMismatchException(String message) {
		super(message);
	}
}
