package Logica.ScannerDatabase;

public class Column {
    private String name;
    private String type;
    private int size;
    private boolean isNullable;

    public Column(String name, String type, int size, boolean isNullable) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.isNullable = isNullable;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public boolean isNullable() {
        return isNullable;
    }
    /*
    @Override
    public String toString() {
        return "Column{name='" + name + "', type='" + type + "', size=" + size + ", isNullable=" + isNullable + '}';
    } */
}
