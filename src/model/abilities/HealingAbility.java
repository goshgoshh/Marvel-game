package model.abilities;

import java.util.ArrayList;

import model.world.Damageable;

public  class HealingAbility extends Ability {
	private int healAmount;

	public HealingAbility(String name,int cost, int baseCoolDown, int castRadius, AreaOfEffect area,int required, int healingAmount) {
		super(name,cost, baseCoolDown, castRadius, area,required);
		this.healAmount = healingAmount;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

	
	@Override
	public void execute(ArrayList<Damageable> targets) {
		for (Damageable d : targets)

			d.setCurrentHP(d.getCurrentHP() + healAmount);

	}
	public String toString() {
		String s="";
		s+="Type: Healing Ability "+"\n"+"Mana Cost: "+getManaCost()+"\n"+"Required Action Points: "+ getRequiredActionPoints()+"\n"+"Cast Rande: "+getCastRange()+"\n"+"Current CoolDown: "+
		getCurrentCooldown()+"\n"+"Base CoolDown: "+getBaseCooldown()+"\n"+"Heal Amount: "+healAmount;
		return s;
	}

}
