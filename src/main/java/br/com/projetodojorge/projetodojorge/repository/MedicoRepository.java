package br.com.projetodojorge.projetodojorge.repository;

import br.com.projetodojorge.projetodojorge.model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {}
