package space.smarquardt.jarmavenpackager.dependencieserver;

import java.net.URL;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Interfaces for the various maven dependencie servers. To add a server
 * implement this interface
 *
 * @author sven
 *
 */
public interface IDependencieFileResolver {
	/**
	 * Search for the mavenarchiv through the checksum.
	 *
	 * @param getCheckSumUrl              get the url to request the file over
	 *                                    checksum search. First argument is the
	 *                                    checksum of the file
	 * @param getartifactFromResponseBody Get the artifacts out of the responsebody
	 *                                    from the server
	 * @return {@link Response} if the server has this dependencie otherwise
	 *         {@link Optional#empty()}
	 */
	Optional<MavenArtifact> searchArtifactWithChecksum(Function<String, URL> getCheckSumUrl,
			Function<ResponseBody, Optional<MavenArtifact>> getartifactFromResponseBody);

	/**
	 * Search for the mavenarchiv with groupid and artifactid.
	 *
	 * @param getUrlForGourpAndArtifactSearch Get the url for the groupid and
	 *                                        artifactid search. First parameter is
	 *                                        the groupId second artifact
	 * @param getartifactsFromResponseBody    Get the artifacts out of the
	 *                                        responsebody
	 * @return Bucket of artifacts if jar found otherwise {@link Optional#empty()}
	 */
	Set<MavenArtifact> searchArtifactWithGroupIdAndArtifactId(
			BiFunction<String, String, URL> getUrlForGourpAndArtifactSearch,
			Function<ResponseBody, Set<MavenArtifact>> getartifactsFromResponseBody);

	/**
	 * Searches for the mavenarchiv only with a ClassName.
	 *
	 * @param getUrlForNameSearch          get the url to search by classname
	 * @param getartifactsFromResponseBody get the artifacts from the responsebody
	 * @return bucket of artifacts or {@link Optional#empty()}
	 */
	Set<MavenArtifact> searchForFileWithClassName(Function<String, URL> getUrlForClassNameSearch,
			Function<ResponseBody, Set<MavenArtifact>> getartifactsFromResponseBody);

}
