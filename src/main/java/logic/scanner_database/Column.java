package logic.scanner_database;

public class Column {
    private String name;
    private String type;
    private int size;
    private boolean isNullable;
    private boolean isAutoIncrement;
    private Object defaultValue;
    private int position;

    public Column(String name, String type, int size, boolean isNullable, boolean isAutoIncrement, Object defaultValue,
            int position) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.isNullable = isNullable;
        this.isAutoIncrement = isAutoIncrement;
        this.defaultValue = defaultValue;
        this.position = position;
    }

    public Column(String name, String type, boolean isNullable) {
        this.name = name;
        this.type = type;
        this.isNullable = isNullable;
    }

    public Column(String name, String type, int size, boolean isNullable, boolean isAutoIncrement) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.isNullable = isNullable;
        this.isAutoIncrement = isAutoIncrement;
        this.defaultValue = null;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public boolean isAutoIncrement() {
        return isAutoIncrement;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public int getPosition() {
        return position;
    }
}