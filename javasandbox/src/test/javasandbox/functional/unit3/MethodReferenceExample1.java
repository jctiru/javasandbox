package test.javasandbox.functional.unit3;

public class MethodReferenceExample1 {

	public static void main(String[] args) {

		Thread t = new Thread(MethodReferenceExample1::printMessage); // MethodReferenceExample::printMessage == () -> printMessage()
		t.start();

	}

	public static void printMessage() {
		System.out.println("Hello");
	}

}
