package online.app.eracodes.iownservice.model;

import java.sql.Timestamp;

public interface UserLoginResult {
    boolean isSuccess();
    String getMessage();
    Long getIdentifier();
    Timestamp getLastLogin();
    String getUserRole();

    default String getFormattedLastLogin() {
        return getLastLogin() != null ? getLastLogin().toString() : "N/A";
    }
}
