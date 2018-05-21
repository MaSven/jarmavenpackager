package space.smarquardt.jarmavenpackager.dependencieserver;

import java.io.File;
import java.util.Optional;

import okhttp3.Response;

/**
 * Interfaces for the various maven dependencie servers. To add a server
 * implement this interface
 *
 * @author sven
 *
 */
public interface IDependencieServer {
	/**
	 * Search for the mavenarchiv through the checksum.
	 *
	 * @param jarFile file to be searched for
	 * @return {@link Response} if the server has this dependencie otherwise
	 *         {@link Optional#empty()}
	 */
	Optional<Response> searchArtifactWithChecksum(File jarFile);

	/**
	 * Search for the mavenarchiv with groupid and artifactid. Will take the first
	 * found option
	 *
	 * @param groupId    GroupId of the jar
	 * @param artifactId Artifactid of the jar
	 * @return {@link Response} if jar found otherwise {@link Optional#empty()}
	 */
	Optional<Response> searchArtifactWithGroupIdAndArtifactId(String groupId, String artifactId);

	/**
	 * Searches for the mavenarchiv only with a ClassName. Will take the first found
	 * option
	 *
	 * @param nameOfFile Name of the File to search for
	 * @return Response or {@link Optional#empty()}
	 */
	Optional<Response> searchForFileWithClassName(String nameOfFile);

}
