package quiz.quiz1_1;

public class BattleExam {

	public static void main(String[] args) {

		Wizard wizard = new Wizard("불독", 100, 15, 5, 15, 10);
		Warrior warrior = new Warrior("팔라딘", 150, 10, 20, 10, 20);
		
		Battle battle = new Battle();
		battle.fight(wizard, warrior);
		
	}

}
