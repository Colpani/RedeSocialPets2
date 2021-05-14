package br.inatel.matrix.RedeSocialPets2.form;

import br.inatel.matrix.RedeSocialPets2.model.AnimalCategoria;
import br.inatel.matrix.RedeSocialPets2.model.Postagem;
import br.inatel.matrix.RedeSocialPets2.repository.AnimalCategoriaRepository;

public class PostagemForm {

	private String titulo;
	private String mensagem;
	private String categoria;

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setAnimalCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Postagem converter(AnimalCategoriaRepository animalCategoriaRepository) {
		AnimalCategoria animalCategoria = animalCategoriaRepository.findByCategoria(categoria);
		return new Postagem(titulo, mensagem, animalCategoria);
	}

}