package br.com.projetodojorge.projetodojorge.service;

import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import br.com.projetodojorge.projetodojorge.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public PacienteModel findById(long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Paciente não encontrado."));
    }

    public Page<PacienteModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public PacienteModel save(PacienteModel pacienteModel) {
        return repository.save(pacienteModel);
    }

    public PacienteModel update(PacienteModel pacienteModel) throws Exception {
        PacienteModel p = findById(pacienteModel.getIdPaciente());
        p.setNomePaciente(pacienteModel.getNomePaciente());
        p.setNascimentoPaciente(pacienteModel.getNascimentoPaciente());
        p.setTelefonePaciente(pacienteModel.getTelefonePaciente());
        return repository.save(p);
    }

    public void delete(long id) throws Exception {
        PacienteModel p = findById(id);
        repository.delete(p);
    }

}
