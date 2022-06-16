package br.com.projetodojorge.projetodojorge.controller;

import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import br.com.projetodojorge.projetodojorge.service.PacienteService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        PacienteModel pacienteModel = service.findById(id);
        buildEntityLink(pacienteModel);
        return pacienteModel;
    }

    @ApiOperation(value = "Listar todos os pacientes.")
    @GetMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<PagedModel<PacienteModel>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            PagedResourcesAssembler<PacienteModel> assembler) throws Exception {
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "idPaciente"));
        Page<PacienteModel> pacienteModels = service.findAll(pageable);
        for (PacienteModel pacienteModel : pacienteModels) {
            buildEntityLink(pacienteModel);
        }
        return new ResponseEntity(assembler.toModel(pacienteModels), HttpStatus.OK);
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

    public void buildEntityLink(PacienteModel pacienteModel) throws Exception {
        pacienteModel.add(
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder
                                .methodOn(PacienteController.class)
                                .findById(pacienteModel.getIdPaciente())
                        ).withSelfRel()
        );
        if (!pacienteModel.getMedicoModel().hasLinks()) {
            Link medicoLink = WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(
                            MedicoController.class).findById(pacienteModel.getMedicoModel().getIdMedico())
            ).withSelfRel();
            pacienteModel.getMedicoModel().add(medicoLink);
        }
    }

}
