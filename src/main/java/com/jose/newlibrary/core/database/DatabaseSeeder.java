
package com.jose.newlibrary.core.database;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jose.newlibrary.library.model.entity.Author;
import com.jose.newlibrary.library.model.entity.Nationality;
import com.jose.newlibrary.library.repository.AuthorRepository;
import com.jose.newlibrary.library.repository.NationalityRepository;

/**
 * DatabaseSeeder
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final NationalityRepository nationalityRepository;
    private final AuthorRepository authorRepository;

    public DatabaseSeeder(NationalityRepository nationalityRepository, AuthorRepository authorRepository){
        this.nationalityRepository = nationalityRepository;
        this.authorRepository = authorRepository;
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
        }
	}

    
}
