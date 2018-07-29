package demo;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;

import java.io.File;
import java.io.IOException;

public class Hello {

    public static void main(String[] args) throws Exception {
        String uri = "https://github.com/java-demos/java-hello-world-demo.git";
        File localDir = new File("./target/local-repo/java-hello-world-demo");
        initDir(localDir);

        Git.cloneRepository().setURI(uri)
                .setDirectory(localDir)
                .setCloneAllBranches(true)
                .call();

        System.out.println("check dir: " + localDir.getAbsolutePath());
    }
    private static void initDir(File localDir) throws IOException {
        if (localDir.exists()) {
            FileUtils.forceDelete(localDir.getParentFile());
        }
        FileUtils.forceMkdir(localDir.getParentFile());
    }

}
