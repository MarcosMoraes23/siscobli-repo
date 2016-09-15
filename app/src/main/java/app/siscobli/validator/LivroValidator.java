package app.siscobli.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.dto.BasicResponseDTO;
import app.siscobli.enums.BusinessCode;
import app.siscobli.exception.ValidacaoException;
import app.siscobli.model.Livro;
import app.siscobli.repository.LivroRepository;

@Service
public class LivroValidator {
	
	@Autowired
	private LivroRepository repository;
	
	public LivroValidator() {
	}
	
	
	private void validarLivroDuplicado(Livro livro) {
		if ((!repository.findByIsbnAndDescricao(livro.getIsbn(),livro.getDescricao()).isEmpty())) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_DUPLICADO, livro));
		}
	}
	
	
	private void validarAutorVazio(Livro livro) {
		if (livro.getAutor().isEmpty() || livro.getAutor() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_AUTOR_VAZIO, livro));
		}
	}
	
	
	private void validarIsbnVazio(Livro livro) {
		if (livro.getIsbn().isEmpty() || livro.getIsbn() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_ISBN_VAZIO, livro));
		}
	}
	
	
	private void validarNumeroPaginasVazio(Livro livro) {
		if (livro.getNumeroPaginas() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_DUPLICADO, livro));
		}
	}
	
	private void validarDescricaoVazia(Livro livro) {
		if (livro.getDescricao().isEmpty() || livro.getDescricao() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_DESCRICAO_VAZIA, livro));
		}
	}
	
	private void validarQuantidadeRealVazia(Livro livro) {
		if (livro.getQuantidadeReal() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_QUANTIDADE_REAL_VAZIO, livro));
		}
	}
	
	public void validarQuantidadeExemplaresVazia(Livro livro) {
		if (livro.getQuantidadeExemplares() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_QUANTIDADE_EXEMPLARES_VAZIO, livro));
		}
	}
	
	public void validarLivroInsercao(Livro livro)
	{
		validarLivroDuplicado(livro);
		validarAutorVazio(livro);
		validarDescricaoVazia(livro);
		validarIsbnVazio(livro);
		validarNumeroPaginasVazio(livro);
		validarQuantidadeExemplaresVazia(livro);
		validarQuantidadeRealVazia(livro);
	}
}
