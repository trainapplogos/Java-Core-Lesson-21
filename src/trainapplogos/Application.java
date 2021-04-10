package trainapplogos;

import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException {
		Human.saveAnnotationsToFile("human_fileds.txt", Human.class);
	}
}
