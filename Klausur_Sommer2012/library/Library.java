package library;

import java.util.ArrayList;
import java.util.Collections;

public class Library {
	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<Book> books = new ArrayList<Book>();

	public void addMember(Member member) {
		if (!members.contains(member)) {
			members.add(member);
		}
	}

	public void addBook(Book book) {
		if (!books.contains(book)) {
			books.add(book);

		}
	}

	public Book lendBook(Member member, Person author, String title) {
		for (Book book : books) {
			if (book.getAuthor().getFirstName().equals(author.getFirstName())
					&& book.getAuthor().getSurname().equals(author.getSurname()) && book.getTitle().equals(title)) {
				if (book.getMember() == null) {
					book.setMember(member);
					return book;
				}
			}

		}
		return null;
	}
	

	public void returnBook(Book book) {
		if (!books.isEmpty() && books.contains(book)) {
			books.remove(book);
			book.setMember(null);
		}
		
	}

	public String toString() {
		String string = "Books:\n";
		Collections.sort(books);

		for (Book book : books) {
			string += book.getAuthor().getSurname() + ", " + book.getAuthor().getFirstName() + ": " + book.getTitle()
					+ "\n";

		}
		return string;
	}

}
