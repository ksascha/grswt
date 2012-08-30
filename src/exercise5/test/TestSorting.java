/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker and Edzard Hoefig
 * Freie Universitaet Berlin, SS 2012
 */
package exercise5.test;

import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import junit.extensions.abbot.ComponentTestFixture;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import abbot.finder.ComponentNotFoundException;
import abbot.finder.MultipleComponentsFoundException;
import abbot.finder.matchers.NameMatcher;
import abbot.tester.JButtonTester;
import abbot.tester.JTableLocation;
import abbot.tester.JTableTester;
import abbot.tester.JTextComponentTester;

/**
 * Uebung 5 - Black Box Test
 * GUI testing
 * 
 * Bitte Nummer der Gruppe eintragen:
 * 0
 * 
 * Bitte Gruppenmitglieder eintragen:
 * @author ...
 */
public class TestSorting extends ComponentTestFixture {

	// Tester for (radio) button components
	private JButtonTester buttonTester;

	// Tester for table components
	private JTableTester tableTester;

	// Tester for text field components
	private JTextComponentTester textTester;

	
	/**
	 * Creates test fixture
	 */
	@Before
	public void setUp() throws Exception {

		// Start the application
		exercise5.addressbook.Manager.main(null);
		
		// Setup some test instrumentation
		this.buttonTester = new JButtonTester();
		this.tableTester = new JTableTester();
		this.textTester = new JTextComponentTester();
	}

	/**
	 * Removes test fixture
	 */
	@After
	public void tearDown() throws Exception {
		// Nothing to do
	}
	
	/**
	 * Test editing of an entry.
	 * This test case serves as a small tutorial on using the Abbot GUI testing framework. Please remove it before submitting the exercise.
	 * @throws ComponentNotFoundException When a GUI component was not available
	 * @throws MultipleComponentsFoundException When there is an ambiguous resolution of GUI components 
	 * @throws IOException In case the address book data file could not be read 
	 */
//	@Test
//	public void testEdit() throws ComponentNotFoundException, MultipleComponentsFoundException, IOException {
//		
//	    // Load data into address book
//	    buttonTester.actionClick(getFinder().find(new NameMatcher("loadButton")));
//	    
//	    // Is the correct data in the table?
//	    TableModel content = ((JTable) getFinder().find(new NameMatcher("viewTable"))).getModel();
//	    assertEquals("Dagobert", content.getValueAt(0, 0));
//	    assertEquals("Duck", content.getValueAt(0, 1));
//	    assertEquals("M", content.getValueAt(0, 2));
//	    assertEquals("dagobert@duck-enterprises.com", content.getValueAt(0, 3));
//	    assertEquals("1.10.1911", content.getValueAt(0, 4));
//	    
//	    // Edit first entry in table
//	    tableTester.actionSelectCell(getFinder().find(new NameMatcher("viewTable")), new JTableLocation(0,0));
//	    buttonTester.actionClick(getFinder().find(new NameMatcher("editButton")));
//	   
//	    // Change entry's values
//	    textTester.actionEnterText(getFinder().find(new NameMatcher("firstNameTextfield")), "Foo");
//	    textTester.actionEnterText(getFinder().find(new NameMatcher("lastNameTextfield")), "Bar");
//	    buttonTester.actionClick(getFinder().find(new NameMatcher("femaleRadiobutton")));
//	    buttonTester.actionClick(getFinder().find(new NameMatcher("phoneRadiobutton")));
//	    textTester.actionEnterText(getFinder().find(new NameMatcher("contactInformationTextfield")), "999999");
//	    textTester.actionEnterText(getFinder().find(new NameMatcher("dateOfBirthTextfield")), "1.1.1111");
//	    
//	    // Release dialog
//	    buttonTester.actionClick(getFinder().find(new NameMatcher("okButton")));
//	    
//	    // Did the data change properly in the table?
//	    content = ((JTable) getFinder().find(new NameMatcher("viewTable"))).getModel();
//	    assertEquals("Foo", content.getValueAt(0, 0));
//	    assertEquals("Bar", content.getValueAt(0, 1));
//	    assertEquals("F", content.getValueAt(0, 2));
//	    assertEquals("999999", content.getValueAt(0, 3));
//	    assertEquals("1.1.1111", content.getValueAt(0, 4));
//	}
	
	/*
	 * Aufgabe 4
	 * Verwenden Sie JUnit zur Ueberpruefung der korrekten Sortierreihenfolge beim Hinzufuegen von Eintraegen in das Adressbuch.  
	 * Testen Sie dabei ausschliesslich nach Black-Box Prinzipien und greifen Sie niemals direkt auf Klassen zu
	 * die in den sub-packages model, view und controller des package exercise5.addressbook definiert sind. 
	 * Verwenden Sie das Abbot GUI test framework zur Testdurchfuehrung.
	 * 
	 * Hinweis:
	 * Die aktuelle Version von Abbot (1.2.0) hat auf manchen Systemen (z.B. OS X 10.7) Schwierigkeiten die richtige "Keymap" zu 
	 * erkennen. Als Folge davon werden einige Zeichen nicht richtig in die Textfelder eingetragen (z.B. Sonderzeichen, 
	 * y und z vertauscht...). Bitte ueberpruefen Sie bei Ihren Testfaellen, ob Abbot die richtigen Testdaten eintraegt und waehlen 
	 * Sie ggfs. andere.
	 */
	
