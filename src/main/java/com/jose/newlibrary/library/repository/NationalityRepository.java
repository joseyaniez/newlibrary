
package com.jose.newlibrary.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.jose.newlibrary.library.model.entity.Nationality;

/**
 * NationalityRepository
 */
public interface NationalityRepository extends CrudRepository<Nationality, Long> {
    boolean existsByNameIgnoreCase(String name);
}
