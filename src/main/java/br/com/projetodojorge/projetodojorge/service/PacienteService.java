package br.com.projetodojorge.projetodojorge.service;

import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import br.com.projetodojorge.projetodojorge.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired

    private PacienteRepository repository;

    public PacienteModel findById(long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Paciente não encontrado."));
    }

    public List<PacienteModel> findAll(){
        return repository.findAll();
    }

    public PacienteModel save(PacienteModel pacienteModel){
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
