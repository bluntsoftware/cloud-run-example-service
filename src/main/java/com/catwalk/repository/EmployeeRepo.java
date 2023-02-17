package com.catwalk.repository;

import reactor.core.publisher.Flux;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.catwalk.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends ReactiveMongoRepository<Employee, String> {

	Flux<Employee> findAllBy(Pageable pageable);
}