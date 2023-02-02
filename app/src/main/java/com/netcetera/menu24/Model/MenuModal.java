package com.netcetera.menu24.Model;

public class MenuModal {
    private String menuName;
    private String menuInhalt;
    private String menuPrice;
    private int id;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuInhalt() {
        return menuInhalt;
    }

    public void setMenuInhalt(String menuInhalt) {
        this.menuInhalt = menuInhalt;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuModal(String menuName, String menuInhalt, String menuPrice) {
        this.menuName = menuName;
        this.menuInhalt = menuInhalt;
        this.menuPrice = menuPrice;
    }
}
