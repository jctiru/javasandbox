package test.javasandbox.functional.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingLambda {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4 };
		int key = 0;

		process(numbers, key, (v, k) -> {
			try {
				System.out.println(v / k);
			} catch (ArithmeticException e) {
				System.out.println("An arithmetic exception happened");
			}
		});

		process(numbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : numbers) {
			consumer.accept(i, key);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			} catch (ArithmeticException e) {
				System.out.println("Exception caught in wrapper lambda");
			}
		};
	}

}
