package Carti;

public class Carte {
	private String titlu;
	private String autor;


	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Carte(String titlu, String autor) {
		super();
		this.titlu = titlu;
		this.autor = autor;
	}
	public Carte() {
		super();
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((titlu == null) ? 0 : titlu.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (titlu == null) {
			return other.titlu == null;
		} else return titlu.equals(other.titlu);
	}
	@Override
	public String toString() {
		return "Carte [titlu=" + titlu + ", autor=" + autor + "]";
	}

	public enum BookStatus{
		AVAILABLE,
		RESERVED,
		LOANED,
		LOST
	}
	
	public enum ReservationStatus{
		  WAITING,
		  PENDING,
		  CANCELED,
		  NONE, COMPLETED
		}
	public class Constants {
		  public static final int MAX_BOOKS_ISSUED_TO_A_USER = 5;
		  public static final int MAX_LENDING_DAYS = 10;
		}
}
