package br.com.souza1981.bil.controller;

import br.com.souza1981.bil.controller.dto.EditoraDTO;
import br.com.souza1981.bil.modelo.Editora;
import br.com.souza1981.bil.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/editora")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    public List<EditoraDTO> lista() {
        List<Editora> editoras = editoraRepository.findAll();
        return EditoraDTO.converter(editoras);
    }
}
