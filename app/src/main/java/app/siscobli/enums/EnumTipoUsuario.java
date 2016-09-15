package app.siscobli.enums;

public enum EnumTipoUsuario {

	A("Aluno"), 
	B("Bibliotecária"),
	SE("Servidor"), 
	SU("Supervisor"), 
	P("Professor"), 
	D("Diretor");

	private String label;
	
	private EnumTipoUsuario(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
