package com.mballem.curso.boot.repository;

import com.mballem.curso.boot.domain.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoRepositoryImpl extends AbstractRepository<Departamento, Long> implements DepartamentoRepository {

}
