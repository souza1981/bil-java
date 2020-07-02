package br.com.souza1981.bil.controller;

import br.com.souza1981.bil.controller.dto.EditoraDTO;
import br.com.souza1981.bil.controller.form.AtualizacaoEditoraForm;
import br.com.souza1981.bil.controller.form.EditoraForm;
import br.com.souza1981.bil.modelo.Editora;
import br.com.souza1981.bil.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/editora")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    @Cacheable(value = "listaDeEditoras")
    public Page<EditoraDTO> lista(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Editora> editoras = editoraRepository.findAll(paginacao);
        return EditoraDTO.converter(editoras);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeEditoras", allEntries = true)
    public ResponseEntity<EditoraDTO> cadastrar(@RequestBody @Valid EditoraForm editoraForm, UriComponentsBuilder uriComponentsBuilder) {
        Editora editora = editoraForm.converter();
        editoraRepository.save(editora);
        URI uri = uriComponentsBuilder.path("/editora/{id}").buildAndExpand(editora.getId()).toUri();
        return ResponseEntity.created(uri).body(new EditoraDTO(editora));
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeEditoras", allEntries = true)
    public ResponseEntity<EditoraDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEditoraForm editoraForm) {
        Optional<Editora> optional = editoraRepository.findById(id);
        if (optional.isPresent()) {
            Editora editora = editoraForm.atualizar(id, editoraRepository);
            return ResponseEntity.ok(new EditoraDTO(editora));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeEditoras", allEntries = true)
    public ResponseEntity<EditoraDTO> remover(@PathVariable Long id) {
        Optional<Editora> optional = editoraRepository.findById(id);
        if (optional.isPresent()) {
            editoraRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
