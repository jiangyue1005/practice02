package kadai2;

public abstract class Omikuji {

	protected String unsei;
	protected String negaigoto;
	protected String akinai;
	protected String gakumon;

	public abstract void setUnsei();

	public String getUnsei() {
		return unsei;
	}

	public void setUnsei(String unsei) {
		this.unsei = unsei;
	}

	public String getNegaigoto() {
		return negaigoto;
	}

	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}

	public String getAkinai() {
		return akinai;
	}

	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}

	public String getGakumon() {
		return gakumon;
	}

	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}

}