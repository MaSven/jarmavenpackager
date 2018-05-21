package space.smarquardt.jarmavenpackager.dependencieserver;

import java.io.File;
import java.util.Optional;
import java.util.Set;

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
	Optional<MavenArtifact> searchArtifactWithChecksum(File jarFile);

	/**
	 * Search for the mavenarchiv with groupid and artifactid.
	 *
	 * @param groupId    GroupId of the jar
	 * @param artifactId Artifactid of the jar
	 * @return Bucket of artifacts if jar found otherwise {@link Optional#empty()}
	 */
	Optional<Set<MavenArtifact>> searchArtifactWithGroupIdAndArtifactId(String groupId, String artifactId);

	/**
	 * Searches for the mavenarchiv only with a ClassName.
	 *
	 * @param nameOfFile Name of the File to search for
	 * @return bucket of artifacts or {@link Optional#empty()}
	 */
	Optional<Set<MavenArtifact>> searchForFileWithClassName(String nameOfFile);

}
