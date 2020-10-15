package Classes;

public class departments {
    private int id_departments;
    private String name;
    private String typeOfDepartment;
    private int sellerId;

    public void setId_departments(int id_departments) {
        this.id_departments = id_departments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSellerId(int sellersId) {
        this.sellerId = sellerId;
    }

    public void setTypeOfDepartment(String typeOfDepartment) {
        this.typeOfDepartment = typeOfDepartment;
    }

    public int getId_departments() {
        return id_departments;
    }

    public String getName() {
        return name;
    }

    public int getSellersId() {
        return sellerId;
    }

    public String getTypeOfDepartment() {
        return typeOfDepartment;
    }
}
