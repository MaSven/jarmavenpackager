package space.smarquardt.jarmavenpackager.dependencieserver.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import space.smarquardt.jarmavenpackager.dependencieserver.IDependencieFileResolver;
import space.smarquardt.jarmavenpackager.dependencieserver.MavenArtifact;
import space.smarquardt.jarmavenpackager.util.FileUtils;

/**
 * Default implementation for
 *
 * @author sven
 *
 */
public class DefaultDependencieServer implements IDependencieFileResolver {
	/**
	 * JarFile we want to search for
	 */
	File jarFile;
	/**
	 * Client to make request to the dependencie server
	 */
	private final OkHttpClient client;

	/**
	 * @param checksumUrl
	 * @param artifactAndGroupidUrl
	 * @param classNameSearch
	 */
	public DefaultDependencieServer(final File jarFile) {
		super();
		this.jarFile = jarFile;
		this.client = new OkHttpClient();
	}

	@Override
	public Optional<MavenArtifact> searchArtifactWithChecksum(final Function<String, URL> function,
			final Function<ResponseBody, Optional<MavenArtifact>> getartifactFromResponseBody) {
		try {
			final Optional<String> sha1FromFile = FileUtils.getSha1FromFile(this.jarFile);
			if (sha1FromFile.isPresent()) {
				final Request request = new Request.Builder().url(function.apply(sha1FromFile.get())).build();
				final Response execute = this.client.newCall(request).execute();
				return getartifactFromResponseBody.apply(execute.body());
			}
		} catch (final NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Set<MavenArtifact> searchArtifactWithGroupIdAndArtifactId(final BiFunction<String, String, URL> getUrl,
			final Function<ResponseBody, Set<MavenArtifact>> getartifactsFromResponseBody) {
		return Collections.emptySet();
	}

	@Override
	public Set<MavenArtifact> searchForFileWithClassName(final Function<String, URL> getUrl,
			final Function<ResponseBody, Set<MavenArtifact>> getartifactsFromResponseBody) {
		return Collections.emptySet();
	}

}
