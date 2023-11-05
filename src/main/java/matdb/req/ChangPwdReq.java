package matdb.req;


public class ChangPwdReq {
    private String username;
    private String newPassword;

    public  ChangPwdReq(){}

    public ChangPwdReq(String username, String newPassword) {
        this.username = username;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ChangPwdReq{" +
                "username='" + username + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
