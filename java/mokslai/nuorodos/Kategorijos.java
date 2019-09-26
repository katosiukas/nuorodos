package mokslai.nuorodos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class Kategorijos implements Serializable{
	
	private static final long serialVersionUID = -6790693372846798580L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
//	private String pavadinimas;
	
	@JsonIgnoreProperties("kategorijos")
	@OneToMany(mappedBy = "kategorijos",cascade = CascadeType.ALL)
	private List<Nuorodos> nuorodos; 
	
	@Column(nullable=true)
	private String pavadinimas;
	
	@OneToMany 
	private List<Linko_zymos> linko_zymos;
	
	public Kategorijos() {};
	
	public Kategorijos (String pavadinimas) { this.pavadinimas = pavadinimas; }
	
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
	
	public List<Nuorodos> getNuorodos() {
		
		return nuorodos;
	}

	public void setNuorodos (List<Nuorodos> nuorodos) {
	
		this.nuorodos = nuorodos;
	}
}	