package com.mballem.curso.boot.repository;

import com.mballem.curso.boot.domain.Cargo;

import java.util.List;

public interface CargoRepository {

    void save(Cargo cargo );

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();

}
