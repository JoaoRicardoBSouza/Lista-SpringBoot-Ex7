package com.ex7.exercicio7.controllers;

import com.ex7.exercicio7.models.FornecedorModel;
import com.ex7.exercicio7.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> fornecedorModelList = fornecedorService.findAll();

        return ResponseEntity.ok().body(fornecedorModelList);
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedorModel){
        FornecedorModel novoFornecedor = fornecedorService.criarFornecedor(fornecedorModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoFornecedor.getId()).toUri();

        return ResponseEntity.created(uri).body(novoFornecedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FornecedorModel>> findById(@PathVariable Long id){
        Optional<FornecedorModel> fornecedorModelOptional = fornecedorService.findById(id);

        return ResponseEntity.ok().body(fornecedorModelOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        fornecedorService.deletarFornecedor(id);

        return ResponseEntity.noContent().build();
    }

}
