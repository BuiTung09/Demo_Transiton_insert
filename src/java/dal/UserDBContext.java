/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.auth.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.auth.Feature;
import model.auth.Role;

/**
 *
 * @author sonnt-local
 */
public class UserDBContext extends DBContext<User> {

    public ArrayList<Role> getRoles(String username) {
        PreparedStatement stm = null;
        ArrayList<Role> roles = new ArrayList<>();
        try {
            String sql = "SELECT r.rid,r.rname,f.fid,f.fname,f.[url] FROM [User] u \n"
                    + "	INNER JOIN UserRole ur ON u.username = ur.username\n"
                    + "	INNER JOIN [Role] r ON r.rid = ur.rid\n"
                    + "	INNER JOIN RoleFeature rf ON rf.rid = r.rid\n"
                    + "	INNER JOIN Feature f ON f.fid = rf.fid\n"
                    + "WHERE u.username = ? ";
            
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            Role crole = new Role();
            crole.setId(-1);
            while(rs.next())
            {
                int rid = rs.getInt("rid");
                if(rid != crole.getId())
                {
                    crole = new Role();
                    crole.setId(rid);
                    crole.setName(rs.getString("rname"));
                    roles.add(crole);
                }
                
                Feature f = new Feature();
                f.setId(rs.getInt("fid"));
                f.setName(rs.getString("fname"));
                f.setUrl(rs.getString("url"));
                
                f.setRoles(roles);
                crole.getFeatures().add(f);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return roles;
    }

    public User get(String username, String password) {
        User user = null;
        PreparedStatement stm = null;
        try {
            String sql = "SELECT [username],[password],[displayname] FROM [User]\n"
                    + "WHERE [username] = ? AND [password] = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setDisplayname(rs.getString("displayname"));
                user.setUsername(username);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    @Override
    public void insert(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
