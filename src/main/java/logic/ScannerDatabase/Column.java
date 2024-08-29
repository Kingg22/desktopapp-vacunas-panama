package Logica.ScannerDatabase;

public class Column {
    private final String name;
    private final String type;
    private int size;
    private boolean isNullable;

    public Column(String name, String type, int size, boolean isNullable) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.isNullable = isNullable;
    }

    public Column(String name, String type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
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
}