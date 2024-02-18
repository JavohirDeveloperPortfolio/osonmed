package org.example.modul;

public class Region {
    private int id;
    private String nameUz;
    private String nameRu;

    public Region(int id, String nameUz, String nameRu) {
        this.id = id;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUz() {
        return nameUz;
    }

    public void setNameUz(String nameUz) {
        this.nameUz = nameUz;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }
}
