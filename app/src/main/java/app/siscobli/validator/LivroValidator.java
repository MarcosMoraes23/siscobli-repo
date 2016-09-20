package app.siscobli.validator;

import org.joda.time.DateTime;
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
	
	
	private void validarIsbnDuplicado(Livro livro) {
		Livro livroEncontrado = repository.findByIsbn(livro.getIsbn());
		if (!(livroEncontrado == null) && livroEncontrado.getId() != livro.getId()) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_ISBN_DUPLICADO, livro));
		}
	}
	
	private void validarLivroDuplicado(Livro livro) {
		Livro livroEncontrado = repository.findByIsbnAndDescricao(livro.getIsbn(),livro.getDescricao());
		if (!(livroEncontrado == null) && livroEncontrado.getId() != livro.getId()) {
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
		else if (livro.getQuantidadeReal() == 0 || livro.getQuantidadeReal() < 0) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_QUANTIDADE_REAL_ZERADA, livro));
		}
		
	}
	
	private void validarQuantidadeExemplaresVazia(Livro livro) {
		if (livro.getQuantidadeExemplares() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_QUANTIDADE_EXEMPLARES_VAZIO, livro));
		}
	}

	private void validarDataFutura(Livro livro) {
		if (livro.getDataLancamento() != null && livro.getDataLancamento().after(new DateTime().toDate())) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_DATA_FUTURA, livro));
		}
	}
	
	private void validarQuantidadeRealExemplares(Livro livro) {
		if (livro.getQuantidadeExemplares() > livro.getQuantidadeReal()) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_REAL_EXEMPLARES, livro));
		}
	}
	
	public void validarLivroInsercao(Livro livro)
	{
		validarDescricaoVazia(livro);
		validarLivroDuplicado(livro);
		validarAutorVazio(livro);
		validarIsbnVazio(livro);
		validarIsbnDuplicado(livro);
		validarNumeroPaginasVazio(livro);
		validarQuantidadeRealVazia(livro);
		validarDataFutura(livro);
		validarQuantidadeExemplaresVazia(livro);
		validarQuantidadeRealExemplares(livro);
	}
	
	
	public void validarLivroEdicao(Livro livro)
	{
		validarDescricaoVazia(livro);
		validarAutorVazio(livro);
		validarIsbnVazio(livro);
		validarIsbnDuplicado(livro);
		validarNumeroPaginasVazio(livro);
		validarQuantidadeRealVazia(livro);
		validarDataFutura(livro);
		validarQuantidadeExemplaresVazia(livro);
		validarQuantidadeRealExemplares(livro);
	}
}
