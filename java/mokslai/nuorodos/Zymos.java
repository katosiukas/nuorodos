package mokslai.nuorodos;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;

@Entity 
public class Zymos implements Serializable{
	
	private static final long serialVersionUID = -6790693372846798580L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
//	private String zyma;
	
	@Column(nullable=true)
	private String zyma;
	
	@OneToMany 
	private List<Linko_zymos> linko_zymos;
	
	public Zymos() {};
	
	public Zymos (String zyma) { this.zyma = zyma; }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZyma() {
		return zyma;
	}
	public void setZyma(String zyma) {
		this.zyma = zyma;
	}
	
	public String toString() {
		
		return this.id + ":" + this.zyma;
	}

}	