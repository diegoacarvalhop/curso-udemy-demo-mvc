package com.mballem.curso.boot.service;

import com.mballem.curso.boot.domain.Funcionario;
import com.mballem.curso.boot.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void salvar(Funcionario funcionario) {
        repository.save(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        repository.update(funcionario);
    }

    @Override
    public void excluir(Long id) {
        repository.delete(id);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public List<Funcionario> buscarPorCargo(Long id) {
        return repository.findByCargoId(id);
    }

    @Override
    public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
        if (entrada != null && saida != null) {
            return repository.findByDataEntradaDataSaida(entrada, saida);
        } else if (entrada != null) {
            return repository.findByDataEntrada(entrada);
        } else if (saida != null) {
            return repository.findByDataSaida(saida);
        } else {
            return new ArrayList<>();
        }
    }

}
