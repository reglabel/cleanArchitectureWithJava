import java.util.ArrayList;
import java.util.List;

public class Student {
    // ENTIDADE -> tenho um atributo que é único e permite diferenciar entidades.
    private CPF cpf;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<Phone>();

    public void addPhone(Phone phone){
        this.phones.add(phone);
    }
}
