package util;

import java.util.HashMap;
import java.util.Map;

public class SchoolManager {
    private Map<String, String> studentAccounts;
    private Map<String, String> teacherAccounts;

    public SchoolManager() {
        studentAccounts = new HashMap<>();
        teacherAccounts = new HashMap<>();
    }

    public boolean registerStudent(String id, String password) {
        if (!studentAccounts.containsKey(id)) {
            studentAccounts.put(id, password);
            return true;
        }
        return false;
    }

    public boolean registerTeacher(String id, String password) {
        if (!teacherAccounts.containsKey(id)) {
            teacherAccounts.put(id, password);
            return true;
        }
        return false;
    }

    public boolean isStudentLoginValid(String id, String password) {
        return studentAccounts.containsKey(id) && studentAccounts.get(id).equals(password);
    }

    public boolean isTeacherLoginValid(String id, String password) {
        return teacherAccounts.containsKey(id) && teacherAccounts.get(id).equals(password);
    }
}
