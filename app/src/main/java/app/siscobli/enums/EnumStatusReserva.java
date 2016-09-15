package app.siscobli.enums;

public enum EnumStatusReserva {

	A("Aberta"), 
	E("Expirada"), 
	C("Concluida");

	private String label;

	private EnumStatusReserva(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
