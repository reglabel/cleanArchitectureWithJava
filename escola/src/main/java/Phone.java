public class Phone {
    private String number;

    public Phone(String number) {
        if (number == null || !number.matches("^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
