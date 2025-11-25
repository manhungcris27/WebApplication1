package murach.business;

import java.io.Serializable;

public class UserSurvey implements Serializable {

    // 6 thuộc tính cho Bài tập 6-2
    private String firstName;
    private String lastName;
    private String email;
    private String heardFrom; // Tương ứng với 'hear' trong form
    private String updates;   // Tương ứng với 'receiveEmails' trong form
    private String contactVia; // Tương ứng với 'contactMethod' trong form

    // Constructor mặc định (Không tham số)
    public UserSurvey() {
        firstName = "";
        lastName = "";
        email = "";
        heardFrom = "";
        updates = "";
        contactVia = "";
    }

    // Constructor có tham số cho 6 thuộc tính
    public UserSurvey(String firstName, String lastName, String email, 
                String heardFrom, String updates, String contactVia) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.heardFrom = heardFrom;
        this.updates = updates;
        this.contactVia = contactVia;
    }

    // --- Getters và Setters cho 6 thuộc tính ---

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Tương ứng với 'Heard From'
    public String getHeardFrom() { return heardFrom; }
    public void setHeardFrom(String heardFrom) { this.heardFrom = heardFrom; }

    // Tương ứng với 'Updates' (Dùng cho logic JSTL)
    public String getUpdates() { return updates; }
    public void setUpdates(String updates) { this.updates = updates; }

    // Tương ứng với 'Contact Via'
    public String getContactVia() { return contactVia; }
    public void setContactVia(String contactVia) { this.contactVia = contactVia; }
}