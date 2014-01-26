package test.java.newfeatures;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class TestWatcher {

	public static void main(String[] args) throws IOException, InterruptedException {
		Path dirToWatch = Paths.get("C:\\Users\\MANOJ\\Desktop\\TestFolder");
		WatchService service = FileSystems.getDefault().newWatchService();
		dirToWatch.register(service, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		while(true) {
			WatchKey k = service.take();
			for(WatchEvent<?> event : k.pollEvents()) {
				Kind<?> kind = event.kind();
				switch (kind.name()) {
					case "ENTRY_CREATE":
						System.out.println("created :" +event.context());
						break;
					case "ENTRY_DELETE":
						System.out.println("deleted :" +event.context());
						break;
					case "ENTRY_MODIFY":
						System.out.println("modified :" +event.context());
						break;
				}
			}
			boolean valid = k.reset();
			if(!valid) {
				break;
			}
			System.out.println("modified TestWatcher to test the pull");
		}
	}
}
