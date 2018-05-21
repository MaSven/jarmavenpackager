package space.smarquardt.jarmavenpackager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class FileUtils {

	public FileUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get the sha1 from one file
	 *
	 * @param file The file
	 * @return Sha1 as {@link String} or {@link Optional#empty()} if the file could
	 *         not be read
	 * @throws NoSuchAlgorithmException If the sha1 algorithm could not be found in
	 *                                  the jvm
	 */
	public static Optional<String> getSha1FromFile(final File file) throws NoSuchAlgorithmException {
		final MessageDigest digest = MessageDigest.getInstance("SHA1");
		try (FileInputStream inputStream = new FileInputStream(file)) {
			final byte[] dataBytes = new byte[1024];
			int nRead = 0;
			while ((nRead = inputStream.read(dataBytes)) != -1) {
				digest.update(dataBytes, 0, nRead);
			}
			final byte[] mdbytes = digest.digest();
			final StringBuilder builder = new StringBuilder();
			for (final byte mdbyte : mdbytes) {
				builder.append(Integer.toString((mdbyte & 0xff) + 0x100, 16).substring(1));
			}
			return Optional.of(builder.toString());
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();

	}

}