	@Test
	public void testAddNewEntryThatAlreadyExists() throws ComponentNotFoundException, MultipleComponentsFoundException{
		/**
		 * Hier erfolgt die Eingabe der Daten ins GUI mittels Abbot.
		 */
		//load table
		buttonTester.actionClick(getFinder().find(new NameMatcher("loadButton")));
		//add a new entry
		buttonTester.actionClick(getFinder().find(new NameMatcher("addButton")));
		//insert name 'Max' and lastname 'Mustermann'
		textTester.actionEnterText(getFinder().find(new NameMatcher("firstNameTextfield")), "Donald");
		textTester.actionEnterText(getFinder().find(new NameMatcher("lastNameTextfield")), "Duck");
		//gender = male
		buttonTester.actionClick(getFinder().find(new NameMatcher("maleRadiobutton")));
		//choose and insert phone
		buttonTester.actionClick(getFinder().find(new NameMatcher("phoneRadiobutton")));
		textTester.actionEnterText(getFinder().find(new NameMatcher("contactInformationTextfield")), "12345");
		//date of birth is 30.8.2012
		textTester.actionEnterText(getFinder().find(new NameMatcher("dateOfBirthTextfield")), "23.8.1968");
		//release dialog
	    buttonTester.actionClick(getFinder().find(new NameMatcher("okButton")));
		
	    /**
	     * Hier erfolgt die Überprüfung. Da der doppelte Eintrag nach Spezifikation ignoriert werden soll, müsste die
	     * Einträge vor und nach Donald Duck noch die selben sein.
	     */
	    TableModel content = ((JTable) getFinder().find(new NameMatcher("viewTable"))).getModel();
	    assertEquals("Daisy", content.getValueAt(1, 0));
	    assertEquals("Duck", content.getValueAt(1, 1));
	    assertEquals("F", content.getValueAt(1, 2));
	    assertEquals("daisy@entenhausen.org", content.getValueAt(1, 3));
	    assertEquals("30.10.1981", content.getValueAt(1, 4));
	    
	    assertEquals("Dorette", content.getValueAt(3, 0));
	    assertEquals("Duck", content.getValueAt(3, 1));
	    assertEquals("F", content.getValueAt(3, 2));
	    assertEquals("4711", content.getValueAt(3, 3));
	    assertEquals("14.5.1913", content.getValueAt(3, 4));
	}
	
	@Test
	public void testAddEntryAtTheTopOfTheTableLastName() throws ComponentNotFoundException, MultipleComponentsFoundException{
		/**
		 * Hier erfolgt die Eingabe der Daten ins GUI mittels Abbot.
		 */
		//load table
		buttonTester.actionClick(getFinder().find(new NameMatcher("loadButton")));
		//add a new entry
		buttonTester.actionClick(getFinder().find(new NameMatcher("addButton")));
		//insert name 'Max' and lastname 'Mustermann'
		textTester.actionEnterText(getFinder().find(new NameMatcher("firstNameTextfield")), "Donald");
		textTester.actionEnterText(getFinder().find(new NameMatcher("lastNameTextfield")), "Becker");
		//gender = male
		buttonTester.actionClick(getFinder().find(new NameMatcher("maleRadiobutton")));
		//choose and insert phone
		buttonTester.actionClick(getFinder().find(new NameMatcher("phoneRadiobutton")));
		textTester.actionEnterText(getFinder().find(new NameMatcher("contactInformationTextfield")), "12345");
		//date of birth is 30.8.2012
		textTester.actionEnterText(getFinder().find(new NameMatcher("dateOfBirthTextfield")), "23.8.1968");
		//release dialog
	    buttonTester.actionClick(getFinder().find(new NameMatcher("okButton")));
		
	    /**
	     * Hier erfolgt die Überprüfung. Der Nachname beginnt mit B und müsste somit am ANfang der Tabelle stehen.
	     */
	    TableModel content = ((JTable) getFinder().find(new NameMatcher("viewTable"))).getModel();
	    assertEquals("Donald", content.getValueAt(0, 0));
	    assertEquals("Becker", content.getValueAt(0, 1));
	    assertEquals("M", content.getValueAt(0, 2));
	    assertEquals("12345", content.getValueAt(0, 3));
	    assertEquals("23.8.1968", content.getValueAt(0, 4));
	}
}
