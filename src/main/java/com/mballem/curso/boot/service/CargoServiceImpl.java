package com.mballem.curso.boot.service;

import com.mballem.curso.boot.domain.Cargo;
import com.mballem.curso.boot.repository.CargoRepository;
import com.mballem.curso.boot.util.PaginacaoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository repository;

    @Override
    public void salvar(Cargo cargo) {
        repository.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
        repository.update(cargo);
    }

    @Override
    public void excluir(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public boolean cargoTemFuncionarios(Long id) {
        if(buscarPorId(id).getFuncionarios().isEmpty()) {
            return false;
        }
        return true;
    }

	@Override
	public PaginacaoUtil<Cargo> buscarPorPagina(int pagina, String direcao) {
		return repository.buscaPaginada(pagina, direcao);
	}

}
