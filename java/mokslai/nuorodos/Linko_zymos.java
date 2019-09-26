package mokslai.nuorodos;

import java.io.Serializable;
import javax.persistence.*;

@Entity 
public class Linko_zymos implements Serializable{
	
	private static final long serialVersionUID = -6790693372846798580L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer zymos_id;
	private Integer kategorijos_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="zymos_id",insertable = false, updatable = false)
	private Zymos zymos;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="kategorijos_id",insertable = false, updatable = false)
	private Kategorijos kategorijos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getZymos_id() {
		return zymos_id;
	}
	public void setZymos_id(Integer zymos_id) {
		this.zymos_id = zymos_id;
	}
	public Integer getKategorijos_id() {
		return kategorijos_id;
	}
	public void setKategorijos_id(Integer kategorijos_id) {
		this.kategorijos_id = kategorijos_id;
	}
	
	public Zymos getZymos() {
		
		return zymos;
	}

	public void setZymos (Zymos zymos) {
	
		this.zymos = zymos;
	} 
	
	public Kategorijos getKategorijos() {
		
		return kategorijos;
	}

	public void setKategorijos (Kategorijos kategorijos) {
	
		this.kategorijos = kategorijos;
	} 
	
}	