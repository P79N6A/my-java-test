package jdk7;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class IOTest {
	@Test
	public void pathTest() throws IOException {
		Path path = Paths.get("C:\\Users\\zongchao\\Desktop\\微信数据错误.txt");
		System.out.println(path);
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		for (String line : lines) {
			System.out.println(line);
		}
	}
}
