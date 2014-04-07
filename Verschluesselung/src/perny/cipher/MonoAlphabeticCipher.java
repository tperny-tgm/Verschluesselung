package perny.cipher;

public class MonoAlphabeticCipher  {
	private String secretAlphabet;
	
	public MonoAlphabeticCipher() {
		// TODO Auto-generated constructor stub
	}
	public String getsecretAlphabet(){
		return secretAlphabet;
	}
	protected void setsecretAlphabet(String secretAlphabet){
		this.secretAlphabet = secretAlphabet;
	}
}
