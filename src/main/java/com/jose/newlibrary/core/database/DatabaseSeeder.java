
package com.jose.newlibrary.core.database;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jose.newlibrary.library.model.entity.Author;
import com.jose.newlibrary.library.model.entity.Book;
import com.jose.newlibrary.library.model.entity.Nationality;
import com.jose.newlibrary.library.repository.AuthorRepository;
import com.jose.newlibrary.library.repository.BookRepository;
import com.jose.newlibrary.library.repository.NationalityRepository;

/**
 * DatabaseSeeder
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final NationalityRepository nationalityRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DatabaseSeeder(NationalityRepository nationalityRepository, AuthorRepository authorRepository, BookRepository bookRepository){
        this.nationalityRepository = nationalityRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

	@Override
	public void run(String... args) throws Exception {
        if(nationalityRepository.count() == 0){
            Nationality al = new Nationality("Alemania");
            Nationality fr = new Nationality("Francia");
            Nationality ing = new Nationality("Inglaterra");
            Nationality rs = new Nationality("Rusia");

            nationalityRepository.saveAll(List.of(al, fr, ing, rs));
            System.out.println("Datos de nacionalidades de prueba insertados");

            Author mann = new Author();
            mann.setName("Thomas mann");
            mann.setNationality(al);

            Author hesse = new Author();
            hesse.setName("Herman Hesse");
            hesse.setNationality(al);

            Author dosto = new Author();
            dosto.setName("Fiódor Dostoievski");
            dosto.setNationality(rs);

            authorRepository.saveAll(List.of(mann, hesse, dosto));
            System.out.println("Datos de autores de prueba insertados");

            // Libros de Thomas Mann
            Book l1 = new Book("La montaña mágica", LocalDate.of(1924, 11, 7), mann);
            Book l2 = new Book("Los Buddenbrook", LocalDate.of(1901, 10, 1), mann);
            Book l3 = new Book("Muerte en Venecia", LocalDate.of(1912, 5, 23), mann);
            Book l4 = new Book("Doctor Faustus", LocalDate.of(1947, 10, 18), mann);
            Book l5 = new Book("José y sus hermanos", LocalDate.of(1933, 1, 1), mann);
            Book l6 = new Book("Carlota en Weimar", LocalDate.of(1939, 1, 1), mann);

            // Libros de Hermann Hesse
            Book l7 = new Book("Demian", LocalDate.of(1919, 1, 1), hesse);
            Book l8 = new Book("Siddhartha", LocalDate.of(1922, 1, 1), hesse);
            Book l9 = new Book("El lobo estepario", LocalDate.of(1927, 1, 1), hesse);
            Book l10 = new Book("Narciso y Goldmundo", LocalDate.of(1930, 1, 1), hesse);
            Book l11 = new Book("El juego de abalorios", LocalDate.of(1943, 1, 1), hesse);
            Book l12 = new Book("Bajo las ruedas", LocalDate.of(1906, 1, 1), hesse);

            // Libros de Fiódor Dostoievski
            Book l13 = new Book("Crimen y castigo", LocalDate.of(1866, 1, 1), dosto);
            Book l14 = new Book("El idiota", LocalDate.of(1869, 1, 1), dosto);
            Book l15 = new Book("Los demonios", LocalDate.of(1872, 1, 1), dosto);
            Book l16 = new Book("Los hermanos Karamázov", LocalDate.of(1880, 1, 1), dosto);
            Book l17 = new Book("Humillados y ofendidos", LocalDate.of(1861, 1, 1), dosto);
            Book l18 = new Book("Noches blancas", LocalDate.of(1848, 1, 1), dosto);
            Book l19 = new Book("El jugador", LocalDate.of(1867, 1, 1), dosto);
            Book l20 = new Book("Memorias del subsuelo", LocalDate.of(1864, 1, 1), dosto);

            // Guardar todo
            bookRepository.saveAll(List.of(
                l1, l2, l3, l4, l5, l6,
                l7, l8, l9, l10, l11, l12,
                l13, l14, l15, l16, l17, l18, l19, l20
            ));

            System.out.println("Datos de libros de prueba insertados");

        }
	}

    
}
