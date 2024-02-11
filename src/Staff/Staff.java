package Staff;

public class Staff {
    private String username;
    private String password;
    private int staffId;
    private String phoneNumber;

    public Staff(String username, String password, int staffId, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.staffId = staffId;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

