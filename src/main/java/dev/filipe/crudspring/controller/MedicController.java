package dev.filipe.crudspring.controller;


import dev.filipe.crudspring.dto.MedicDTO;
import dev.filipe.crudspring.dto.MedicResponseDTO;
import dev.filipe.crudspring.dto.UpdateMedicDTO;
import dev.filipe.crudspring.entity.MedicEntity;
import dev.filipe.crudspring.repository.MedicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/medic")
public class MedicController {

    @Autowired
    private MedicRepository repository;

    @GetMapping()
    public Page<MedicResponseDTO> getMedic(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(MedicResponseDTO::new);
    }

    @PostMapping()
    @Transactional
    public void createMedic(@RequestBody @Valid MedicDTO data){
        repository.save(new MedicEntity(data));
    }

    @PutMapping
    @Transactional
    public void updateMedic(@RequestBody @Valid UpdateMedicDTO dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedic(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.delete();
    }
}
