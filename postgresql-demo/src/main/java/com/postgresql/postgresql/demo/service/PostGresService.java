package com.postgresql.postgresql.demo.service;

import com.postgresql.postgresql.demo.model.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.wololo.geojson.GeoJSON;
import org.wololo.jts2geojson.GeoJSONWriter;

@Service
@RequiredArgsConstructor
public class PostGresService {

  private final JdbcTemplate jdbcTemplate;

  public String get() {

    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS testing_impk (id SERIAL PRIMARY KEY, name VARCHAR(255))");
    jdbcTemplate.execute("select * from t_663b63c737ca951c4d9787c7_t");
    return "Table created successfully";

  }



  public String insert(LocationEntity locationEntity) {
//    String sql = "INSERT INTO locations (user_id, name, geometry) VALUES (?, ?, ST_GeomFromText(?))";
    String sql = "INSERT INTO locations (user_id, name, geometry) VALUES (?, ?, ST_GeomFromText(?))";
    jdbcTemplate.update(sql, locationEntity.getUser(), locationEntity.getName(), locationEntity.getGeometryText());
    return "Data inserted successfully";
  }



  public String insertGeoJson(LocationEntity locationEntity) {
    GeoJSONWriter writer = new GeoJSONWriter();
    GeoJSON geoJSON = writer.write(locationEntity.getGeometry());
    String geoJSONString = geoJSON.toString();
    String sql = "INSERT INTO locations (user_id, name, geometry) VALUES (?, ?, ST_GeomFromGeoJSON(?))";
    jdbcTemplate.update(sql, locationEntity.getUser(), locationEntity.getName(), geoJSONString);
    return "Data inserted successfully";
  }
}

