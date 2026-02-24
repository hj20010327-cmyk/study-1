package quiz.quiz1_1;

public class Battle {

	void fight(Character character1, Character character2) {
		while(character1.hp > 0 && character2.hp > 0) {
			character1.hp = character1.hp - (character2.att() - character1.dep());
			character2.hp = character2.hp - (character1.att() - character2.dep());
			System.out.println(character1.name + "이" + (character2.att() - character1.dep())+ "만큼 달았다");
			System.out.println(character2.name + "이" + (character1.att() - character2.dep())+ "만큼 달았다");
			
		}
		if(character1.hp <= 0) {
			System.out.println(character1.name + "이 졌다..");
		} else if(character2.hp <= 0) {
			System.out.println(character1.name + "이 졌다...");
		}
	}
	
}
