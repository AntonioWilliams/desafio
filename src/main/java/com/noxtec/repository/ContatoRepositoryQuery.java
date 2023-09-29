package com.noxtec.repository;

import com.noxtec.model.Contato;

import java.util.List;

public interface ContatoRepositoryQuery{
    List<Contato> buscarCelularExistente(String celular);
}
