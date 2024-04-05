package database;

import entities.Pasajero;

import java.util.List;

public interface PasajeroRepository {
    Pasajero insert(Pasajero pasajero);

    boolean update(Pasajero pasajero);

    boolean delete(Pasajero pasajero);

    Pasajero findById(int idPasajero);

    List<Pasajero> findAll();
}
