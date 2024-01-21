import java.util.Hashtable;

public class Length {
    private double length1;
    private String unit1;
    private double length2;
    private String unit2;
    Hashtable<String, Double> unit_to_factor = new Hashtable<>();
    Length(double length1, String unit1, double length2, String unit2) {
        if (length1 < 0 || length2 < 0) {
            throw new RuntimeException();
        }
        if (invalidUnit(unit1) || invalidUnit(unit2)) {
            throw new RuntimeException();
        }
        unit_to_factor.put("mm", 1.0);
        unit_to_factor.put("cm", 10.0);
        unit_to_factor.put("m", 1000.0);
        unit_to_factor.put("km", 1_000_000.0);

        this.unit1 = unit1;
        this.unit2 = unit2;
        this.length1 = length1;
        this.length2 = length2;

    }
    double convert() {
        return this.length1 * unit_to_factor.get(this.unit1) / unit_to_factor.get(this.unit2);
    }
    boolean compare() {
        return false;
    }

    boolean invalidUnit(String unit) {
        return !unit.equals("mm") && !unit.equals("cm") && !unit.equals("m") && !unit.equals("km");
    }

}

