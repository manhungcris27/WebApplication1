package murach.data;

import java.io.*;
import java.util.*;
import murach.business.User;

public class UserIO {

    public static User getUser(String emailAddress, String filename) {
        try {
            File file = new File(filename);
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                String[] columns = line.split("\t");
                if (columns[0].equalsIgnoreCase(emailAddress)) {
                    User user = new User();
                    user.setEmail(columns[0]);
                    user.setFirstName(columns[1]);
                    user.setLastName(columns[2]);
                    in.close();
                    return user;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static void add(User user, String filename) {
        try {
            File file = new File(filename);
            PrintWriter out = new PrintWriter(new FileWriter(file, true));

            out.println(user.getEmail() + "\t"
                    + user.getFirstName() + "\t"
                    + user.getLastName());

            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
