package br.inatel.matrix.RedeSocialPets2.form;

import br.inatel.matrix.RedeSocialPets2.model.Postagem;
import br.inatel.matrix.RedeSocialPets2.repository.PostagemRepository;

	public class RefreshPostagemForm {

		private String titulo;
		private String mensagem;

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		public Postagem atualizar(Long id, PostagemRepository postagemRepository) {
			Postagem postagem = postagemRepository.getOne(id);
			
			postagem.setTitulo(this.titulo);
			postagem.setMensagem(this.mensagem);
			
			return postagem;
		}
		
	}
