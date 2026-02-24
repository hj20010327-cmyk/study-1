package quiz.quiz1_1;

public class Wizard extends Character{

	Wizard(String name, int hp, int ap, int dp, int weapon, int armor) {
		super(name, hp, ap, dp, weapon, armor);
	}
	
	@Override
	int att() {
		this.attack = this.ap + this.weapon + (int)(Math.random()*10 + 20);
		return attack;
	}
	
}
