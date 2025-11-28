import java.util.Objects;

public class Address {
    protected String Country;
    protected String Sity;
    
    public Address(String Country, String Sity){
        this.Country = Country; 
        this.Sity = Sity; 
    }
    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return Sity;
    }

    @Override
    public int hashCode(){
        return Objects.hash(Country, Sity);
    }
    
    @Override 
    public boolean equals(Object obj){
        Address o = (Address) obj;
        return Country.equals(o) && Sity.equals(o);
    }

     @Override
    public String toString() {
        return Country + ", " + Sity;
    }
    
}

