package perny.test;
import static org.junit.Assert.*;

import org.junit.*;

import perny.cipher.MonoAlphabeticCipher;
import perny.cipher.SubstitutionCipher;


public class testCipher {
	/**
	 * Erstellt ein geheimes Alphabet und �berpr�ft ob auch dasselbe Alphabet wieder zur�ck kommt
	 */
	@Test
	public void test1(){
		SubstitutionCipher sb = new SubstitutionCipher("qwertzuiop��asdfghjkl��yxcvbnm");
		assertTrue(sb.getSecretAlphabet().equals("qwertzuiop��asdfghjkl��yxcvbnm"));
	}
	
	/**
	 * Geheimalphabet wird mittels SubstitutionCiher ge�ndert
	 */
	@Test
	public void test2(){
		SubstitutionCipher sb = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
		sb.setSecretAlphabet("qwertzuiop��asdfghjkl��yxcvbnm");
		assertTrue(sb.getSecretAlphabet().equals("qwertzuiop��asdfghjkl��yxcvbnm"));
	}
	
	/**
	 * In diesem Test wird das Geheimalphabet so getestet, dass es eine Exception werfen sollte
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test3(){
		SubstitutionCipher sb = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
		sb.setSecretAlphabet("qw");
	}
	
	/**
	 * Geheimalphabet wird mit einem MonoAlphabeticCipher Objekt getestet
	 */
	@Test
	public void test4(){
		MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
		assertTrue("abcdefghijklmnopqrstuvwxyz����".equals(mac.getSecretAlphabet()));
	}
	
	/**
	 * Verschluesselungstest: ein Text wird verschluesselt und
	 * um zu testen ob die verschluesselung funktioniert hat wird der verschluesselte
	 * Text mithilfe der Methode encrypt mit dem Original verglichen
	 */
	@Test
	public void test5(){
		SubstitutionCipher sb = new SubstitutionCipher("cbadefghijklmnopqrstuvwxyz����");
		assertTrue(sb.encrypt("abc").equals("cba"));
	}
	
	/**
	 * Entschluesselungstest: ein Text wird entschluesselt und
	 * um zu testen ob die entschluesselung funktioniert hat wird der entschluesselte
	 * Text mithilfe der Methode decrypt mit dem Original verglichen
	 */
	@Test
	public void test6(){
		SubstitutionCipher sb = new SubstitutionCipher("cbadefghijklmnopqrstuvwxyz����");
		assertTrue(sb.decrypt("cba").equals("abc"));
	}
	
}
