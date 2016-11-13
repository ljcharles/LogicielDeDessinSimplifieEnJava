package logicieldedessin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ViderListener implements ActionListener {
	LinkedList<Figure> f;

	public ViderListener(LinkedList<Figure> f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(f != null) f.clear();

	}

}
