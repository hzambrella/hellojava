package testAndtry;

public class TestSelfException extends Exception {
	public static void main(String[] args) throws TestSelfException {
		throw new TestSelfException();
	}
}
