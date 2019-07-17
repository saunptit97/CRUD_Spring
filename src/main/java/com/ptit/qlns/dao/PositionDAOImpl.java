package com.ptit.qlns.dao;


import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;
import com.ptit.qlns.config.Config;
import com.ptit.qlns.model.Position;

public class PositionDAOImpl implements PositionDAO {

	@Override
	public ArrayList<Position> getAll() throws ClassNotFoundException, SQLException {
		ArrayList<Position> positions = new ArrayList<>();
		String query = "SELECT * from position";
        Statement st = Config.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            Position position = new Position();
            position.setId(rs.getInt("id"));
            position.setName(rs.getString("name"));
            position.setDescription(rs.getString("description"));
            positions.add(position);
        }
		return positions;
	}

	@Override
	public void addPosition(Position position) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO `position`(`name`, `description`) values(?,?)";
		PreparedStatement preparedStmt = (PreparedStatement) Config.getConnection().prepareStatement(query);
		
		preparedStmt.setString(1, position.getName());
		preparedStmt.setString(2, position.getDescription());
		System.out.println(preparedStmt);
		preparedStmt.execute();
		
	}

	@Override
	public Position getPositionById(int id) throws ClassNotFoundException, SQLException {
		String query = "SELECT * from position WHERE id = " + id;
		Statement st = Config.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            Position position = new Position();
            position.setId(rs.getInt("id"));
            position.setName(rs.getString("name"));
            position.setDescription(rs.getString("description"));
            return position;
        }
		return null;
		
	}

	@Override
	public void deletePosition(int id) throws ClassNotFoundException, SQLException {
		String query = "DELETE from position WHERE id = ?" ;
		PreparedStatement stmt = (PreparedStatement) Config.getConnection().prepareStatement(query); 
	    stmt.setInt(1, id);
	    stmt.executeUpdate();
	}

	@Override
	public void updatePosition(Position position) throws ClassNotFoundException, SQLException {
		  String query = "update position set name = ? , description = ? where id = ?";
	      PreparedStatement preparedStmt = (PreparedStatement) Config.getConnection().prepareStatement(query);
	      preparedStmt.setString(1, position.getName());
	      preparedStmt.setString(2, position.getDescription());
	      preparedStmt.setInt(3, position.getId());
	      preparedStmt.executeUpdate();
	}
}
