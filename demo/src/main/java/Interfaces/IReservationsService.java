package Interfaces;

import Models.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface IReservationsService<R> {
    void addReservation(Reservation reservation)throws SQLException;
    void removeReservation(int id)throws SQLException;
    void updateReservation(R r)throws SQLException;
    R getReservationById(int id)throws SQLException;
    List<R> getAllReservations()throws SQLException;

    Reservation selectAll();

    void deleteOne(Reservation selectedReservation);
}
