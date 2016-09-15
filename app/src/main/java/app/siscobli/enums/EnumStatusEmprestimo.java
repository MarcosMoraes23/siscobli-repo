package app.siscobli.enums;

public enum EnumStatusEmprestimo {

	E("Emprestado"), 
	D("Devolvido"), 
	A("Atrasado");

	private String label;

	private EnumStatusEmprestimo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
