package br.com.projetodojorge.projetodojorge.service;

import br.com.projetodojorge.projetodojorge.model.MedicoModel;
import br.com.projetodojorge.projetodojorge.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired

    private MedicoRepository repository;

    public MedicoModel findById(long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Médico não encontrado."));
    }

    public List<MedicoModel> findAll(){
        return repository.findAll();
    }

    public MedicoModel save(MedicoModel medicoModel){
        return repository.save(medicoModel);
    }

    public MedicoModel update(MedicoModel medicoModel) throws Exception {
        MedicoModel m = findById(medicoModel.getIdMedico());
        m.setNomeMedico(medicoModel.getNomeMedico());
        m.setCrmMedico(medicoModel.getCrmMedico());
        m.setEspecialidadeMedico(medicoModel.getEspecialidadeMedico());
        m.setTelefoneMedico(medicoModel.getTelefoneMedico());
        return repository.save(m);
    }

    public void delete(long id) throws Exception {
        MedicoModel m = findById(id);
        repository.delete(m);
    }

}
