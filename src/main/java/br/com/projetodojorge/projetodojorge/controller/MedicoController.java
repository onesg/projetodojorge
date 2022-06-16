package br.com.projetodojorge.projetodojorge.controller;

import br.com.projetodojorge.projetodojorge.model.MedicoModel;
import br.com.projetodojorge.projetodojorge.service.MedicoService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PagedModel<MedicoModel>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            PagedResourcesAssembler<MedicoModel> assembler) throws Exception {
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "idMedico"));
        Page<MedicoModel> medicoModels = service.findAll(pageable);
        for (MedicoModel medicoModel : medicoModels) {
            buildEntityLink(medicoModel);
        }
        return new ResponseEntity(assembler.toModel(medicoModels), HttpStatus.OK);
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
//        medicoModel.add(
//                WebMvcLinkBuilder
//                        .linkTo(WebMvcLinkBuilder
//                                .methodOn(MedicoController.class)
//                                .delete(medicoModel.getIdMedico())
//                        ).withRel("delete")
//        );
    }

}
