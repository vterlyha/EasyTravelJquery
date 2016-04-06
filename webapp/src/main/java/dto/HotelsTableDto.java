package dto;

import entity.Hotel;

public class HotelsTableDto {
	
	private Hotel hotel;
	
	private Object numOfClients;
	
	private Object avgStayLength;
	
	public HotelsTableDto() {}

	public HotelsTableDto(Hotel hotel, Object numOfClients, Object avgStayLength) {
		super();
		this.hotel = hotel;
		this.numOfClients = numOfClients;
		this.avgStayLength = avgStayLength;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Object getNumOfClients() {
		return numOfClients;
	}

	public void setNumOfClients(Object numOfClients) {
		this.numOfClients = numOfClients;
	}

	public Object getAvgStayLength() {
		return avgStayLength;
	}

	public void setAvgStayLength(Object avgStayLength) {
		this.avgStayLength = avgStayLength;
	}

}
