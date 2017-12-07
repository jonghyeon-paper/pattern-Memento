package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
	private int money;
	private List<String> fruits = new ArrayList<>();
	private Random random = new Random();
	private static String[] fruitsname = {
			"apple", "banana", "grape", "gool"
	};
	
	public Gamer(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void bet() {
		int dice = random.nextInt(6) + 1;
		if (dice == 1) {
			money += 100;
			System.out.println("소지금이 증가했습니다.");
		} else if (dice == 2) {
			money /= 2;
			System.out.println("소지금이 절반이 되었습니다.");
		} else if (dice == 6) {
			String  f = this.getFruit();
			System.out.println(f + " 과일을 받았습니다.");
			fruits.add(f);
		} else {
			System.out.println("변동내용이 없습니다.");
		}
	}
	
	public Memento createMemento() {
		Memento m = new Memento(money);
		Iterator<String> i = fruits.iterator();
		while (i.hasNext()) {
			String f = i.next();
			if (f.startsWith("맛있는")) {
				m.addFruit(f);
			}
		}
		return m;
	}
	
	public void restoreMemento(Memento memento) {
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}
	
	@Override
	public String toString() {
		return "[money = " + money + ", fruits = " + fruits + "]";
	}
	
	private String getFruit() {
		String prefix = " ";
		if (random.nextBoolean()) {
			prefix = "맛있는 ";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
