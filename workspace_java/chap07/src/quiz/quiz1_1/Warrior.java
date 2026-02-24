package quiz.quiz1_1;

public class Warrior extends Character{

	Warrior(String name, int hp, int ap, int dp, int weapon, int armor) {
		super(name, hp, ap, dp, weapon, armor);
	}
	@Override
	int att() {
		this.attack = this.ap + this.weapon + (int)(Math.random()*10 + 5);
		return attack;
	}
}
