package br.com.projetodojorge.projetodojorge.repository;

import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {}
