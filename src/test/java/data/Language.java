package data;

public enum Language {
    RU ("Рус","Курс валют"),
    //UZ ("O‘zb","Valyuta kurslari"),
    En ("Eng","Exchange rates");

    public final String buttonText;
    public final String description;

    Language(String buttonText, String description) {
        this.buttonText = buttonText;
        this.description = description;
    }
}
