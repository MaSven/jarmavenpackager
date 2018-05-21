/**
 *
 */
/**
 * @author sven
 *
 */
module jarmavenpackager {
	requires java.base;
	requires com.beust.jcommander;
	requires java.xml;
	requires maven.embedder;
	requires okhttp3;

	exports space.smarquardt.jarmavenpackager;
}