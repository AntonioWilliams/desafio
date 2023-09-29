package com.noxtec.repository;

import com.noxtec.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ContatoRepositoryQueryImpl implements ContatoRepositoryQuery{
    @Autowired
    private EntityManager manager;

    @Override
    public List<Contato> buscarCelularExistente(String celular) {

        Query query = manager.createNativeQuery(
                "select * from desafio.contato where contato_celular = :celular");
        query.setParameter("celular", celular);


        @SuppressWarnings("unchecked")
        List<Contato> list = query.getResultList();

        //list.forEach(a-> System.out.println(a));
        System.out.println("Implem -->" + list) ;

        return list == null ? new ArrayList<>() : list;
    }
}
