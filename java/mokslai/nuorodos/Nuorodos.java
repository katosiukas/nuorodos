package mokslai.nuorodos;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class Nuorodos implements Serializable{
	
	private static final long serialVersionUID = -6790693372846798580L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String pavadinimas;
	private String linkas;
	private String aprasymas;
	private String data;
	private String tipas;
	private Integer reitingas;
	
	@Column(nullable=true)
	private Integer kategorijos_id;
	
	@JsonIgnoreProperties("nuorodos")
	@ManyToOne 
	@JoinColumn(name="kategorijos_id", insertable = false, updatable = false)
	private Kategorijos kategorijos;
	
	public Nuorodos() {}
	
	public Nuorodos(String pavadinimas, String linkas, String aprasymas, String data, String tipas, Integer reitingas, Integer kategorijos_id) {
		
		this.pavadinimas = pavadinimas;
		this.linkas = linkas;
		this.aprasymas = aprasymas;
		this.data = data;
		this.tipas = tipas;
		this.reitingas = reitingas;
		this.kategorijos_id = kategorijos_id;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPavadinimas() {
		return pavadinimas;
	}
	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	public String getLinkas() {
		return linkas;
	}
	public void setLinkas(String linkas) {
		this.linkas = linkas;
	}
	public String getAprasymas() {
		return aprasymas;
	}
	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTipas() {
		return tipas;
	}
	public void setTipas(String tipas) {
		this.tipas = tipas;
	}
	public Integer getReitingas() {
		return reitingas;
	}
	public void setReitingas(Integer reitingas) {
		this.reitingas = reitingas;
	}
	public Integer getKategorijos_id() {
		return kategorijos_id;
	}
	public void setKategorijos_id(Integer kategorijos_id) {
		this.kategorijos_id = kategorijos_id;
	}
	
	public Kategorijos getKategorijos() {
		return kategorijos;
	}
	public void setKategorijos(Kategorijos kategorijos) {
		this.kategorijos = kategorijos;
	}
}	