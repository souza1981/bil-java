package br.com.souza1981.bil.controller;

import br.com.souza1981.bil.controller.dto.LivroDTO;
import br.com.souza1981.bil.controller.form.AtualizacaoLivroForm;
import br.com.souza1981.bil.controller.form.LivroForm;
import br.com.souza1981.bil.modelo.Livro;
import br.com.souza1981.bil.repository.AutorRepository;
import br.com.souza1981.bil.repository.CategoriaRepository;
import br.com.souza1981.bil.repository.EditoraRepository;
import br.com.souza1981.bil.repository.LivroRepository;
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
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    EditoraRepository editoraRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    @Cacheable(value = "listaDeLivros")
    public Page<LivroDTO> lista(@PageableDefault(sort = "titulo", direction = Sort.Direction.ASC) Pageable paginacao) {

        //Pageable paginacao = PageRequest.of (pagina, qtd, Sort.Direction.ASC, ordenacao);

        Page<Livro> livros = livroRepository.findAll(paginacao);

        return LivroDTO.converter(livros);


    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeLivros", allEntries = true)
    public ResponseEntity<LivroDTO> cadastrar(@RequestBody @Valid LivroForm livroForm, UriComponentsBuilder uriComponentsBuilder) {
        Livro livro = livroForm.converter(editoraRepository, autorRepository, categoriaRepository);
        livroRepository.save(livro);
        URI uri = uriComponentsBuilder.path("/livro/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDTO(livro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> detalhar(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.map(value -> ResponseEntity.ok(new LivroDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeLivros", allEntries = true)
    public ResponseEntity<LivroDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoLivroForm livroForm) {

        Optional<Livro> optional = livroRepository.findById(id);
        if (optional.isPresent()) {
            Livro livro = livroForm.atualizar(id, livroRepository, editoraRepository);

            return ResponseEntity.ok(new LivroDTO(livro));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeLivros", allEntries = true)
    public ResponseEntity<LivroDTO> remover(@PathVariable Long id) {

        Optional<Livro> optional = livroRepository.findById(id);
        if (optional.isPresent()) {
            livroRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();


    }
}
