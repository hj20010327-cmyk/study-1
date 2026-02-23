package quiz.quiz1_1;

public class Character {

	String name;
	int hp;
	int ap;
	int dp;
	int weapon;
	int armor;
	int attack;
	
	Character(String name, int hp, int ap, int dp, int weapon, int armor){
		System.out.println("캐릭터 생성완료");
		this.name = name;
		this.hp = hp;
		this.ap = ap;
		this.dp = dp;
		this.weapon = weapon;
		this.armor = armor;
	}
	
	int att() {
		this.attack = this.ap + this.weapon + (int)(Math.random()*10 + 5);
		return attack;
	}
	
	int dep() {
		return this.dp + this.armor;
	}
	
}
