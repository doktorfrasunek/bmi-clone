package pl.akademia.bmiclone.model;

public class BMI {
    private double value;
    private String tier;
    private String goal;
    private String gender;
    private void setValue(int height, int weight){
        value= weight*10000/(double)(height * height);
    }

    private void setTier(double value){
        if (value> 40) tier="otyłość skrajną";
        else if (value >35) tier="II stopień otyłości";
        else if (value >30) tier="I stopień otyłości";
        else if (value > 25) tier=" nadwagę" ;
        else if (value > 18.5) tier="prawidłową wartość";
        else if (value > 17) tier="niedowaga";
        else if (value > 16) tier="wychudzenie";
        else  tier="wygłodzenie";
    }

    private void setGoal(int height){
        String result= "Dla podanego wzrostu (%d cm) prawidłowa waga wynosi pomiędzy: %d a %d kg";
        int min= (int) ((18.5 * height* height) / 10000);
        int max=  ((25 * height * height) / 10000);
        goal = String.format(result,height,min,max);

    }

    public BMI(BMIAtributes atributes){
        gender= atributes.getBmi_gender();
        setValue(atributes.getHeight(), atributes.getWeight());
        setTier(value);
        setGoal(atributes.getHeight());
    }

    public double getValue() {
        return value;
    }

    public String getTier() {
        return tier;
    }

    public String getGoal() {
        return goal;
    }

    public String getGender() {
        return gender;
    }
}
