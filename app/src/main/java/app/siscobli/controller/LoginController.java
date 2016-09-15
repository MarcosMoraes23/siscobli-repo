package app.siscobli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.siscobli.dto.BasicResponseDTO;
import app.siscobli.enums.BusinessCode;
import app.siscobli.exception.ValidacaoException;
import app.siscobli.model.Usuario;
import app.siscobli.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@RequestMapping(value = "/efetuarLogin", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BasicResponseDTO> efetuarLogin(@RequestBody Usuario usuario) {

		try {
			usuario = service.efetuarLogin(usuario);
			return new ResponseEntity<BasicResponseDTO>(BasicResponseDTO.createResponse(BusinessCode.SUCESSO_LOGIN, usuario),HttpStatus.OK);
		} catch (ValidacaoException e) {
			return new ResponseEntity<BasicResponseDTO>(e.getBasicResponse(), HttpStatus.NOT_FOUND);
		}
	}

}
