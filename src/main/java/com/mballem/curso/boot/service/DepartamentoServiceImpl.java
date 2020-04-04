package com.mballem.curso.boot.service;

import com.mballem.curso.boot.domain.Departamento;
import com.mballem.curso.boot.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;

    @Override
    public void salvar(Departamento departamento) {
        repository.save(departamento);
    }

    @Override
    public void editar(Departamento departamento) {
        repository.update(departamento);
    }

    @Override
    public void excluir(Long id) {
        repository.delete(id);
    }

    @Override
    public Departamento buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Departamento> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public boolean departamentoTemCargos(Long id) {
        if(buscarPorId(id).getCargos().isEmpty()) {
            return false;
        }
        return true;
    }

}
