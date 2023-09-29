package com.noxtec.service;

import com.noxtec.error.exception.NegocioException;
import com.noxtec.model.Contato;
import com.noxtec.repository.ContatoRepository;
import com.noxtec.repository.ContatoRepositoryQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<Contato> findAll(String nome) {
        List<Contato> contatosResponse = this.repository.findAll();

        if (nome != null && !nome.isEmpty()) {
            List<Contato> contatoFiltrados = contatosResponse.stream()
                    .filter(contato -> contato.getNome().contains(nome))
                    .collect(Collectors.toList());
            return contatoFiltrados;
        }

        return contatosResponse;
    }


    @Transactional
    public Contato save(Contato contato) {

        validateContactECellular(contato);

        return this.repository.save(contato);

    }

    public Contato findById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new NegocioException("Contato não encontrado ou não existe!"));
        
    }

    @Transactional
    public Contato update(Long id, Contato contato){

        Optional<Contato> contatEditado = this.repository.findById(id);


        if (!contatEditado.isPresent()){
            throw new NegocioException(String.format("Objeto de Id %d não existe.", id));
        }

        if (contato.getCelular().equals(contatEditado.get().getCelular())){
            BeanUtils.copyProperties(contato, contatEditado.get(), "id");

            return this.repository.save(contatEditado.get());
        } else {

            validateContactECellular(contato);

            BeanUtils.copyProperties(contato, contatEditado.get(), "id");

            return this.repository.save(contatEditado.get());

        }

    }

    public String inactivate(Long id){
        findById(id);

        Optional<Contato> contatEditado = this.repository.findById(id);
        contatEditado.get().setAtivo('0');

        this.repository.save(contatEditado.get());
        return "Contato Inativado";

    }

    public String activate(Long id){
        findById(id);

        Optional<Contato> contatEditado = this.repository.findById(id);
        contatEditado.get().setAtivo('1');

        this.repository.save(contatEditado.get());
        return "Contato Ativado";

    }
    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            this.repository.deleteById(id);
            this.repository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new NegocioException("Id não exite");
        }
    }

    private void validateContactECellular(Contato contato) {

        if (contato.getFavorito().equals('1') ){
            List<Contato> contatosFav = this.repository.findByFavorito(contato.getFavorito());
            if (!contatosFav.isEmpty()){
                throw new NegocioException("Já existe um contato favoritado.");
            }
        }

        if (contato == null) {
            throw new NegocioException("Contato não pode ser nulo");
        }

        if (contato.getCelular() != null){

            List<Contato> contatos =  this.repository.findByCelular(contato.getCelular());

            if(!contatos.isEmpty()){
                throw new NegocioException("Já existe um contato com um celular informado.");
            }
        }
    }
    public String favorite(Long id){
        findById(id);
        List<Contato> contatos =  this.repository.findAll();
        List<Contato> contatosFavoritos = contatos.stream().filter(contato -> contato.getFavorito() == '1').collect(Collectors.toList());

        if(contatosFavoritos.isEmpty()){
            Optional<Contato> contatEditado = this.repository.findById(id);
            contatEditado.get().setFavorito('1');

            this.repository.save(contatEditado.get());

            return "Contato Favoritado";

        }else{

            throw new NegocioException("Já existe vai.");

        }

    }
    
}
