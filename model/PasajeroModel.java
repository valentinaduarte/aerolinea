package model;

import database.ConfigDb;
import database.PasajeroRepository;
import entities.Pasajero;

import javax.swing.*;
import java.sql.*;
import java.util.List;

public class PasajeroModel implements PasajeroRepository {
    @Override
    public Pasajero insert(Pasajero pasajero) {

        try {
            Connection conexion = ConfigDb.getInstance().getConnection();
            String sql = "INSERT INTO pasajero (nombre, apellido, documento_identidad) VALUES (?, ?, ?)";

            PreparedStatement sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setString(1, pasajero.getNombre());
            sentencia.setString(2, pasajero.getApellido());
            sentencia.setString(3, pasajero.getDocumentoIdentidad());

            sentencia.execute();

            try (ResultSet generatedKeys = sentencia.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    pasajero.setIdPasajero(idGenerado);
                } else {
                    throw new SQLException("No se pudo obtener el id para el pasajero");
                }
            }

            JOptionPane.showMessageDialog(null, "El pasajero se insertó correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error añadiendo pasajero" + e.getMessage());
        }

        ConfigDb.getInstance().closeConnection();

        return pasajero;
    }

    @Override
    public boolean update(Pasajero pasajero) {
        return false;
    }

    @Override
    public boolean delete(Pasajero pasajero) {
        return false;
    }

    @Override
    public Pasajero findById(int idPasajero) {
        return null;
    }

    @Override
    public List<Pasajero> findAll() {
        return null;
    }
}
