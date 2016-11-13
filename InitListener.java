package logicieldedessin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class InitListener implements ActionListener {
	LinkedList<Figure> f;

	public InitListener(LinkedList<Figure> f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		f = new LinkedList<Figure>();
	}

}
