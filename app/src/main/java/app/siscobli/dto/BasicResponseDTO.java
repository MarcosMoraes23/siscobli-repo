package app.siscobli.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import app.siscobli.enums.BusinessCode;

@XmlRootElement
public class BasicResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;
	private String mensagemRetorno;
	private Object entity;

	public BasicResponseDTO() {
	}

	public BasicResponseDTO(int status, String mensagemRetorno, Object entity) {
		super();
		this.status = status;
		this.mensagemRetorno = mensagemRetorno;
		this.entity = entity;
	}

	public BasicResponseDTO(BusinessCode businessCode, Object entity) {
		super();
		this.status = businessCode.getCodigo();
		this.mensagemRetorno = businessCode.getMensagem();
		this.entity = entity;
	}

	public static BasicResponseDTO createResponse(BusinessCode businessCode, Object entity) {
		return new BasicResponseDTO(businessCode, entity);
	}
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}
	
	

}
