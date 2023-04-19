import java.util.*;

class NrTelefoniczny implements Comparable<NrTelefoniczny> {
    private String codeNumber;
    private String phoneNumber;


    public NrTelefoniczny(String inputedCodeNumber, String inputedPhoneNumber) {
        this.phoneNumber = inputedPhoneNumber;
        this.codeNumber = inputedCodeNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCodeNumber(String inputedCodeNumber) {
        this.codeNumber = inputedCodeNumber;
    }

    public void setPhoneNumber(String inputedPhoneNumber) {
        this.phoneNumber = inputedPhoneNumber;
    }

    @Override
    public int compareTo(NrTelefoniczny o) {
        int isCodeTheSame = codeNumber.compareTo(o.codeNumber);
        if (isCodeTheSame == 0) {
            return phoneNumber.compareTo(o.phoneNumber);
        }
        return isCodeTheSame;
    }
}

abstract class Wpis {
    abstract void opis();
}

class Osoba extends Wpis {
    private final NrTelefoniczny numberInformation;
    private final String name;
    private final String surname;
    private final String adress;

    public Osoba(String name, String surname, String adress, NrTelefoniczny numberInformation) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.numberInformation = numberInformation;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public NrTelefoniczny getPhoneNumber() {
        return numberInformation;
    }
    public NrTelefoniczny getCodeNumber() {
        return numberInformation;
    }
    @Override
    void opis() {
        System.out.println(name + " " + surname + " " + adress + " " + "+" + numberInformation.getCodeNumber() + " " + numberInformation.getPhoneNumber());

    }
}

class Firma extends Wpis {
    String companyName;
    String companyAdress;
    NrTelefoniczny companyPhoneNumber;

    public Firma(String inputedCompanyName, String inputedCompanyAdress, NrTelefoniczny inputedCompanyPhoneNumber ){
        this.companyName = inputedCompanyName;
        this.companyAdress = inputedCompanyAdress;
        this.companyPhoneNumber = inputedCompanyPhoneNumber;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getCompanyAdress(){
        return companyAdress;
    }

    public NrTelefoniczny getCompanyPhoneNumber(){
        return companyPhoneNumber;
    }


    @Override
    void opis() {
        System.out.println(companyName + " " + companyAdress + " " + "+" + companyPhoneNumber.getCodeNumber() + " " + companyPhoneNumber.getPhoneNumber());
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        NrTelefoniczny number1 = new NrTelefoniczny("48", "123 456 789");
        NrTelefoniczny number2 = new NrTelefoniczny("48", "696 969 696");

        Osoba staryDziad = new Osoba("Jaroslaw", "Kaczynski", "Swietokrzyska 17", number1);
        staryDziad.opis();
        Firma macDonalds = new Firma("MacDonalds", "Whatever Street 2137", number2);
        macDonalds.opis();
    }
}
























