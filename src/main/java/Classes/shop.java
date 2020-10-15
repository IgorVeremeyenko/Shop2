package Classes;

public class shop {
    private int id_shop;
    private String name;
    private String typeOfShop;
    private int departmentId;

    public void setId_shop(int id_shop) {
        this.id_shop = id_shop;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeOfShop(String typeOfShop) {
        this.typeOfShop = typeOfShop;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getId_shop() {
        return id_shop;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfShop() {
        return typeOfShop;
    }
}
