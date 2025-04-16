package lib;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo {
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private boolean isForeigner;
    private boolean gender; // true = Laki-laki, false = Perempuan

    private String spouseName;
    private String spouseIdNumber;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public EmployeeInfo(String firstName, String lastName, String idNumber, String address, boolean isForeigner, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.isForeigner = isForeigner;
        this.gender = gender;
        this.childNames = new ArrayList<>();
        this.childIdNumbers = new ArrayList<>();
    }

    public void setSpouse(String name, String id) {
        this.spouseName = name;
        this.spouseIdNumber = id;
    }

    public boolean hasSpouse() {
        return spouseName != null && !spouseName.isEmpty()
                && spouseIdNumber != null && !spouseIdNumber.isEmpty();
    }

    public void addChild(String name, String idNumber) {
        this.childNames.add(name);
        this.childIdNumbers.add(idNumber);
    }

    public int getNumberOfChildren() {
        return childIdNumbers.size();
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public boolean isMale() {
        return gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public List<String> getChildIdNumbers() {
        return childIdNumbers;
    }
}
