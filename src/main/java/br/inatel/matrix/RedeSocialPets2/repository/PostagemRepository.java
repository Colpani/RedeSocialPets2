package br.inatel.matrix.RedeSocialPets2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.inatel.matrix.RedeSocialPets2.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	Page<Postagem> findByAnimalCategoriaCategoria(String categoria, Pageable paginacao);

}

