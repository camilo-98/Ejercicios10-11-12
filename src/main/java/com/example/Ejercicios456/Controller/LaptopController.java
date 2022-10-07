package com.example.Ejercicios456.Controller;

import com.example.Ejercicios456.Entities.Laptop;
import com.example.Ejercicios456.Repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {

        this.laptopRepository = laptopRepository;
    }

    @Value("${app.message}")
    String ambiente;

    @GetMapping("/api/laptops")
    @ApiOperation("Buscar todas las Laptops")
    public List<Laptop> findAll(){
        System.out.println(ambiente);
        return laptopRepository.findAll();
    }
    @GetMapping("/api/laptops/{idLap}")
    @ApiOperation("Buscar una Laptop segun su id")
    public ResponseEntity<Laptop> findOneById(@ApiParam("Identificador de la laptop") @PathVariable Long idLap){
        Optional<Laptop> laptopOpt = laptopRepository.findById(idLap);

        if(laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/laptops")
    @ApiOperation("Creación de una Laptop")
    public Laptop create(@ApiParam("Constructor de la Laptop") @RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }

    @PutMapping("/api/laptops")
    @ApiOperation("Actualización de una Laptop")
    public Laptop update(@RequestBody Laptop laptop){
        Laptop res = laptopRepository.save(laptop);
        return res;
    }
    @DeleteMapping("/api/laptops/{idLap}")
    @ApiOperation("Eliminación de una laptop apartir de su id")
    public ResponseEntity<Laptop> deleteById(@ApiParam("Identificador de la laptop") @PathVariable Long idLap){

        if(!laptopRepository.existsById(idLap)){
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(idLap);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/api/laptops")
    @ApiOperation("Eliminación de todas las Laptops existentes")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
