package com.mballem.curso.boot.repository;

import com.mballem.curso.boot.domain.Departamento;

import java.util.List;

public interface DepartamentoRepository {

    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();

}
