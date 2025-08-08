package com.alura.literalura.service;

import com.alura.literalura.api.GutendexClient;
import com.alura.literalura.dto.BookDTO;
import com.alura.literalura.dto.GutendexResponse;
import com.alura.literalura.exception.LivroNaoEncontradoException;
import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final GutendexClient gutendexClient;

    // Injeção de dependências do Repositório e do Cliente da API
    public LivroService(LivroRepository livroRepository, GutendexClient gutendexClient) {
        this.livroRepository = livroRepository;
        this.gutendexClient = gutendexClient;
    }

    /**
     * Busca um livro pelo título, primeiro no banco de dados local e, se não encontrar,
     * busca na API Gutendex e o salva localmente.
     *
     * @param titulo O título do livro a ser buscado.
     * @return O livro encontrado (do banco ou da API).
     * @throws LivroNaoEncontradoException se o livro não for encontrado em nenhuma das fontes.
     */
    public Livro buscarEsalvarLivroPorTitulo(String titulo) {
        // 1. Busca no repositório primeiro para evitar chamadas desnecessárias à API
        Optional<Livro> livroExistente = livroRepository.findByTituloContainingIgnoreCase(titulo);
        if (livroExistente.isPresent()) {
            System.out.println("Livro encontrado no banco de dados.");
            return livroExistente.get();
        }

        // 2. Se não encontrar no banco, busca na API Gutendex
        System.out.println("Livro não encontrado no banco. Buscando na API...");
        GutendexResponse response = gutendexClient.buscarLivroPorTitulo(titulo);

        if (response == null || response.results().isEmpty()) {
            throw new LivroNaoEncontradoException("Nenhum livro encontrado com o título: " + titulo);
        }

        // 3. Pega o primeiro livro da resposta da API
        BookDTO bookDTO = response.results().get(0);

        // 4. Converte o DTO (dados da API) para a sua entidade Livro
        Livro novoLivro = new Livro();
        novoLivro.setTitulo(bookDTO.title());
        if (bookDTO.authors()!= null &&!bookDTO.authors().isEmpty()) {
            novoLivro.setAutor(bookDTO.authors().get(0).name());
        } else {
            novoLivro.setAutor("Desconhecido");
        }
        if (bookDTO.languages()!= null &&!bookDTO.languages().isEmpty()) {
            novoLivro.setIdioma(bookDTO.languages().get(0));
        } else {
            novoLivro.setIdioma("Desconhecido");
        }

        // 5. Salva o novo livro no banco de dados e o retorna
        System.out.println("Livro encontrado na API e salvo no banco de dados.");
        return livroRepository.save(novoLivro);
    }

    /**
     * Retorna todos os livros que estão salvos no banco de dados.
     *
     * @return Uma lista de todos os livros.
     */
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    // Você pode adicionar seus outros métodos aqui...
}