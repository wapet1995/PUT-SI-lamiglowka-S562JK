import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import org.jpl7.Query;
import java.awt.Font;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class S562JK {

	private JFrame frmamigwkaSjk;
	private String[] columnNames = {"Wedding Year","First Names","Soft Drinks","Songs"};
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S562JK window = new S562JK();
					window.frmamigwkaSjk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public S562JK() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmamigwkaSjk = new JFrame();
		frmamigwkaSjk.setTitle("\u0141amig\u0142\u00F3wka S562JK");
		frmamigwkaSjk.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Maciej\\studia\\Semestr VI\\Sztuczna Inteligencja\\moje\\laboratoria\\Projekt\\PUT-SI-lamiglowka-S562JK\\Grafika_S562JK\\ikona.PNG"));
		frmamigwkaSjk.setResizable(false);
		frmamigwkaSjk.setBounds(100, 100, 673, 160);
		frmamigwkaSjk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String t1 = "consult('Lamiglowka S562JK.pl')";
        Query q1 = new Query(t1);
        q1.hasSolution();
        String t2 = "s562jk(A1,A2,A3,A4,A5, B1,B2,B3,B4,B5, C1,C2,C3,C4,C5)";
        Query q2 = new Query(t2);
        String[][] wynik = new String[5][4];
      
        wynik[0][0] = "1925";
        wynik[1][0] = "1941";
        wynik[2][0] = "1947";
        wynik[3][0] = "1972";
        wynik[4][0] = "1976";
        
        wynik[q2.oneSolution().get("A1").intValue()-1][1] = "Chandler";
        wynik[q2.oneSolution().get("A2").intValue()-1][1] = "Holden";
        wynik[q2.oneSolution().get("A3").intValue()-1][1] = "Jane";
        wynik[q2.oneSolution().get("A4").intValue()-1][1] = "Skylar";
        wynik[q2.oneSolution().get("A5").intValue()-1][1] = "Tiffany";
        
        wynik[q2.oneSolution().get("B1").intValue()-1][2] = "Cherry cola";
        wynik[q2.oneSolution().get("B2").intValue()-1][2] = "Cola";
        wynik[q2.oneSolution().get("B3").intValue()-1][2] = "Diet cola";
        wynik[q2.oneSolution().get("B4").intValue()-1][2] = "Grape soda";
        wynik[q2.oneSolution().get("B5").intValue()-1][2] = "Root beer";
        
        wynik[q2.oneSolution().get("C1").intValue()-1][3] = "All By Myself";
        wynik[q2.oneSolution().get("C2").intValue()-1][3] = "Happy Times";
        wynik[q2.oneSolution().get("C3").intValue()-1][3] = "Moon River";
        wynik[q2.oneSolution().get("C4").intValue()-1][3] = "One More Time";
        wynik[q2.oneSolution().get("C5").intValue()-1][3] = "Summer Blues";
        
		table = new JTable(wynik, columnNames);
		table.setModel(new DefaultTableModel(
			wynik,
			new String[] {
				"Wedding Year", "First Names", "Soft Drinks", "Songs"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		JScrollPane scrollPane = new JScrollPane(table);
		frmamigwkaSjk.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("S562JK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmamigwkaSjk.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}

}
