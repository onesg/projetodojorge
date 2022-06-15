package br.com.projetodojorge.projetodojorge.controller;

import br.com.projetodojorge.projetodojorge.model.PacienteModel;
import br.com.projetodojorge.projetodojorge.service.PacienteService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public CollectionModel<PacienteModel> findAll() throws Exception {
        CollectionModel<PacienteModel> pacienteModels = CollectionModel.of(service.findAll());
        for (final PacienteModel pacienteModel : pacienteModels) {
            buildEntityLink(pacienteModel);
        }
        buildCollectionLink(pacienteModels);
        return pacienteModels;
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

    private void buildCollectionLink(CollectionModel<PacienteModel> pacienteModels) throws Exception {
        pacienteModels.add(
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder
                                .methodOn(PacienteController.class)
                                .findAll()
                        ).withRel(IanaLinkRelations.COLLECTION)
        );
    }

}
