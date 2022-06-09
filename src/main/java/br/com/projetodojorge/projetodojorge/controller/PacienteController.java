package br.com.projetodojorge.projetodojorge.controller;

import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import br.com.projetodojorge.projetodojorge.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/paciente")

public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping("/{id}")
    public PacienteModel findById(@PathVariable("id") long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping
    public List<PacienteModel> findAll(){
        return service.findAll();
    }

    @PostMapping
    public PacienteModel save(@RequestBody PacienteModel pacienteModel){
        return service.save(pacienteModel);
    }

    @PutMapping
    public PacienteModel update(@RequestBody PacienteModel pacienteModel) throws Exception {
        return service.update(pacienteModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
