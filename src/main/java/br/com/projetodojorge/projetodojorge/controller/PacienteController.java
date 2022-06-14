package br.com.projetodojorge.projetodojorge.controller;

import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import br.com.projetodojorge.projetodojorge.service.PacienteService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @ApiOperation(value = "Pesquisar paciente pelo ID.")
    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public PacienteModel findById(@PathVariable("id") long id) throws Exception {
        return service.findById(id);
    }

    @ApiOperation(value = "Listar todos os pacientes.")
    @GetMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PacienteModel> findAll() {
        return service.findAll();
    }

    @ApiOperation(value = "Cadastrar novo paciente.")
    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PacienteModel save(@RequestBody PacienteModel pacienteModel) {
        return service.save(pacienteModel);
    }

    @ApiOperation(value = "Atualizar um paciente.")
    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PacienteModel update(@RequestBody PacienteModel pacienteModel) throws Exception {
        return service.update(pacienteModel);
    }

    @ApiOperation(value = "Deletar um paciente pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
