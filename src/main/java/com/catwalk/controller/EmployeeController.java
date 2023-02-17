package com.catwalk.controller;

import com.catwalk.service.EmployeeService;
import com.catwalk.dto.EmployeeDto;
import com.catwalk.mapping.EmployeeMapper;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/rest")
public class EmployeeController {

  private final  EmployeeService service;

  public  EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @PostMapping(value="/employee",produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<EmployeeDto> save(@RequestBody EmployeeDto dto){
    return this.service.save(EmployeeMapper.MAPPER.employeeDtoToEmployee(dto)).map(EmployeeMapper.MAPPER::employeeToEmployeeDto);
  }

  @GetMapping(value = "/employee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<EmployeeDto> findById(@PathVariable("id") String id ){
    return this.service.findById(String.valueOf(id)).map(EmployeeMapper.MAPPER::employeeToEmployeeDto);
  }

  @GetMapping(value = "/employee",produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<EmployeeDto> findAll(){
    return this.service.findAll().map(EmployeeMapper.MAPPER::employeeToEmployeeDto);
  }

  @DeleteMapping(value = "/employee/{id}")
  public Mono<Void> deleteById(@PathVariable("id") String id ){
    return this.service.deleteById(String.valueOf(id));
  }

  @ResponseBody
  @GetMapping(value = {"/employee/search"}, produces = { "application/json" })
  public Flux<EmployeeDto> search(@RequestParam(value = "term",  defaultValue = "") String searchTerm,
                             @RequestParam(value = "page",  defaultValue = "0") Integer page,
                             @RequestParam(value = "limit", defaultValue = "50") Integer limit){
          return this.service.search(searchTerm,PageRequest.of(page,limit)).map(EmployeeMapper.MAPPER::employeeToEmployeeDto);
  }

}
