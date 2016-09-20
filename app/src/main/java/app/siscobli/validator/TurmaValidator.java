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

	private void validarDescricaoTurmaDuplicada(Turma turma) {
		Turma turmaEncontrada = repository.findByDescricao(turma.getDescricao());
		if (!(turmaEncontrada == null) && turma.getId() != turmaEncontrada.getId()) {
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_TURMA_DESCRICAO_DUPLICADA, turma));
		}
	}
	
	private void validarDescricaoVazia(Turma turma) {
		if(turma.getDescricao() == null || turma.getDescricao().equals("")){
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_TURMA_DESCRICAO_VAZIA, turma));
		}
	}
	
	private void validarSerieVazia(Turma turma) {
		if(turma.getSerie() == null || turma.getSerie().equals("")){
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_TURMA_SERIE_VAZIA, turma));
		}
	}
	
	private void validarGrauEnsinoVazio(Turma turma) {
		if(turma.getGrauEnsino() == null || turma.getGrauEnsino().equals("")){
			throw new ValidacaoException(BasicResponseDTO.createResponse(BusinessCode.ERRO_TURMA_GRAU_ENSINO_VAZIO, turma));
		}
	}
	
	public void validarTurmaInsercao(Turma turma)
	{
		validarDescricaoTurmaDuplicada(turma);
		validarDescricaoVazia(turma);
		validarSerieVazia(turma);
		validarGrauEnsinoVazio(turma);
	}
}
