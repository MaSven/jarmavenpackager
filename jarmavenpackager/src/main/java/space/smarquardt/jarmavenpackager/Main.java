package space.smarquardt.jarmavenpackager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * Mainclass holds main method
 *
 * @author sven
 *
 */
public class Main {
	/**
	 * Path to the manifest file
	 */
	@Parameter(names = { "--manifest", "-m" }, required = false)
	File manifestPath;
	/**
	 * Path to where the new created maven archive gets installed
	 */
	@Parameter(names = { "--install", "-i" }, required = true)
	File installPath;
	/**
	 * Path to the jars that the file depends on
	 */
	@Parameter(names = { "--libs", "-l" }, required = false)
	File libDir;
	/**
	 * Griupid of the jar to be installed
	 */
	@Parameter(names = { "--groupid", "-g" }, required = true)
	String groupId;
	/**
	 * Artifactid of the jar
	 */
	@Parameter(names = { "--artifactid", "-a" }, required = true)
	String artifactId;
	/**
	 * Version of the jar
	 */
	@Parameter(names = { "--version", "-v" }, required = true)
	String version;
	/**
	 * Holds the xml of the pom
	 */
	private final StringBuilder builder = new StringBuilder();
	/**
	 * Pattern to validate jarfiles
	 */
	private static final Predicate<String> jarPattern = Pattern.compile("*\\.jar").asPredicate();
	/**
	 * Contains all jarFiles that the files depends directly or indirectly
	 */
	private List<Path> jarFiles;

	public static void main(final String[] args) throws JarMavenPackagerArgumentsException {
		final Main main = new Main();
		JCommander.newBuilder().addObject(main).build().parse(args);
		main.searchForJars();

	}

	/**
	 * Searches for dependencies in the manifestclasspath or the libdir provided
	 *
	 * @throws JarMavenPackagerArgumentsException
	 */
	void searchForJars() throws JarMavenPackagerArgumentsException {
		if ((this.libDir == null) && (this.manifestPath == null)) {
			throw new JarMavenPackagerArgumentsException("Provide at least on of manifestfilepaht or libdir");
		}
		if (this.libDir != null) {
			try {
				this.jarFiles = Files.walk(this.libDir.toPath()).filter(Files::isDirectory).filter(Files::exists)
						.filter(path -> Main.jarPattern.test(path.getFileName().toString()))
						.collect(Collectors.toUnmodifiableList());
			} catch (final IOException e) {
				throw new JarMavenPackagerArgumentsException("failure trying to read the libdir", e);
			}
		} else {
			// Parse the manifest file
			// TODO implement this shit !!!. But maybe not this is too incosistent

		}
	}

}
