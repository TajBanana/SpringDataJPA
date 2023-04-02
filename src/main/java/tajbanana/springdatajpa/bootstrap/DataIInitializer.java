package tajbanana.springdatajpa.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tajbanana.springdatajpa.domain.Book;
import tajbanana.springdatajpa.repositories.BookRepository;

@Component
public class DataIInitializer implements CommandLineRunner {
  private final BookRepository bookRepository;

  public DataIInitializer(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) {
    Book bookDDD =  new Book("Domain Driven Design", "12345", "Random");
    Book bookSIA =  new Book("Spring in Action", "54321", "Random");

    Book savedDDD = bookRepository.save(bookDDD);
    System.out.println("ID: " + savedDDD.getId());

    Book savedSIA = bookRepository.save(bookSIA);
    System.out.println("ID: " + savedSIA.getId());

    bookRepository.findAll().forEach(book -> System.out.println(book.toString()));
  }
}
