package task5.dateFormats.constants;

public enum Countries {
    JAPAN("dd-MM-yyyy"),
    DENMARK("dd-MM-yyyy"),
    RUSSIA("dd.MM.yyyy");

    private String dateFormat;
    Countries(String dateFormat){
        this.dateFormat = dateFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }
}
