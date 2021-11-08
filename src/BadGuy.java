public interface BadGuy {
    public boolean inflictDamage(double dmgInflicted, boolean bypassDodge);
    public void reduceDamage(double dmgReduced);
    public void reduceDefense(double defenseReduced);
    public void reduceDodge(double dodgeReduced);
}
