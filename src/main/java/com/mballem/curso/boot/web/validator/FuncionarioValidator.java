package com.mballem.curso.boot.web.validator;

import com.mballem.curso.boot.domain.Funcionario;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class FuncionarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Funcionario.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Funcionario funcionario = (Funcionario) object;
        LocalDate entrada = funcionario.getDataEntrada();
        if(funcionario.getDataSaida() != null) {
            if(funcionario.getDataSaida().isBefore(entrada)) {
                errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
            }
        }
    }
}
