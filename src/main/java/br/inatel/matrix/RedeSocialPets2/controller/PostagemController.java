package br.inatel.matrix.RedeSocialPets2.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.inatel.matrix.RedeSocialPets2.dto.DetalhesPostagemDto;
import br.inatel.matrix.RedeSocialPets2.dto.PostagemDto;
import br.inatel.matrix.RedeSocialPets2.form.PostagemForm;
import br.inatel.matrix.RedeSocialPets2.form.RefreshPostagemForm;
import br.inatel.matrix.RedeSocialPets2.model.Postagem;
import br.inatel.matrix.RedeSocialPets2.repository.AnimalCategoriaRepository;
import br.inatel.matrix.RedeSocialPets2.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@Autowired
	private AnimalCategoriaRepository animalCategoriaRepository;
	
	@GetMapping
	@Cacheable(value = "listaDePostagens")
	public Page<PostagemDto> lista(@RequestParam(required = false) String categoria, 
			@PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if (categoria == null) {
			Page<Postagem> postagens = postagemRepository.findAll(paginacao);
			return PostagemDto.converter(postagens);
		} else {
			Page<Postagem> postagens = postagemRepository.findByAnimalCategoriaCategoria(categoria, paginacao);
			return PostagemDto.converter(postagens);
		}
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDePostagens", allEntries = true)
	public ResponseEntity<PostagemDto> cadastrar(@RequestBody @Valid PostagemForm form, UriComponentsBuilder uriBuilder) {
		Postagem postagem = form.converter(animalCategoriaRepository);
		postagemRepository.save(postagem);
		
		URI uri = uriBuilder.path("/postagens/{id}").buildAndExpand(postagem.getId()).toUri();
		return ResponseEntity.created(uri).body(new PostagemDto(postagem));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesPostagemDto> detalhar(@PathVariable Long id) {
		Optional<Postagem> postagem = postagemRepository.findById(id);
		if (postagem.isPresent()) {
			return ResponseEntity.ok(new DetalhesPostagemDto(postagem.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePostagens", allEntries = true)
	public ResponseEntity<PostagemDto> atualizar(@PathVariable Long id, @RequestBody @Valid RefreshPostagemForm form) {
		Optional<Postagem> optional = postagemRepository.findById(id);
		if (optional.isPresent()) {
			Postagem postagem = form.atualizar(id, postagemRepository);
			return ResponseEntity.ok(new PostagemDto(postagem));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePostagens", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Postagem> optional = postagemRepository.findById(id);
		if (optional.isPresent()) {
			postagemRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
