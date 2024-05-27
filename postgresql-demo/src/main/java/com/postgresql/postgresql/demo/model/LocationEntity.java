package com.postgresql.postgresql.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.locationtech.jts.geom.Geometry;

@Data
@Entity(name = "location")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "user_id", length = 30)
    private String user;

    @Column(name = "name")
    private String name;

    @Column(name = "geometry")
    private Geometry geometry;

    private String geometryText;

}