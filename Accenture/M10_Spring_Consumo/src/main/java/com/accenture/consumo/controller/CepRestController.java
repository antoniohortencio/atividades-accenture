package com.accenture.consumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.model.Endereco;
import com.accenture.consumo.repository.EnderecoRepository;

@RestController
public class CepRestController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoRepository repository;

    // Ajustado: Adicionado ("cep") para evitar erro de reflexão no compilador
    @GetMapping("/{cep}")
    public Endereco getCep(@PathVariable("cep") String cep) {
        Endereco endereco = cepService.buscaEnderecoPor(cep);
        
        // Salva no banco H2 apenas se o retorno não for nulo
        if (endereco != null && endereco.getCep() != null) {
            repository.save(endereco);
        }
        
        return endereco;
    }
}