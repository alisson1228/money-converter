package model;

public class Code {
    private String code;
    private String name;

    public Code(String cod, String name) {
        if(cod.length() == 3) {
            this.code = cod;
        }
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if(code.length() == 3) {
            this.code = code;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
