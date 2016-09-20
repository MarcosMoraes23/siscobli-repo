package app.siscobli.validator;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.dto.BasicResponseDTO;
import app.siscobli.enums.BusinessCode;
import app.siscobli.exception.ValidacaoException;
import app.siscobli.model.Periodico;
import app.siscobli.repository.PeriodicoRepository;

@Service
public class PeriodicoValidator {

	@Autowired
	private PeriodicoRepository repository;

	public PeriodicoValidator() {
	}

	private void validarPeriodicoDuplicado(Periodico periodico) {
		Periodico periodicoEncontrado = repository.findByDescricao(periodico.getDescricao());
		if (!(periodicoEncontrado == null) && periodico.getId() != periodicoEncontrado.getId()) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_PERIODICO_DUPLICADO, periodico));
		}
	}
	
	private void validarTituloVazio(Periodico periodico) {
		if (periodico.getDescricao().isEmpty() || periodico.getDescricao() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_PERIODICO_TITULO_VAZIO, periodico));
		}
	}
	
	private void validarCategoriaVazia(Periodico periodico) {
		if (periodico.getCategoria().isEmpty() || periodico.getCategoria() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_PERIODICO_CATEGORIA_VAZIA, periodico));
		}
	}
	private void validarQuatidadeRealVazia(Periodico periodico) {
		if (periodico.getQuantidadeReal() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_DVD_QUANTIDADE_REAL_VAZIO, periodico));
		}
		else if (periodico.getQuantidadeReal() == 0 || periodico.getQuantidadeReal() < 0) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_QUANTIDADE_REAL_ZERADA, periodico));
		}
	}
	
	private void validarQuatidadeExemplaresVazia(Periodico periodico) {
		if (periodico.getQuantidadeExemplares()== null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_DVD_QUANTIDADE_EXEMPLARES_VAZIO, periodico));
		}
	}
	
	private void validarDataLancamentoVazia(Periodico periodico) {
		if (periodico.getDataLancamento()== null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_PERIODICO_DATA_VAZIA, periodico));
		}
	}
	
	private void validarEdicaoVazia(Periodico periodico) {
		if (periodico.getEdicao()== null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_PERIODICO_EDICAO_VAZIA, periodico));
		}
	}
	
	public void validarDataFutura(Periodico periodico) {
		if (periodico.getDataLancamento() != null && periodico.getDataLancamento().after(new DateTime().toDate())) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_DATA_FUTURA, periodico));
		}
	}
	
	private void validarQuantidadeRealExemplares(Periodico periodico) {
		if (periodico.getQuantidadeExemplares() > periodico.getQuantidadeReal()) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_LIVRO_REAL_EXEMPLARES, periodico));
		}
	}
	
	public void validarPeriodicoInsercao(Periodico periodico)
	{
		validarPeriodicoDuplicado(periodico);
		validarTituloVazio(periodico);
		validarCategoriaVazia(periodico);
		validarQuatidadeExemplaresVazia(periodico);
		validarQuatidadeRealVazia(periodico);
		validarDataLancamentoVazia(periodico);
		validarEdicaoVazia(periodico);
		validarDataFutura(periodico);
		validarQuantidadeRealExemplares(periodico);
	}
	
	public void validarPeriodicoEdicao(Periodico periodico)
	{
		validarPeriodicoDuplicado(periodico);
		validarTituloVazio(periodico);
		validarCategoriaVazia(periodico);
		validarDataLancamentoVazia(periodico);
		validarQuatidadeRealVazia(periodico);
		validarQuatidadeExemplaresVazia(periodico);
		validarEdicaoVazia(periodico);
		validarDataFutura(periodico);
		validarQuantidadeRealExemplares(periodico);
	}
}