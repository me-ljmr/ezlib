/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.data;

import ezlib.beans.Author;
import ezlib.beans.Book;
import ezlib.beans.Member;
import ezlib.exception.EZException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAUMIL
 */
public class MemberDAO {
    private Connection con;
    public MemberDAO(Connection con){
        this.con = con;
    }
    
    public List<Member> getMembers(){
    
        List<Member> m=new ArrayList<Member>();
        Member member=null;
//          <td>${member.memberId}</td>
//                            <td>${member.firstName}</td>
//                            <td>${member.lastName}</td>
//                            <td>${member.email}</td>
//                            <td>${member.Password}</td>
//                            <td>${member.gender}</td>
//                            <td>${member.status}</td>
//                            <td>${member.profilePicUrl}</td>
//                            <td>${member.cellNumber}</td>
//                            <td>${member.address}</td>
//                            <td>${member.postalCode}</td>
//                            <td>${member.balance}</td>
//                            <td>${member.libraryCardNumber}</td>
//                            <td>${member.verficationStatus}</td>
//                            <td>${member.confirmationCode}</td>
         try {
             PreparedStatement pstmt;
             pstmt = con.prepareStatement("select * from ezlib_members");
             ResultSet rs =pstmt.executeQuery();
             while(rs.next()){
                 member = new Member();
                 member.setMemberId(rs.getLong("member_id"));
                 member.setFirstName(rs.getString("first_name"));
                 member.setLastName(rs.getString("last_name"));
                 member.setEmail(rs.getString("email"));
                 member.setPassword(rs.getString("password"));
                 member.setGender(rs.getString("gender"));
                 member.setStatus(rs.getInt("status"));
                 member.setProfilePicUrl(rs.getString("profile_pic_url"));
                 member.setCellNumber(rs.getString("cell_number"));
                 member.setAddress(rs.getString("address"));
                 member.setPostalCode(rs.getString("postal_code"));
                 member.setBalance(rs.getDouble("balance"));
                 member.setLibraryCardNumber(rs.getInt("library_card_number"));
                 member.setVerficationStatus(rs.getString("verification_status"));
                 member.setConfirmationCode(rs.getString("confirmation_code"));
                 
                
                 m.add(member);
             }
             rs.close();
             pstmt.close(); 
             
         } catch (SQLException ex) {
              m=null;
         }
         finally{
             return m;
         }
    }
    
    public void insertMember(Member m) throws EZException {
   // insert into EZLIB_MEMBERS (first_name,last_name,email,password,gender,status,profile_pic_url,cell_number,address,postal_code,balance,library_card_number,verification_status,confirmation_code) values ('saumil','surati','saumil03@gmail.com','saumil','m',12345,'image',1234567890,'vbfhjbvjd','m9w6x8',23,123456,'a','success');

    try {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement(" insert into EZLIB_MEMBERS "
                    + "(first_name,last_name,email,password,gender,"
                    + "status,profile_pic_url,cell_number,address,"
                    + "postal_code,balance,library_card_number,"
                    + "verification_status,confirmation_code) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)\n" +
"");
            pstmt.setString(1, m.getFirstName());
            pstmt.setString(2, m.getLastName());
            pstmt.setString(3, m.getEmail());
            pstmt.setString(4, m.getPassword());
            pstmt.setString(5, m.getGender());
            pstmt.setInt(6, m.getStatus());
            pstmt.setString(7, m.getProfilePicUrl());
            pstmt.setString(8, m.getCellNumber());
            pstmt.setString(9, m.getAddress());
            pstmt.setString(10, m.getPostalCode());
            pstmt.setDouble(11, 0);
   pstmt.setInt(12, 123456);
            pstmt.setString(13, "s");
            pstmt.setString(14, "success");
        
// pstmt.setInt(12, m.getLibraryCardNumber());
           // pstmt.setString(13, m.getVerficationStatus());
           // pstmt.setString(14, m.getConfirmationCode());

            pstmt.executeQuery();
           
           

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
