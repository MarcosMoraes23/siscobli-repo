package app.siscobli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.siscobli.dto.BasicResponseDTO;
import app.siscobli.enums.BusinessCode;
import app.siscobli.exception.ValidacaoException;
import app.siscobli.model.Emprestimo;
import app.siscobli.service.EmprestimoService;

@RestController
@RequestMapping(value = "emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<BasicResponseDTO> buscarTodos() {

		try {
			List<Emprestimo> emprestimos = service.buscarTodos();
			return new ResponseEntity<BasicResponseDTO>(BasicResponseDTO.createResponse(BusinessCode.SUCESSO, emprestimos), HttpStatus.OK);
		} catch (ValidacaoException e) {
			return new ResponseEntity<BasicResponseDTO>(e.getBasicResponse(), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BasicResponseDTO> buscarPorId(@PathVariable("id") long id) {

		try {
			Emprestimo emprestimo = service.buscarPorId(id);
			return new ResponseEntity<BasicResponseDTO>(BasicResponseDTO.createResponse(BusinessCode.SUCESSO, emprestimo),HttpStatus.OK);
		} catch (ValidacaoException e) {
			return new ResponseEntity<BasicResponseDTO>(e.getBasicResponse(), HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BasicResponseDTO> salvar(@RequestBody Emprestimo emprestimo) {

		try {
			service.salvar(emprestimo);
			return new ResponseEntity<BasicResponseDTO>(BasicResponseDTO.createResponse(BusinessCode.SUCESSO_SALVAR, emprestimo), HttpStatus.OK);
		} catch (ValidacaoException e) {
			return new ResponseEntity<BasicResponseDTO>(e.getBasicResponse(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<BasicResponseDTO> atualizar(@PathVariable("id") long id, @RequestBody Emprestimo emprestimo) {

		try {
			service.atualizar(emprestimo);
			return new ResponseEntity<BasicResponseDTO>(BasicResponseDTO.createResponse(BusinessCode.SUCESSO_ATUALIZAR, emprestimo), HttpStatus.OK);
		} catch (ValidacaoException e) {
			return new ResponseEntity<BasicResponseDTO>(e.getBasicResponse(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BasicResponseDTO> excluir(@PathVariable("id") String id) {
		
		try {
			service.excluir(Long.parseLong(id));
			return new ResponseEntity<BasicResponseDTO>(BasicResponseDTO.createResponse(BusinessCode.SUCESSO_REMOVER, id), HttpStatus.OK);
		} catch (ValidacaoException e) {
			return new ResponseEntity<BasicResponseDTO>(e.getBasicResponse(), HttpStatus.NOT_FOUND);
		}
	}
}
