import javax.swing.JFrame;

public class DronePilotFrame extends JFrame {

	public DronePilotFrame() {
		DronePilot panel = new DronePilot();
		add(panel);
		setTitle("Drone Pilot");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new DronePilotFrame().setVisible(true);
	}

}
