package perny.test;
import static org.junit.Assert.*;

import org.junit.*;

import perny.cipher.MonoAlphabeticCipher;
import perny.cipher.SubstitutionCipher;


public class testCipher {
	/**
	 * Erstellt ein geheimes Alphabet und überprüft ob auch dasselbe Alphabet wieder zurück kommt
	 */
	@Test
	public void test1(){
		SubstitutionCipher sb = new SubstitutionCipher("qwertzuiopüßasdfghjklöäyxcvbnm");
		assertTrue(sb.getSecretAlphabet().equals("qwertzuiopüßasdfghjklöäyxcvbnm"));
	}
	
	/**
	 * Geheimalphabet wird mittels SubstitutionCiher geändert
	 */
	@Test
	public void test2(){
		SubstitutionCipher sb = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		sb.setSecretAlphabet("qwertzuiopüßasdfghjklöäyxcvbnm");
		assertTrue(sb.getSecretAlphabet().equals("qwertzuiopüßasdfghjklöäyxcvbnm"));
	}
	
	/**
	 * In diesem Test wird das Geheimalphabet so getestet, dass es eine Exception werfen sollte
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test3(){
		SubstitutionCipher sb = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		sb.setSecretAlphabet("qw");
	}
	
	/**
	 * Geheimalphabet wird mit einem MonoAlphabeticCipher Objekt getestet
	 */
	@Test
	public void test4(){
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertTrue("abcdefghijklmnopqrstuvwxyzäöüß".equals(mac.getSecretAlphabet()));
	}
	
	/**
	 * Verschluesselungstest: ein Text wird verschluesselt und
	 * um zu testen ob die verschluesselung funktioniert hat wird der verschluesselte
	 * Text mithilfe der Methode encrypt mit dem Original verglichen
	 */
	@Test
	public void test5(){
		SubstitutionCipher sb = new SubstitutionCipher("cbadefghijklmnopqrstuvwxyzäöüß");
		assertTrue(sb.encrypt("abc").equals("cba"));
	}
	
	/**
	 * Entschluesselungstest: ein Text wird entschluesselt und
	 * um zu testen ob die entschluesselung funktioniert hat wird der entschluesselte
	 * Text mithilfe der Methode decrypt mit dem Original verglichen
	 */
	@Test
	public void test6(){
		SubstitutionCipher sb = new SubstitutionCipher("cbadefghijklmnopqrstuvwxyzäöüß");
		assertTrue(sb.decrypt("cba").equals("abc"));
	}
	
}
