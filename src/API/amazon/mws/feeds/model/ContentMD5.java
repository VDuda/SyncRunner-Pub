package API.amazon.mws.feeds.model;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author Volodimir Duda
 * 
 * @description Static class used to create Content MD5 values from an inputStream
 *
 */
public class ContentMD5 {

	/**
	 * Default constructor
	 */
	public ContentMD5(){
		usage();
	}
	
	/**
	 * Inputting a File for processing.
	 * @param fis - FileInputStream
	 * @return MD5 Hash String
	 */
	public static String computeContentMD5(FileInputStream fis)
		throws IOException, NoSuchAlgorithmException{
		
		DigestInputStream dis = new DigestInputStream(fis,MessageDigest.getInstance("MD5"));
		
		byte[] buffer = new byte[8192];
		while( dis.read( buffer ) > 0 );
		
		String md5Content = new String(
				org.apache.commons.codec.binary.Base64.encodeBase64(
						dis.getMessageDigest().digest())); 
		
		// Effectively resets the stream to be beginning of the file
		// via a FileChannel.
		fis.getChannel().position(0);
		return md5Content;
	}
	
	/**
	 * Inputting a ByteArray for processing.
	 * @param fis - FileInputStream
	 * @return MD5 Hash String
	 */
	public static String computeContentMD5(ByteArrayInputStream fis)
		throws IOException, NoSuchAlgorithmException{
		
		DigestInputStream dis = new DigestInputStream(fis,MessageDigest.getInstance("MD5"));
		
		byte[] buffer = new byte[8192];
		while( dis.read( buffer ) > 0 );
		
		String md5Content = new String(
				org.apache.commons.codec.binary.Base64.encodeBase64(
						dis.getMessageDigest().digest())); 
		
		// Effectively resets the stream to be beginning of the file
		// via a FileChannel.
		fis.reset();
//		fis..getChannel().position(0);
		return md5Content;
	}
	
	/**
	 * Consume the stream and return its Base-64 encoded MD5 checksum.
	 */
	public static String computeContentMD5Header(InputStream inputStream) {
		// Consume the stream to compute the MD5 as a side effect.
		DigestInputStream s;
	 
		try {
			s = new DigestInputStream(inputStream,
					MessageDigest.getInstance("MD5"));
			// drain the buffer, as the digest is computed as a side-effect
			byte[] buffer = new byte[8192];
			while(s.read(buffer) > 0);
			return new String(
					org.apache.commons.codec.binary.Base64.encodeBase64(
							s.getMessageDigest().digest()),
					"UTF-8");
		 } catch (NoSuchAlgorithmException e) {
			 throw new RuntimeException(e);
		 } catch (IOException e) {
			 throw new RuntimeException(e);
		 }
	}
	
	
	
	/**
	 * Print usage of the class
	 */
	private void usage(){
		System.out.println("Creates MD5 Hash from inputStream.\n"
				+ "Please use processMD5() and input an inputStream.\n"
				+ "Should be accessed statically.");
	}
}
