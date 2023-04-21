import java.util.Map;
import java.util.TreeMap;

class NrTelefoniczny implements Comparable<NrTelefoniczny> {
    private final String codeNumber;
    private final String phoneNumber;
    public NrTelefoniczny(String inputedCodeNumber, String inputedPhoneNumber) {
        this.phoneNumber = inputedPhoneNumber;
        this.codeNumber = inputedCodeNumber;
    }
    String getCodeNumber() {
        return codeNumber;
    }

    String getPhoneNumber() {
        return phoneNumber;
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
    abstract int compareAddresses(Wpis o);
    abstract Address getAddress();
}

class Osoba extends Wpis {
    private final NrTelefoniczny numberInformation;
    private final String name;
    private final String surname;
    private final Address address;
    public Osoba(String name, String surname, Address address,
                 NrTelefoniczny numberInformation) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.numberInformation = numberInformation;
    }
    public Address getAddress() {
        return address;
    }
    public NrTelefoniczny getPhoneNumber() {
        return numberInformation;
    }
    @Override
    public void opis() {
        System.out.println("(+" + numberInformation.getCodeNumber() + ") " +
                numberInformation.getPhoneNumber() + " | " + name + " " +
                surname + " | " + address.getStreet() + " " +
                address.getTown() + " ul " + address.getStreet() +" "+
                address.getHomeNumber() +" "+ address.getPostCode() +" "+
                address.getVoivodeship());
    }
    @Override
    public int compareAddresses(Wpis o) {
        return address.compareTo(o.getAddress());
    }
}
class Firma extends Wpis {
    String companyName;
    Address address;
    NrTelefoniczny phoneNumber;

    public Firma(String inputedCompanyName, Address inputedCompanyAddress,
                 NrTelefoniczny inputedCompanyPhoneNumber) {
        this.companyName = inputedCompanyName;
        this.address = inputedCompanyAddress;
        this.phoneNumber = inputedCompanyPhoneNumber;
    }
    public NrTelefoniczny getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    Address getAddress() {
        return address;
    }
    @Override
    public void opis() {
        System.out.println("(+" + phoneNumber.getCodeNumber() + ") " +
                phoneNumber.getPhoneNumber() + " | " + companyName + " " +
                address.getStreet() + " " +
                address.getTown() + " ul " + address.getStreet() +" "+
                address.getHomeNumber() +" "+ address.getPostCode() +" "+
                address.getVoivodeship());
    }
    @Override
    public int compareAddresses(Wpis o) {
        return address.compareTo(o.getAddress());
    }
}
class Address implements Comparable<Address> {
    private final String street;
    private final int homeNumber;
    private final String town;
    private final int postCode;
    private final String voivodeship;

    Address(String street, int homeNumber, String town,
            int postCode, String voivodeship) {
        this.street = street;
        this.homeNumber = homeNumber;
        this.town = town;
        this.postCode = postCode;
        this.voivodeship = voivodeship;
    }
    public String getStreet() {
        return street;
    }
    public Integer getHomeNumber() {
        return homeNumber;
    }
    public String getTown() {
        return town;
    }
    public Integer getPostCode() {
        return postCode;
    }
    public String getVoivodeship() {
        return voivodeship;
    }
    @Override
    public int compareTo(Address a) {
        return street.compareTo(a.getStreet());
    }
}
public class Main {
    public static void main(String[] args) {
        try {
            TreeMap<NrTelefoniczny, Wpis> phoneBook = new TreeMap<>();
            TreeMap<NrTelefoniczny, Wpis> newPhoneBook = new TreeMap<>();
            phoneBook = putData(phoneBook);

            System.out.println("                 --DISPLAY--");
            show(phoneBook);
            System.out.println("        --REMOVED IDENTICAL STREETS--");

            newPhoneBook = removeIdenticalAddess(phoneBook);
            show(newPhoneBook);

        } catch (java.lang.ClassCastException e) {
            System.out.println("There is error in Class casting. Check the types\n");
            e.printStackTrace(System.out);
        } catch (NullPointerException a) {
            System.out.println("There is error with null returning\n");
            a.printStackTrace(System.out);
        }
    }

    static TreeMap<NrTelefoniczny, Wpis> removeIdenticalAddess(TreeMap<NrTelefoniczny, Wpis> phoneBook) {
        boolean duplicated = false;
        TreeMap<NrTelefoniczny, Wpis> newPhoneBook = new TreeMap<>();

        for (Map.Entry<NrTelefoniczny, Wpis> nr1 : phoneBook.entrySet()) {
            Wpis wpis1 = nr1.getValue();
            NrTelefoniczny key1 = nr1.getKey();
            duplicated = false;
            for (Map.Entry<NrTelefoniczny, Wpis> nr2 : phoneBook.entrySet()) {
                Wpis wpis2 = nr2.getValue();
                NrTelefoniczny key2 = nr2.getKey();

                if ((wpis1.compareAddresses(wpis2) == 0) && nr1 != nr2) { //|| wpis2.compareAddresses(wpis1) == 0

                    duplicated = true;
                    break;
                }
            }
            if (!duplicated)
                newPhoneBook.put(key1, wpis1);
        }
        return newPhoneBook;
    }
    static void show(TreeMap<NrTelefoniczny, Wpis> phoneBook) {

        for (NrTelefoniczny nr : phoneBook.keySet()) {
            Wpis wpis = phoneBook.get(nr);
            wpis.opis();
        }
    }
    static TreeMap<NrTelefoniczny, Wpis> putData(TreeMap<NrTelefoniczny, Wpis> phoneBook) {

        NrTelefoniczny number1 = new NrTelefoniczny("48", "123 456 789");
        NrTelefoniczny number2 = new NrTelefoniczny("48", "543 678 324");
        NrTelefoniczny number3 = new NrTelefoniczny("48", "340 586 235");

        NrTelefoniczny number4 = new NrTelefoniczny("48", "987 654 321");
        NrTelefoniczny number5 = new NrTelefoniczny("48", "913 721 372");
        NrTelefoniczny number6 = new NrTelefoniczny("48", "938 518 735");

        Address address1 = new Address("Swietokrzyska", 234, "Pabianice", 95200, "Lodzkie");
        Address address2 = new Address("Grota Roweckiego", 1, "Pabianice", 95200, "Lodzkie");
        Address address3 = new Address("Pabianicka", 12, "Lodz", 95200, "Lodzkie");
        Address address4 = new Address("Marii Sklodowskiej-Curie", 17, "Pabianice", 95200, "Lodzkie");
        Address address5 = new Address("Marii Konopnickiej", 64, "Pabianice", 95200, "Lodzkie");
        Address address6 = new Address("Mariana Jaracza", 6, "Lodz", 95200, "Lodzkie");

        Osoba person1 = new Osoba("Jaroslaw", "Kaczynski", address1, number1);
        Osoba person2 = new Osoba("Zbigniew", "Stonoga", address1, number2);
        Osoba person3 = new Osoba("Zbigniew", "Ziobro", address3, number3);

        Firma company1 = new Firma("Accenture", address4, number4);
        Firma company2 = new Firma("MacDonalds", address5, number5);
        Firma company3 = new Firma("T-Mobile", address6, number6);

        phoneBook.put(person1.getPhoneNumber(), person1);
        phoneBook.put(person2.getPhoneNumber(), person2);
        phoneBook.put(person3.getPhoneNumber(), person3);
        phoneBook.put(company1.getPhoneNumber(), company1);
        phoneBook.put(company2.getPhoneNumber(), company2);
        phoneBook.put(company3.getPhoneNumber(), company3);

        return phoneBook;
    }
}
