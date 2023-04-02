package tajbanana.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tajbanana.springdatajpa.domain.Book;
import tajbanana.springdatajpa.repositories.BookRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SpringDataJpaSpliceTest {

  @Autowired
  BookRepository bookRepository;

  @Test
  void testJpaSplice() {
    long count = bookRepository.count();

    bookRepository.save(new Book("My Book", "11111", "Self"));

    long countAfter = bookRepository.count();
    assertThat(count).isLessThan(countAfter);
  }
}
