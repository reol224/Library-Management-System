package Oameni;

import java.util.Objects;

public class Cititor {
	private String nume;
	private String CNP;

	public Cititor(String nume, String CNP) {
		this.nume = nume;
		this.CNP = CNP;
	}

	public Cititor() {
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String CNP) {
		this.CNP = CNP;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cititor)) return false;
		Cititor cititor = (Cititor) o;
		return Objects.equals(getNume(), cititor.getNume()) &&
				Objects.equals(getCNP(), cititor.getCNP());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNume(), getCNP());
	}

	@Override
	public String toString() {
		return "Cititor{" +
				"nume='" + nume + '\'' +
				", CNP='" + CNP + '\'' +
				'}';
	}
}
