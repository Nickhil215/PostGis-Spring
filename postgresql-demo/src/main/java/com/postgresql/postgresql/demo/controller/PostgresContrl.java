package com.postgresql.postgresql.demo.controller;

import com.postgresql.postgresql.demo.model.LocationEntity;
import com.postgresql.postgresql.demo.service.PostGresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostgresContrl {
  private final PostGresService postGresService;


  @GetMapping("/get")
  public String get() {
    return postGresService.get();
  }


  @PostMapping("/insert")
  public String insert(@RequestBody LocationEntity locationEntity){
    return postGresService.insert(locationEntity);
  }

  @PostMapping("/insertGeoJson")
  public String insertGeoJson(@RequestBody LocationEntity locationEntity){
    return postGresService.insertGeoJson(locationEntity);
  }



}
