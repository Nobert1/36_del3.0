package gui_fields;

import java.awt.Color;
import java.awt.image.BufferedImage;
import gui_codebehind.Observable;
import gui_resources.Attrs;

/**
 * Player entity
 * @author Ronnie
 */
public class GUI_Player extends Observable{
	private int number = -1;
	private String name;
	private int balance;
	private GUI_Car car;
	private static int nextId = 0;
	private boolean payNothing;
	public int placement;
    private int id;
	
	public static final int ICON_WIDTH = 41;
	public static final int ICON_HEIGHT = 22;

	public GUI_Player(String name){
	    this(name, 1000, new GUI_Car(),0);
	}
	public GUI_Player(String name, int balance){
	    this(name, balance, new GUI_Car(),0);
	}
	public GUI_Player(String name, int balance, GUI_Car car, int placement){
		this.name = name;
		this.balance = balance;
		this.car = car;
		this.id = nextId++;
		this.placement = placement;
	}


	//Getters
	public boolean isPayNothing() {
		return payNothing;
	}
	public int getNumber(){ return this.number; }
	public String getName(){ return this.name; }
	public int getBalance(){ return this.balance; }
	public Color getPrimaryColor(){ return this.car.getPrimaryColor(); }
	public Color getSecondaryColor(){ return this.car.getSecondaryColor(); }
	protected BufferedImage getImage() { return this.car.getImage(); }
    public GUI_Car getCar() { return car; }
    protected int getId(){ return id; }
	public int getPlacement() {
		return placement;
	}

	//Setters
	public void setPayNothing(boolean payNothing) {
		this.payNothing = payNothing;
	}
	public void setPlacement(int placement) {
		this.placement = placement;
	}
    protected void setNumber(int number) { this.number = number; }
    public boolean setName(String name){
        if(validator == null) return false;
        if(!validator.checkName(name)) {
            System.err.println(Attrs.getString("Error.Conflict.PlayerName", name));
            return false;
        }
        this.name = name;
        notifyObservers();
        return true;
    }
	public void setBalance(int balance){ 
	    this.balance = balance;
	    notifyObservers();
	}
	// Mandatory
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GUI_Player)) {
			return false;
		}
		GUI_Player other = (GUI_Player) obj;
		if (this.name == null) {
			if(other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	public interface iPlayerValidator{ public boolean checkName(String name); }
	private iPlayerValidator validator = null;
	protected void setValidator(iPlayerValidator validator){ this.validator = validator; }
	
	@Override
    public String toString() {
        return "GUI_Player [number=" + number + ", name=" + name + ", balance="
            + balance + ", car=" + car + "]";
    }
}