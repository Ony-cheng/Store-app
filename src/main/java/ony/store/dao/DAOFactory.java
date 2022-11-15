package ony.store.dao;

public class DAOFactory implements IDAOFactory{

   private DAOFactory(){

   }

    @Override
    public CarDAO getCarDAO() {
        return null;
    }
}
