package space.smarquardt.jarmavenpackager.dependencieserver;

public class MavenArtifact {

	private final String artifactId;

	private final String groupId;

	private final String version;

	/**
	 * @param artifactId
	 * @param groupId
	 * @param version
	 */
	public MavenArtifact(final String artifactId, final String groupId, final String version) {
		super();
		this.artifactId = artifactId;
		this.groupId = groupId;
		this.version = version;
	}

	/**
	 * @return the artifactId
	 */
	public String getArtifactId() {
		return this.artifactId;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return this.groupId;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return this.version;
	}

}
