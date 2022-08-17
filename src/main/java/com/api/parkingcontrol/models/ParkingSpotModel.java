package com.api.parkingcontrol.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id /* é o identificador da entidade,e tem que ser declarada dessa forma */
	
	@GeneratedValue(strategy = GenerationType.AUTO)/*o id vai ser gerado automaticamente devido a declaração (strategy = GenerationType.AUTO) */
	private UUID id; /*o UUID é o tipo, pois é identificador universal e distribuido para microservices e arquitetura distribuidas*/
	
	@Column(nullable = false, unique = true, length = 10)/*utilizamos @Column para passar as restrições para cada coluna gerada*/
	private String parkingSpotNumber;
	
	@Column(nullable = false, unique = true, length = 7)
	private String LicensePlateCar;
	
	@Column(nullable = false, length = 70)
	private String brandCar;
	
	@Column(nullable = false, length = 70)
	private String modelCar;
	
	@Column(nullable = false, length = 70)
	private String colorCar;
	
	@Column(nullable = false)
	private LocalDate registrationDate;
	
	@Column(nullable = false, length = 130)
	private String reponsibleName;
	
	@Column(nullable = false, length = 30)
	private String apartament;
	
	@Column(nullable = false, length = 30)
	private String block;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getParkingSpotNumber() {
		return parkingSpotNumber;
	}

	public void setParkingSpotNumber(String parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;
	}

	public String getLicensePlateCar() {
		return LicensePlateCar;
	}

	public void setLicensePlateCar(String licensePlateCar) {
		LicensePlateCar = licensePlateCar;
	}

	public String getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	public String getModelCar() {
		return modelCar;
	}

	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	public String getColorCar() {
		return colorCar;
	}

	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getReponsibleName() {
		return reponsibleName;
	}

	public void setReponsibleName(String reponsibleName) {
		this.reponsibleName = reponsibleName;
	}

	public String getApartament() {
		return apartament;
	}

	public void setApartament(String apartament) {
		this.apartament = apartament;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
