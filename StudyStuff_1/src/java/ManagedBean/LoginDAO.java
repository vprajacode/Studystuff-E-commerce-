/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;


/**
 *
 * @author vpraj
 */
@Named(value = "loginDAO")

public class LoginDAO {

    public static Integer validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("Select userId from user where userName = ? and password = ? ");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return rs.getInt(1);
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return 0;
		} finally {
			DataConnect.close(con);
		}
		return 0;
	}
    }
    

