package perny.cipher;

public class SubstitutionCipher extends MonoAlphabeticCipher {
	public SubstitutionCipher(String secretAlphabet){
		this.setsecretAlphabet(secretAlphabet);
	}
	
	public void setSecretAlphabet(String secretAlphabet){
		super.setsecretAlphabet(secretAlphabet);
	}
	
}
