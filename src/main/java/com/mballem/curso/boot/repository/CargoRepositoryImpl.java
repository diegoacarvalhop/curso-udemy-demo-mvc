package com.mballem.curso.boot.repository;

import com.mballem.curso.boot.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoRepositoryImpl extends AbstractRepository<Cargo, Long> implements CargoRepository {

}
