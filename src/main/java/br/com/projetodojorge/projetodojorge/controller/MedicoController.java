package br.com.projetodojorge.projetodojorge.controller;

import br.com.projetodojorge.projetodojorge.model.MedicoModel;
import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import br.com.projetodojorge.projetodojorge.repository.MedicoRepository;
import br.com.projetodojorge.projetodojorge.repository.PacienteRepository;
import br.com.projetodojorge.projetodojorge.service.MedicoService;
import br.com.projetodojorge.projetodojorge.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/medico")

public class MedicoController {

    @Autowired
    private MedicoService service;

//    @Autowired
//    private MedicoRepository mr;

//    @Autowired
//    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public MedicoModel findById(@PathVariable("id") long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping
    public List<MedicoModel> findAll(){
        return service.findAll();
    }

    @PostMapping
    public MedicoModel save(@RequestBody MedicoModel medicoModel){
        return service.save(medicoModel);
    }

    @PutMapping
    public MedicoModel update(@RequestBody MedicoModel medicoModel) throws Exception {
        return service.update(medicoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

//    @RequestMapping("/{id}")
//    @PostMapping
//    public PacienteModel metodo(@PathVariable("id") long id, PacienteModel pacienteModel) throws Exception {
//        MedicoModel medicoModel = service.findById(id);
//        pacienteModel.setMedicoModel(medicoModel);
//        return pacienteService.save(pacienteModel);
//    }

}
