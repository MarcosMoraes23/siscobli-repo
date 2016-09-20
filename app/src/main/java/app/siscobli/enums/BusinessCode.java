package app.siscobli.enums;

public enum BusinessCode{

	/* --- Mensagens globais --- */
	SUCESSO("Sucesso!"),
	SUCESSO_SALVAR("Registro salvo com sucesso!"),
	SUCESSO_ATUALIZAR("Registro atualizado com sucesso!"),
	SUCESSO_REMOVER("Registro removido com sucesso!"),
	
	INTERNAL_ERROR("Erro de negócio"),
	INTERNAL_ERROR_SALVAR("Erro ao salvar o registro"),
	INTERNAL_ERROR_ATUALIZAR("Erro ao atualizar o registro"),
	INTERNAL_ERROR_REMOVER("Erro ao remover o registro"),
	
	/* --- Mensagens relativas ao Usuário --- */
	ERRO_USUARIO_LOGIN_VAZIO("O campo Login não pode estar vazio."),
	ERRO_USUARIO_LOGIN_EXISTENTE("O Login inserido já está cadastrado!"),
	ERRO_USUARIO_NOME_VAZIO("O campo Nome Completo não pode estar vazio."),
	ERRO_USUARIO_SENHA_VAZIA("O campo Senha não pode estar vazio."),
	ERRO_USUARIO_TIPO_VAZIO("O Campo Tipo de Usuário não pode estar vazio."),
	ERRO_USUARIO_SENHA_MIN("A senha deve conter no mínimo 8 caracteres."),
	ERRO_USUARIO_SENHA_MAX("A senha deve conter no máximo 12 caracteres."),
	ERRO_USUARIO_SENHA_INVALIDOS("Usuário ou senha inválidos !"),
	ERRO_TIPO_USUARIO_INVALIDO("Selecione um Tipo de Usuário válido!"),
	SUCESSO_LOGIN("Sucesso ao Logar!"),
	
	ERRO_EXCLUSAO_USUARIO_EMPRESTIMO_ATIVO("Não é possível excluir um usuário que possui empréstimos ativos!"),
	ERRO_EXCLUSAO_USUARIO_RESERVA_ATIVA("Não é possível excluir um usuário que possui reservas ativas!"),
	
	/* --- Mensagens relativas ao Livro --- */
	ERRO_LIVRO_DUPLICADO("O Título informado já existe! "),
	ERRO_LIVRO_ISBN_DUPLICADO("O Campo ISBN informado já existe! "),
	ERRO_LIVRO_AUTOR_VAZIO("O Campo Autor não pode estar vazio."),
	ERRO_LIVRO_ISBN_VAZIO("O Campo ISBN não pode estar vazio. "),
	ERRO_LIVRO_NUMERO_PAGINAS_VAZIO("O Campo Número de Páginas não pode estar vazio. "),
	ERRO_LIVRO_QUANTIDADE_REAL_VAZIO("O Campo Quantidade Real não pode estar vazio. "),
	ERRO_LIVRO_QUANTIDADE_REAL_ZERADA("O Campo Quantidade Real deve ser maior que zero! "),
	ERRO_LIVRO_QUANTIDADE_EXEMPLARES_VAZIO("O Campo Quantidade de Exemplares não pode estar vazio. "),
	ERRO_LIVRO_DESCRICAO_VAZIA("O Campo Título não pode estar vazio. "),
	ERRO_LIVRO_DATA_FUTURA("A Data de Lançameto deve ser anterior a data atual. "),
	ERRO_LIVRO_REAL_EXEMPLARES("A Quantidade Exemplares não pode ser superior a Quantidade Real! "),
	
	
	/* --- Mensagens relativas a Turma --- */
	ERRO_TURMA_DESCRICAO_DUPLICADA("A Descrição da turma informada já existe! "),
	ERRO_TURMA_DESCRICAO_VAZIA("O campo Descrição não pode estar vazio. "),
	ERRO_TURMA_GRAU_ENSINO_VAZIO("O campo Grau de Ensino não pode estar vazio"),
	ERRO_TURMA_SERIE_VAZIA("O campo Série não pode estar vazio. "),
	
	/* --- Mensagens relativas ao DVD --- */
	ERRO_DVD_DUPLICADO("O Título informado já existe! "),
	ERRO_DVD_TITULO_VAZIO("O Campo Título não pode estar vazio. "),
	ERRO_DVD_CATEGORIA_VAZIA("O Campo Categoria não pode estar vazio. "),
	ERRO_DVD_QUANTIDADE_REAL_VAZIO("O Campo Quantidade Real não pode estar vazio. "),
	ERRO_DVD_QUANTIDADE_EXEMPLARES_VAZIO( "O Campo Quantidade de Exemplares não pode estar vazio. "),
	
	/* --- Mensagens relativas ao DVD --- */
	ERRO_PERIODICO_DUPLICADO("O Título informado já existe! "),
	ERRO_PERIODICO_TITULO_VAZIO("O Campo Título não pode estar vazio. "),
	ERRO_PERIODICO_CATEGORIA_VAZIA("O Campo Categoria não pode estar vazio. "),
	ERRO_PERIODICO_EDICAO_VAZIA("O Campo Edição não pode estar vazio. "),
	ERRO_PERIODICO_DATA_VAZIA("O Campo Data Lancamento não pode estar vazio. ");
	
	private String mensagem;
	
	private BusinessCode(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

}
