package com.ex7.exercicio7.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_fornecedor")
public class FornecedorModel {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nomeDaEmpresa")
    private String nomeFantasia;
    @Column(name = "cnpjFornecedor")
    private String cnpj;
    private String contato;



}
