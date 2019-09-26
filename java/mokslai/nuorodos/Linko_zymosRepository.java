package mokslai.nuorodos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Linko_zymosRepository extends CrudRepository<Linko_zymos, Integer> {
	
	List<Linko_zymos> findByKategorijos_id(Integer kategorijos_id);
	
}