package ony.store.dao;

import ony.store.entities.Car;

public interface IDAOFactory {

   CarDAO getCarDAO();

}
