package com.noxtec.resources;

import com.noxtec.dto.ContatoDto;
import com.noxtec.model.Contato;
import com.noxtec.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

    @Autowired
    private ContatoService service;

    @GetMapping
    public List<ContatoDto> findAll(@RequestParam(required = false) String nome) {
        //return service.buscarTodos();

        List<Contato> listContatos = service.findAll(nome);
        List<ContatoDto> listDto = listContatos.stream().map(obj -> new ContatoDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto).getBody();
    }

    @GetMapping(value = "/{id}")
    public ContatoDto findById(@PathVariable Long id) {

       Contato contato =  this.service.findById(id);
       ContatoDto contatoDto = new ContatoDto(contato);

        return ResponseEntity.ok().body(contatoDto).getBody();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato insert(@RequestBody Contato contato) {

        return this.service.save(contato);
    }

    @PutMapping(value = "/{id}")
    public Contato update(@PathVariable Long id,
                                             @RequestBody Contato contato) {

        return this.service.update(id, contato);
    }

    @PutMapping(value = "/ativar/{id}")
    public String ativar(@PathVariable Long id){
        return this.service.activate(id);
    }

    @PutMapping(value = "/inativar/{id}")
    public String inativar(@PathVariable Long id){
        return this.service.inactivate(id);
    }

    @PutMapping(value = "/favoritar/{id}")
    public String favoritar(@PathVariable Long id){
        return this.service.favorite(id);
    }
    @DeleteMapping(value = "/{id}")
    public void deletar(@PathVariable Long id){
            this.service.delete(id);
    }
    }
