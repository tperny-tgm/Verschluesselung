package perny.cipher;

public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet;
	public MonoAlphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}
	public String getsecretAlphabet(){
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
		// TODO Auto-generated method stub
		return null;
	}

}
