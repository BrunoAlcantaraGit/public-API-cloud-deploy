package com.example.demo.service;

import com.example.demo.model.Cliente;

import java.util.Optional;

public interface ClienteInterface {

     Object salve(Cliente cliente) throws Exception;
     Object findById(Long id) throws Exception;
     Optional<Cliente> atualizar(Cliente cliente, Long id) throws Exception;
     void deleteById();


}
