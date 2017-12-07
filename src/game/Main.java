package game;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);
		Memento memento = gamer.createMemento();
		for (int i = 0; i < 10; i++) {
			System.out.println("==== " + i);
			System.out.println("현상: " + gamer);
			
			gamer.bet();
			
			System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");
			
			if (gamer.getMoney() > memento.getMoney()) {
				System.out.println("소지금이 증가했으므로 현재의 상태를 저장하자.");
				memento = gamer.createMemento();
			} else if (gamer.getMoney() < memento.getMoney()) {
				System.out.println("소지금이 감수했으므로 이전의 상태로 복원하자.");
				gamer.restoreMemento(memento);
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(" end~ ");
		}
	}

}
