#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ZipUtilsTest {
	
	ZipUtils zipUtils = new ZipUtils();
	
	@Before
	public void setup() {
	}
	
	@Test
	public void zipFileTest() {
		zipUtils.zipFile("C://Users//LEANDRO//Desktop//teste2.zip");
	}

}
