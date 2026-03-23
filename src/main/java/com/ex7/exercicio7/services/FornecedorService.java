package com.ex7.exercicio7.services;

import com.ex7.exercicio7.models.FornecedorModel;
import com.ex7.exercicio7.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;



    public FornecedorModel criarFornecedor(FornecedorModel fornecedorModel){
        return fornecedorRepository.save(fornecedorModel);
    }

    public List<FornecedorModel> findAll(){
        return fornecedorRepository.findAll();
    }

    public Optional<FornecedorModel> findById(Long id){
        return fornecedorRepository.findById(id);
    }

    public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
    }

}
