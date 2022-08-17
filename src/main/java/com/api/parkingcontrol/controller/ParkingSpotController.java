package com.api.parkingcontrol.controller;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController

@CrossOrigin(origins = "*", maxAge = 3600) /*anotações que permite que seja acessado de qualquer fonte */

@RequestMapping("/parking-spot")/*para acessar o recurso (e esta sendo inserido a nivel de classe )*/

public class ParkingSpotController {
	/*essa classe tambem é um bin do spring e então utilizamos um esteriotipo exclusivo que é @RestController (já que estamos criando uma API Rest) */

	final ParkingSpotService parkingSpotService;
	
	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService; 
	}
	
	@PostMapping /*metodo post http*/
	
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
		/*metodo publico, com ResponseEntity para montar a resposta(como status e o corpo da resposta)
		 com <Object> pois vamos ter diferentes tipos de retorno dependendo das verificações  */
		/*saveParkingSpot (que é todos campos que o cliente vai criar), recebe como parte do metodo, porem ele vem como json (esta construindo uma api rest)
		 * e @RequestBody tem que ser definido para receber os dados como JSON  
		 *@Valid é importante e tem que ser colocado na frente dos dados DTO, para validar os metodos informados no ParkingSpotDto (@NotBlank)  */
		var parkingSpotModel = new ParkingSpotModel();/*dentro do escopo fechado posso utilizar o var*/
		
		
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);/*parkingSpotDto - recebemos e converte para arkingSpotModel devido o metodo BeanUtils.copyProperties*/
		
		parkingSpotModel.setRegistrationDate(LocalDate.now(ZoneId.of("UTC")));/*setRegistrationDate - está setando a data no padão UTC pois o cliente não informa e o ID é automático*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));/*return ResponseEntity.status - constroi a resposta aonde passa o status
		  HttpStatus.CREATED e no body passa o retorno da vaga e o ID gravada no banco
		   save(parkingSpotModel) recebe salva e retorna o save com o id */
		
	}
}
