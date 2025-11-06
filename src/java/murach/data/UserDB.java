/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.data;

import murach.business.User;

/**
 *
 * @author hungc
 */
public class UserDB {

    public static void insert(User user) {
        System.out.println("Save:"+user.getEmail());
    }
    
}
