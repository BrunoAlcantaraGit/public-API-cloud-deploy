package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteInterface;
import com.example.demo.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController implements ClienteInterface {
    @Autowired
    ClienteService clienteService;
    @Autowired
    ClienteRepository clienteRepository;


    @Override
    @PostMapping("/salve")
    public ResponseEntity <Cliente> salve(@RequestBody Cliente cliente) throws Exception {
        try {
            clienteService.salve(cliente);
            if(clienteRepository.existsBydocumento(cliente.getDocumento())){
                ResponseEntity.badRequest();
            }else {clienteService.salve(cliente);
            }

        }catch (Exception e){
            e.printStackTrace();
         return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) throws Exception {

        try {
            Optional <Cliente> cliente = clienteService.findById(id);
            if(cliente.isPresent()){
             return ResponseEntity.ok(cliente);
            } else {return ResponseEntity.notFound().build();}

        }catch (Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @Override
    @PutMapping("atualizar/{id}")
    public  Optional<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id) throws Exception{
        Optional<Cliente> clienteId  = clienteRepository.findById(id);
        try {
            if(clienteId.isPresent()){

                 new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
            }else {
                 ResponseEntity.notFound();
            }
        }catch (Exception e){
            e.printStackTrace();
           new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
        }
        return null;
    }

    @Override
    public void deleteById() {

    }
}
