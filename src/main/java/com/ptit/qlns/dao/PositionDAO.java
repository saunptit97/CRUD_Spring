package com.ptit.qlns.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ptit.qlns.model.*;

public interface PositionDAO {
	
	ArrayList<Position> getAll() throws ClassNotFoundException, SQLException;
	
	public void addPosition(Position position) throws ClassNotFoundException, SQLException;
	
	public Position getPositionById(int id) throws ClassNotFoundException, SQLException;
	
	public void deletePosition(int id) throws ClassNotFoundException, SQLException;
	
	public void updatePosition(Position position) throws ClassNotFoundException, SQLException;
	
}
