package com.api.parkingcontrol.services; 

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service /*esteriotipo especifico do spring para serviço*/

/*essa classe é o bin (uma camada de serviço pois não tem regra de negocio)
e pode tambem criar uma interface para essa classe implementar para não precisar refatorar todos os controllers   */
public class ParkingSpotService {
	
	/*ponto de injeção do repository para acionar o repository em alguns casos e sempre que tiver transação com o banco 
	  controller aciona o service e o service aciona o repository */
	
	
	final ParkingSpotRepository parkingSpotRepository;
	
	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	@Transactional /* é importante utilizar dessa anotação (quando for metodos construtivos ou destrutivos)e quando tem relacionamento e que vai haver
	exclusão ou gravação em cascata para garantir o rollback e não ter dados quebrados */ 
	public Object save(ParkingSpotModel parkingSpotModel) {
		
		return parkingSpotRepository.save(parkingSpotModel);
	}

	
}
