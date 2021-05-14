package br.inatel.matrix.RedeSocialPets2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.inatel.matrix.RedeSocialPets2.model.AnimalCategoria;

public interface AnimalCategoriaRepository extends JpaRepository<AnimalCategoria, Long> {

	AnimalCategoria findByCategoria(String categoria);

}