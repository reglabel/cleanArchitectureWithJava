public class Email {
    // VALUE OBJECT -> não possui um atributo identificador - nesse caso, se eu tiver duas instâncias com o mesmo endereço considero que é o mesmo email.
    private String address;

    public Email(String address) {
        if (address == null || !address.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
