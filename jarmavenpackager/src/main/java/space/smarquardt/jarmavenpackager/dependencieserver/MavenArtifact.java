package space.smarquardt.jarmavenpackager.dependencieserver;

public class MavenArtifact {

	private final String artifactId;

	private final String groupId;

	private final String version;

	private final static String ARTIFACT = "<artifactId>";

	private final static String ARTIFACT_CLOSE = "</artifactId>";

	private final static String GROUPID = "<groupId>";

	private final static String GROUPID_CLOSE = "</groupId>";

	private final static String VERSION = "<version>";

	private final static String VERSION_CLOSE = "</version>";

	private final static String DEPENDENCIE = "<dependencie>";
	private final static String DEPENDENCIE_CLOSE = "</dependencie>";

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

	public String getAsDependencie() {
		return new StringBuilder().append(MavenArtifact.DEPENDENCIE).append(this.groupId).append(this.groupId)
				.append(MavenArtifact.GROUPID_CLOSE).append(MavenArtifact.ARTIFACT).append(this.artifactId)
				.append(MavenArtifact.ARTIFACT_CLOSE).append(MavenArtifact.VERSION).append(this.version)
				.append(MavenArtifact.VERSION_CLOSE).append(MavenArtifact.DEPENDENCIE_CLOSE).toString();
	}

}
