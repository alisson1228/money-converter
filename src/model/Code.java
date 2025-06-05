package model;

public class Code {
    private String code;
    private final String name;

    public Code(String cod, String name) {
        if(cod.length() == 3) {
            this.code = cod;
        }
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
