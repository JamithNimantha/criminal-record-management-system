package lk.ijse.gdse.common.service;

import lk.ijse.gdse.common.observer.Subject;
import lk.ijse.gdse.common.reservation.Reservation;

import java.rmi.Remote;

public interface SuperService extends Remote, Reservation, Subject {
}
