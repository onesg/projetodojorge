package br.com.projetodojorge.projetodojorge.repository;

import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
    public Page<PacienteModel> findAll(Pageable pageable);
}
