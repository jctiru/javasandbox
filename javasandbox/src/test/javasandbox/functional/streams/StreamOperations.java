package test.javasandbox.functional.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

	static class Book {
		private long isbn;
		private String title;
		private double rating;
		private double price;
		private String source;

		public Book(long isbn, String title, double rating, double price, String source) {
			this.isbn = isbn;
			this.title = title;
			this.rating = rating;
			this.price = price;
			this.source = source;
		}

		public long getIsbn() {
			return isbn;
		}

		public String getTitle() {
			return title;
		}

		public double getRating() {
			return rating;
		}

		public double getPrice() {
			return price;
		}

		public String getSource() {
			return source;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (isbn ^ (isbn >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (isbn != other.isbn)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Book [isbn=" + isbn + ", title=" + title + ", rating=" + rating + ", price=" + price + ", source="
					+ source + "]";
		}

	}

	// Print at most 5 DISTINCT books with rating >= 4.5
	// DB world: SELECT DISTINCT (ISBN) FROM book WHERE rating >= 4.5 LIMIT 0, 5;
	private static void slice(List<Book> books) {
		System.out.println("\nSlice ... ");

		List<String> result = books.stream()
				.filter(d -> d.getRating() >= 4.5)
				.distinct()
				// .peek(d -> System.out.println(d.getTitle() + " " + d.getRating()))
				.limit(5)
				// .skip(5)
				.map(d -> d.getTitle())
				// .forEach(System.out::println);
				.collect(Collectors.toList());

		for (String title : result) {
			System.out.println("title: " + title);
		}

		// Book Stream
		Stream<Book> booksStream = books.stream()
				.filter(d -> d.getRating() >= 4.5);

		// String Stream
		Stream<String> titleStream = booksStream.map(d -> d.getTitle());
		// titleStream.forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();

		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));

		slice(books);
	}

}