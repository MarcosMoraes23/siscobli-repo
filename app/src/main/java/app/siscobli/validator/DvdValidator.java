package app.siscobli.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.dto.BasicResponseDTO;
import app.siscobli.enums.BusinessCode;
import app.siscobli.exception.ValidacaoException;
import app.siscobli.model.Dvd;
import app.siscobli.repository.DvdRepository;

@Service
public class DvdValidator {

	@Autowired
	private DvdRepository repository;

	public DvdValidator() {
	}

	private void validarDvdDuplicado(Dvd dvd) {
		if ((!repository.findByDescricao(dvd.getDescricao()).isEmpty())) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_DVD_DUPLICADO, dvd));
		}
	}
	
	private void validarTituloVazio(Dvd dvd) {
		if (dvd.getDescricao().isEmpty() || dvd.getDescricao() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_DVD_TITULO_VAZIO, dvd));
		}
	}
	
	private void validarCategoriaVazia(Dvd dvd) {
		if (dvd.getCategoria().isEmpty() || dvd.getCategoria() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_DVD_CATEGORIA_VAZIA, dvd));
		}
	}
	private void validarQuatidadeRealVazia(Dvd dvd) {
		if (dvd.getQuantidadeReal() == null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_DVD_QUANTIDADE_REAL_VAZIO, dvd));
		}
	}
	private void validarQuatidadeExemplaresVazia(Dvd dvd) {
		if (dvd.getQuantidadeExemplares()== null) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_DVD_QUANTIDADE_EXEMPLARES_VAZIO, dvd));
		}
	}
	
	public void validarDvdInsercao(Dvd dvd)
	{
		validarDvdDuplicado(dvd);
		validarTituloVazio(dvd);
		validarCategoriaVazia(dvd);
		validarQuatidadeExemplaresVazia(dvd);
		validarQuatidadeRealVazia(dvd);
	}
}