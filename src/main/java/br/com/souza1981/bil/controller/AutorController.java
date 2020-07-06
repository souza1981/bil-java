package br.com.souza1981.bil.controller;

import br.com.souza1981.bil.controller.dto.AutorDTO;
import br.com.souza1981.bil.modelo.Autor;
import br.com.souza1981.bil.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @GetMapping
    public Page<AutorDTO> lista(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao) {
        Page<Autor> autores = autorRepository.findAll(paginacao);
        return AutorDTO.converter(autores);
    }


}
