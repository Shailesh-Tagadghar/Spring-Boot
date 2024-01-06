package com.example.demo.many_to_many;

import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource(excerptProjection = BookProjection.class)
public interface BookRepository extends CrudRepository<Book, Integer> {
  
}
