package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Data
@Getter
@Setter
public class ClienteService implements ClienteInterface{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente salve(Cliente cliente) throws RuntimeException {
    if(clienteRepository.existsBydocumento(cliente.getDocumento())) {
        throw new RuntimeException("Cliente já cadastrado");
    }else {

        return clienteRepository.save(cliente);
    }
    }

    @Override
    public Optional<Cliente> findById(Long id) throws RuntimeException {
        if(clienteRepository.existsByid(id)){
        return clienteRepository.findById(id);
        }
        else {
            throw new RuntimeException("Id não existe ");
        }
    }

    @Override
    public Optional<Cliente> atualizar(Cliente cliente, Long id) throws RuntimeException {
      Optional<Cliente> clienteId = clienteRepository.findById(id);
        if (clienteId.isPresent()){
            return Optional.of(clienteRepository.save(cliente));
        }else {
            throw  new RuntimeException("Cliente inexiste");
        }

    }

    @Override
    public void deleteById() {

    }
}
