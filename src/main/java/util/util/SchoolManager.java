//Made this file into a util package
package util;

//Imported needed package and classes
import java.util.HashMap;
import java.util.Map;

public class SchoolManager {
    //This is where student and teacher accounts are stored
    private Map<String, String> studentAccounts;
    private Map<String, String> teacherAccounts;

    public SchoolManager() {
        studentAccounts = new HashMap<>();
        teacherAccounts = new HashMap<>();
    }

    //Registers student account with ID and password
    public boolean registerStudent(String id, String password) {
        if (!studentAccounts.containsKey(id)) {
            studentAccounts.put(id, password);
            return true;
        }
        return false;
    }

    //Registers teacher account with ID and password
    public boolean registerTeacher(String id, String password) {
        if (!teacherAccounts.containsKey(id)) {
            teacherAccounts.put(id, password);
            return true;
        }
        return false;
    }

    //Checks if there is a ID that exist and validates its password
    public boolean isStudentLoginValid(String id, String password) {
        return studentAccounts.containsKey(id) && studentAccounts.get(id).equals(password);
    }

    public boolean isTeacherLoginValid(String id, String password) {
        return teacherAccounts.containsKey(id) && teacherAccounts.get(id).equals(password);
    }
}
