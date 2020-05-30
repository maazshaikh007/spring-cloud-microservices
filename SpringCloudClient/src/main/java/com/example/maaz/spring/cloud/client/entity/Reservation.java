package com.example.maaz.spring.cloud.client.entity;



public class Reservation {

    private String reservationName;

    public Reservation() {
    }

    @Override
    public String toString() {
        return "Reservation{" +
               
                ", reservationName='" + reservationName + '\'' +
                '}';
    }

    public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }
    
    public String getReservationName() {
        return reservationName;
    }

}
