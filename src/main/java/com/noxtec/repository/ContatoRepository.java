package com.noxtec.repository;

import com.noxtec.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQueries;
import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    List<Contato> findByCelular(String celular);
    List<Contato> findByFavorito(Character favorito);

}
