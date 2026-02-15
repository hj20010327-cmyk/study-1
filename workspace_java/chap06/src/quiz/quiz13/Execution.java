package quiz.quiz13;

public class Execution {

	public static void main(String[] args) {

		Item item = new Item("언더컨트롤");
		
		item.name();
		
		Item item1 = new Item("신념의 연마석");
		
		item1.name();
		
		Process process = new Process();
		
		process.run(item);
		process.run(item1);
	}

}
