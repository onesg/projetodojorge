package br.com.projetodojorge.projetodojorge.controller;

import br.com.projetodojorge.projetodojorge.model.MedicoModel;
import br.com.projetodojorge.projetodojorge.service.MedicoService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @ApiOperation(value = "Pesquisar médico pelo ID.")
    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public MedicoModel findById(@PathVariable("id") long id) throws Exception {
        MedicoModel medicoModel = service.findById(id);
        buildEntityLink(medicoModel);
        return medicoModel;
    }

    @ApiOperation(value = "Listar todos os médicos.")
    @GetMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public CollectionModel<MedicoModel> findAll() throws Exception {
        CollectionModel<MedicoModel> medicoModels = CollectionModel.of(service.findAll());
        for (final MedicoModel medicoModel : medicoModels) {
            buildEntityLink(medicoModel);
        }
        buildCollectionLink(medicoModels);
        return medicoModels;
    }

    @ApiOperation(value = "Cadastrar novo médico.")
    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public MedicoModel save(@RequestBody MedicoModel medicoModel) {
        return service.save(medicoModel);
    }

    @ApiOperation(value = "Atualizar um médico.")
    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public MedicoModel update(@RequestBody MedicoModel medicoModel) throws Exception {
        return service.update(medicoModel);
    }

    @ApiOperation(value = "Deletar um médico pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    private void buildEntityLink(MedicoModel medicoModel) throws Exception {
        medicoModel.add(
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder
                                .methodOn(MedicoController.class)
                                .findById(medicoModel.getIdMedico())
                        ).withSelfRel()
        );
    }

    private void buildCollectionLink(CollectionModel<MedicoModel> medicoModels) throws Exception {
        medicoModels.add(
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder
                                .methodOn(MedicoController.class)
                                .findAll()
                        ).withRel(IanaLinkRelations.COLLECTION)
        );
    }

}
