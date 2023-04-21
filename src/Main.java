import java.util.TreeMap;

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
    public abstract void opis();
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
    public void opis() {
        System.out.println("(+" + numberInformation.getCodeNumber() + ") " + numberInformation.getPhoneNumber() + " " + name + " " + surname + " " + adress);

    }
}

class Firma extends Wpis {
    String companyName;
    String companyAdress;
    NrTelefoniczny phoneNumber;

    public Firma(String inputedCompanyName, String inputedCompanyAdress, NrTelefoniczny inputedCompanyPhoneNumber) {
        this.companyName = inputedCompanyName;
        this.companyAdress = inputedCompanyAdress;
        this.phoneNumber = inputedCompanyPhoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public NrTelefoniczny getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public void opis() {
        System.out.println("(+" + phoneNumber.getCodeNumber() + ") " + phoneNumber.getPhoneNumber() + " " + companyName + " " + companyAdress);
    }
}

public class Main {
    public static void main(String[] args) {

        //TreeMap<NrTelefoniczny, Wpis> phoneBook = new TreeMap<>();
        TreeMap<NrTelefoniczny, Wpis> phoneBook = new TreeMap<>();

        NrTelefoniczny number1 = new NrTelefoniczny("48", "123 456 789");
        NrTelefoniczny number2 = new NrTelefoniczny("48", "543 678 324");
        NrTelefoniczny number3 = new NrTelefoniczny("48", "340 586 235");

        NrTelefoniczny number4 = new NrTelefoniczny("48", "987 654 321");
        NrTelefoniczny number5 = new NrTelefoniczny("48", "913 721 372");
        NrTelefoniczny number6 = new NrTelefoniczny("48", "938 518 735");


        Osoba person1 = new Osoba("Jaroslaw", "Kaczynski", "Swietokrzyska 17", number1);
        Osoba person2 = new Osoba("Zbigniew", "Stonoga", "Grota Roweckiego 3", number2);
        Osoba person3 = new Osoba("Jaroslaw", "Kaczynski", "Wiejska 9", number3);

        //person1.opis();
        Firma company1 = new Firma("c1", "s1", number4);
        Firma company2 = new Firma("c2", "s2", number5);
        Firma company3 = new Firma("c3", "s3", number6);

        //company1.opis();
        phoneBook.put(person1.getPhoneNumber(), person1);
        phoneBook.put(person2.getPhoneNumber(), person2);
        phoneBook.put(person3.getPhoneNumber(), person3);
        phoneBook.put(company1.getPhoneNumber(), company1);
        phoneBook.put(company2.getPhoneNumber(), company2);
        phoneBook.put(company3.getPhoneNumber(), company3);


        for (NrTelefoniczny nr : phoneBook.keySet()) {
            Wpis wpis = phoneBook.get(nr);
            wpis.opis();
        }


    }
}
























