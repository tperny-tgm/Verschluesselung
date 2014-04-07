package perny.cipher;

public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet;
	public MonoAlphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}
	public String getSecretAlphabet(){
		return secretAlphabet;
	}
	protected void setsecretAlphabet(String secretAlphabet){
		this.secretAlphabet = secretAlphabet;
	}
	
	@Override
	public String encrypt(String text) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz����";
		String enct = "";
		for(int i=0; i<text.length(); i++){
			for(int j = 0; j<alphabet.length();j++){
				if(text.charAt(i)==alphabet.charAt(j)){
					enct += secretAlphabet.charAt(j);
				}
			}
		}
		return enct;
	}
	@Override
	public String decrypt(String text) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz����";
		String dect = "";
		for(int i=0; i<text.length(); i++){
			for(int j = 0; j<secretAlphabet.length();j++){
				if(text.charAt(i)==secretAlphabet.charAt(j)){
					dect += alphabet.charAt(j);
				}
			}
		}
		return dect;
	}

}
