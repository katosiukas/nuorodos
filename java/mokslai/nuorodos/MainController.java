package mokslai.nuorodos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;

@Controller    
@RequestMapping(path="/restfull") 
public class MainController {
						
	@Autowired         	
	private KategorijosRepository KategorijosRepository;
	
	@Autowired         	
	private Linko_zymosRepository Linko_zymosRepository;
	
	@Autowired         	
	private NuorodosRepository NuorodosRepository;
	
	@Autowired         	
	private ZymosRepository ZymosRepository;
	
	//------------------  Kategorijos --------------
	
	@GetMapping(path="/all_kategorijos")
	public @ResponseBody Iterable<Kategorijos> getAllKategorijos() {
		
		return KategorijosRepository.findAll();
	}
	
	@GetMapping(path="/del_kategorija") 
	public @ResponseBody String trinti_kategorijos (@RequestParam Integer id ) {
				
		Optional <Kategorijos> found = KategorijosRepository.findById( id );
		
		String res = "Not done";
		Kategorijos n = found.get();
		n.setId(id);
		KategorijosRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
	
	@GetMapping(path="/edit_kategorija") 
	public @ResponseBody String redaguoti_kategorija ( @RequestParam Integer id, @RequestParam String pavadinimas ) {
		
		String res = "Not done";
		Kategorijos n = new Kategorijos();
		
		Optional <Kategorijos> found = KategorijosRepository.findById( id );
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			   n.setPavadinimas( pavadinimas );
			   KategorijosRepository.save(n);	
			   res = "Saved";
						  
			}
			
		 return res;
	}
	
	@GetMapping(path="/add_kategorija") 
	public @ResponseBody String prideti_kategorija (@RequestParam String pavadinimas ) {
				
		Kategorijos n = new Kategorijos();
		n.setPavadinimas(pavadinimas);
		KategorijosRepository.save(n);
		return "Saved";
	}
		
	// -------------- Linko zymos ----------------
	
	@GetMapping(path="/all_Linko_zymos")
	public @ResponseBody Iterable<Linko_zymos> getAllLinko_zymos() {
		
		return Linko_zymosRepository.findAll();
	}
		
	@GetMapping(path="/linko_zyma")
	public @ResponseBody List<Linko_zymos> Linko_zymos(@RequestParam Integer kategorijos_id) {
		
		return Linko_zymosRepository.findByKategorijos_id (kategorijos_id);
	}
	
	@GetMapping(path="/del_Linko_zymos") 
	public @ResponseBody String trinti_Linko_zymos (@RequestParam Integer id ) {
				
		Optional <Linko_zymos> found = Linko_zymosRepository.findById( id );
		
		String res = "Not done";
		Linko_zymos n = found.get();
		n.setId(id);
		Linko_zymosRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
	
	@GetMapping(path="/edit_Linko_zymos") 
	public @ResponseBody String redaguoti_Linko_zymos ( @RequestParam Integer id, @RequestParam Integer zymos_id, @RequestParam Integer kategorijos_id ) {
		
		String res = "Not done";
		Linko_zymos n = new Linko_zymos();
		
		Optional <Linko_zymos> found = Linko_zymosRepository.findById( id );
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			   n.setZymos_id( zymos_id );
			   n.setKategorijos_id( kategorijos_id );
			   Linko_zymosRepository.save(n);	
			   res = "Saved";
						  
			}
			
		 return res;
	}
	
	@GetMapping(path="/add_Linko_zymos") 
	public @ResponseBody String prideti_Linko_zymos (@RequestParam Integer zymos_id,  @RequestParam Integer kategorijos_id ) {
				
		Linko_zymos n = new Linko_zymos();
		n.setZymos_id(zymos_id);
		n.setKategorijos_id(kategorijos_id);
		Linko_zymosRepository.save(n);
		return "Saved";
	}
	
	//--------------- Nuorodos -------------------
	
	@GetMapping(path="/all_nuorodos")
	public @ResponseBody Iterable<Nuorodos> getAllNuorodos() {
		
		return NuorodosRepository.findAll();
	}
	
	@GetMapping(path="/del_nuoroda") 
	public @ResponseBody String trinti_Nuorodos (@RequestParam Integer id ) {
				
		Optional <Nuorodos> found = NuorodosRepository.findById( id );
		
		String res = "Not done";
		Nuorodos n = found.get();
		n.setId(id);
		NuorodosRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
	
	@GetMapping(path="/edit_nuoroda") 
	public @ResponseBody String redaguoti_Nuorodos ( @RequestParam Integer id, 
														@RequestParam String pavadinimas, 
														@RequestParam String linkas,
														@RequestParam String aprasymas,
														@RequestParam String data,
														@RequestParam String tipas,
														@RequestParam Integer reitingas,
														@RequestParam Integer kategorijos_id
													) {
		
		String res = "Not done";
		Nuorodos n = new Nuorodos();
		
		Optional <Nuorodos> found = NuorodosRepository.findById( id );
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			   n.setPavadinimas( pavadinimas );
			   n.setLinkas( linkas );
			   n.setAprasymas( aprasymas );
			   n.setData( data );
			   n.setTipas( tipas );
			   n.setReitingas( reitingas );
			   n.setKategorijos_id( kategorijos_id );
			   NuorodosRepository.save(n);	
			   res = "Saved";
						  
			}
			
		 return res;
	}
	
	@GetMapping(path="/add_nuoroda") 
	public @ResponseBody String prideti_Nuorodos (  
			@RequestParam String pavadinimas, 
			@RequestParam String linkas,
			@RequestParam String aprasymas,
			@RequestParam String data,
			@RequestParam String tipas,
			@RequestParam Integer reitingas,
			@RequestParam Integer kategorijos_id
		) {
				
		Nuorodos n = new Nuorodos();
		n.setPavadinimas( pavadinimas );
		n.setLinkas( linkas );
		n.setAprasymas( aprasymas );
		n.setData( data );
		n.setTipas( tipas );
		n.setReitingas( reitingas );
		n.setKategorijos_id( kategorijos_id );
		NuorodosRepository.save(n);
		return "Saved";
	}
	
	// --------------- Zymos ----------------------
	
	@GetMapping(path="/all_zymos")
	public @ResponseBody Iterable<Zymos> getAllZymos() {
		
		return ZymosRepository.findAll();
	}
	
	@GetMapping(path="/del_zyma") 
	public @ResponseBody String trinti_Zymos (@RequestParam Integer id ) {
				
		Optional <Zymos> found = ZymosRepository.findById( id );
		
		String res = "Not done";
		Zymos n = found.get();
		System.out.println(n.toString());
		
		ZymosRepository.deleteById(id);
		res = "Deleted";
		
		return res;
	}
	
	@GetMapping(path="/edit_zyma") 
	public @ResponseBody String redaguoti_Zymos ( @RequestParam Integer id, @RequestParam String zyma ) {
		
		String res = "Not done";
		Zymos n = new Zymos();
		
		Optional <Zymos> found = ZymosRepository.findById( id );
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			   n.setZyma( zyma );
			   ZymosRepository.save(n);	
			   res = "Saved";
						  
			}
			
		 return res;
	}
	
	@GetMapping(path="/add_zyma") 
	public @ResponseBody String prideti_Zymos (@RequestParam String zyma) {
		
		Zymos n = new Zymos();
		n.setZyma(zyma);
		ZymosRepository.save(n);
		return "Saved";
	}
}