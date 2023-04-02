package tajbanana.springdatajpa;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import tajbanana.springdatajpa.domain.Book;
import tajbanana.springdatajpa.repositories.BookRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringDataJpaSpliceTest {

  @Autowired
  BookRepository bookRepository;

  @Commit
  @Order(1)
  @Test
  void testJpaSplice() {
    long countBefore = bookRepository.count();
    assertThat(countBefore).isEqualTo(0);

    bookRepository.save(new Book("My Book", "11111", "Self"));

    long countAfter = bookRepository.count();
    assertThat(countBefore).isLessThan(countAfter);
  }

  @Order(2)
  @Test
  void jpaTestSpliceTransactions() {
    long count = bookRepository.count();

    assertThat(count).isEqualTo(1);
  }
}
