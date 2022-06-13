package br.com.projetodojorge.projetodojorge.controller;

import br.com.projetodojorge.projetodojorge.model.MedicoModel;
import br.com.projetodojorge.projetodojorge.service.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public MedicoModel findById(@PathVariable("id") long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<MedicoModel> findAll() {
        return service.findAll();
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public MedicoModel save(@RequestBody MedicoModel medicoModel) {
        return service.save(medicoModel);
    }

    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public MedicoModel update(@RequestBody MedicoModel medicoModel) throws Exception {
        return service.update(medicoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
