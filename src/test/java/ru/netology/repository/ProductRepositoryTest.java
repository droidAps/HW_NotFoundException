package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Product one = new Book(1, "Картошка и ее тайная жизнь", 199, "Васильков И.И.", 25, 2020);
    Product two = new Book(2, "Samsung навсегда", 99, "Графоманов О.О.", 56, 2019);
    Product three = new TShirt(3, "Nike", 999, "green", "S");
    Product four = new Book(4, "Жизнь успешных людей", 499, "Переделкин Ж.Ж.", 189, 2021);
    Product five = new TShirt(5, "Adidas", 3100, "black", "M");

    @Test
    void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
        repo.save(five);

        repo.removeById(3);

        Product[] expected = new Product[] {one, two, four, five};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void notFoundExceptionTest() {
        ProductRepository repo = new ProductRepository();
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
        repo.save(five);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(7);
        });
    }
}