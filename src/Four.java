public class Four {
    private String thing;
    private int damage;
    private int protection;
    private boolean availability;

    public Four(String thing, int damage, int protection, boolean availability) {
        this.thing = thing;
        this.damage = damage;
        this.protection = protection;
        this.availability = availability;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean flag) {
        this.availability = flag;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }
}
