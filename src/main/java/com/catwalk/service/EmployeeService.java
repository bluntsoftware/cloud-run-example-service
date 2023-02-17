package com.catwalk.service;

import com.catwalk.model.Employee;
import com.catwalk.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;

@Slf4j
@Service
public class EmployeeService{

  private final EmployeeRepo repo;

  public EmployeeService(EmployeeRepo repo) {
    this.repo = repo;
  }

  public Mono<Employee> save(Employee item) {
    return repo.save(item);
  }

  public Mono<Void> deleteById(String id) {
    return repo.deleteById(id);
  }

  public Mono<Employee> findById(String id) {
    return repo.findById(id);
  }

  public Flux<Employee> findAll() {
    return repo.findAll();
  }

  public Flux<Employee> search(String term,Pageable pageable) {
    log.info("create a filter in repo for search term {}",term);
    return repo.findAllBy(pageable);
  }

}
