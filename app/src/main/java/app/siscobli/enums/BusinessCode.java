package app.siscobli.enums;

public enum BusinessCode{

	/* --- Mensagens globais --- */
	SUCESSO(0, "Sucesso!"),
	SUCESSO_SALVAR(0, "Registro salvo com sucesso!"),
	SUCESSO_ATUALIZAR(0, "Registro atualizado com sucesso!"),
	SUCESSO_REMOVER(0, "Registro removido com sucesso!"),
	
	INTERNAL_ERROR(1, "Erro de negócio"),
	INTERNAL_ERROR_SALVAR(2, "Erro ao salvar o registro"),
	INTERNAL_ERROR_ATUALIZAR(3, "Erro ao atualizar o registro"),
	INTERNAL_ERROR_REMOVER(4, "Erro ao remover o registro"),
	
	/* --- Mensagens relativas ao Usuário --- */
	ERRO_USUARIO_LOGIN_VAZIO(5, "O campo Login não pode estar vazio."),
	ERRO_USUARIO_LOGIN_EXISTENTE(5, "O Login inserido já está cadastrado!"),
	ERRO_USUARIO_NOME_VAZIO(6, "O campo Nome Completo não pode estar vazio."),
	ERRO_USUARIO_SENHA_VAZIA(7, "O campo Senha não pode estar vazia."),
	ERRO_USUARIO_TIPO_VAZIO(8, "O Campo Tipo de Usuário não pode estar vazio."),
	ERRO_USUARIO_SENHA_MIN(9, "A senha deve conter no mínimo 8 caracteres."),
	ERRO_USUARIO_SENHA_MAX(10, "A senha deve conter no máximo 12 caracteres."),
	ERRO_USUARIO_SENHA_INVALIDOS(11, "Usuário ou senha inválidos !"),
	SUCESSO_LOGIN(12, "Sucesso ao Logar!"),
	
	ERRO_EXCLUSAO_USUARIO_EMPRESTIMO_ATIVO(13, "Não é possível excluir um usuário que possui empréstimos Ativos!"),
	
	/* --- Mensagens relativas ao Livro --- */
	ERRO_LIVRO_DUPLICADO(14, "O Título informado já existe! "),
	ERRO_LIVRO_AUTOR_VAZIO(15, "O Campo Autor não pode estar vazio."),
	ERRO_LIVRO_ISBN_VAZIO(16, "O Campo ISBN não pode estar vazio. "),
	ERRO_LIVRO_NUMERO_PAGINAS_VAZIO(17, "O Campo Número de Páginas não pode estar vazio. "),
	ERRO_LIVRO_QUANTIDADE_REAL_VAZIO(18, "O Campo Quantidade Real não pode estar vazio. "),
	ERRO_LIVRO_QUANTIDADE_EXEMPLARES_VAZIO(19, "O Campo Quantidade de Exemplares não pode estar vazio. "),
	ERRO_LIVRO_DESCRICAO_VAZIA(20, "O Campo Título não pode estar vazio. "),
	
	/* --- Mensagens relativas a Turma --- */
	ERRO_TURMA_DESCRICAO_DUPLICADA(21, "A Descrição da turma informada já existe! "),
	
	/* --- Mensagens relativas ao DVD --- */
	ERRO_DVD_DUPLICADO(22, "O Título informado já existe! "),
	ERRO_DVD_TITULO_VAZIO(23, "O Campo Título não pode estar vazio. "),
	ERRO_DVD_CATEGORIA_VAZIA(24, "O Campo Categoria não pode estar vazio. "),
	ERRO_DVD_QUANTIDADE_REAL_VAZIO(25, "O Campo Quantidade Real não pode estar vazio. "),
	ERRO_DVD_QUANTIDADE_EXEMPLARES_VAZIO(26, "O Campo Quantidade de Exemplares não pode estar vazio. "),
	
	/* --- Mensagens relativas ao DVD --- */
	ERRO_PERIODICO_DUPLICADO(27, "O Título informado já existe! "),
	ERRO_PERIODICO_TITULO_VAZIO(28, "O Campo Título não pode estar vazio. "),
	ERRO_PERIODICO_CATEGORIA_VAZIA(29, "O Campo Categoria não pode estar vazio. "),
	ERRO_PERIODICO_EDICAO_VAZIA(30, "O Campo Edição não pode estar vazio. "),
	ERRO_PERIODICO_DATA_VAZIA(31, "O Campo Data Lancamento não pode estar vazio. ");
	
	private int codigo;
	private String mensagem;
	
	private BusinessCode(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
