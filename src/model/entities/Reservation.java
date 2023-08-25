package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {	
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
    /*Método para calcular a diferença de datas em número de dias*/
	public long duration() {
		//a variavel 'diff' tipo long recebe a data em milesegundos atraves do método 'getTime()'
		long diff = checkOut.getTime() - checkIn.getTime();
		//o 'TimeUnit.DAYS.convert()' converte os milesegundos no objeto 'diff' para dias. 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		return "Room " 
			+ roomNumber 
			+ ", checkIn: " 
	        + sdf.format(checkIn) 
			+ ", checkOut: " 
			+ sdf.format(checkOut)
			+ ", " + duration() + " nigths";
	}
	
}
