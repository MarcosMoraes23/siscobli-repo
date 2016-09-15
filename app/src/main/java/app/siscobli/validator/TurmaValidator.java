package app.siscobli.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.siscobli.dto.BasicResponseDTO;
import app.siscobli.enums.BusinessCode;
import app.siscobli.exception.ValidacaoException;
import app.siscobli.model.Turma;
import app.siscobli.repository.TurmaRepository;

@Service
public class TurmaValidator {

	@Autowired
	private TurmaRepository repository;

	public TurmaValidator() {
	}

	public void validarDescricaoTurmaDuplicada(Turma turma) {
		if ((!repository.findByDescricao(turma.getDescricao()).isEmpty())) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_TURMA_DESCRICAO_DUPLICADA, turma));
		}
	}
}
