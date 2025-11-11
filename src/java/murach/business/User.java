package murach.business;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String hear;
    private String receiveCDs;
    private String receiveEmails;
    private String contactMethod;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        dob = "";
        hear = "";
        receiveCDs = "";
        receiveEmails = "";
        contactMethod = "";
    }

    public User(String firstName, String lastName, String email, 
                String dob, String hear, String receiveCDs, 
                String receiveEmails, String contactMethod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.hear = hear;
        this.receiveCDs = receiveCDs;
        this.receiveEmails = receiveEmails;
        this.contactMethod = contactMethod;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getHear() { return hear; }
    public void setHear(String hear) { this.hear = hear; }

    public String getReceiveCDs() { return receiveCDs; }
    public void setReceiveCDs(String receiveCDs) { this.receiveCDs = receiveCDs; }

    public String getReceiveEmails() { return receiveEmails; }
    public void setReceiveEmails(String receiveEmails) { this.receiveEmails = receiveEmails; }

    public String getContactMethod() { return contactMethod; }
    public void setContactMethod(String contactMethod) { this.contactMethod = contactMethod; }
}
