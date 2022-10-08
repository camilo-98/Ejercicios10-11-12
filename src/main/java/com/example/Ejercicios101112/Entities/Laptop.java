package com.example.Ejercicios101112.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Ordenador")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLap;
    private String marcaLap;
    private Integer yearLap;

    public Laptop() {
    }

    public Laptop(Long idLap, String marcaLap, Integer yearLap) {
        this.idLap = idLap;
        this.marcaLap = marcaLap;
        this.yearLap = yearLap;
    }

    public Long getIdLap() {
        return idLap;
    }

    public void setIdLap(Long idLap) {
        this.idLap = idLap;
    }

    public String getMarcaLap() {
        return marcaLap;
    }

    public void setMarcaLap(String marcaLap) {
        this.marcaLap = marcaLap;
    }

    public Integer getYearLap() {
        return yearLap;
    }

    public void setYearLap(Integer yearLap) {
        this.yearLap = yearLap;
    }
}
