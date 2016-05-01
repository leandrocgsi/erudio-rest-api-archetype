#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils

import java.io.File

import org.apache.log4j.Logger;;

class FileUtils {
	
	private Logger logger = Logger.getLogger(FileUtils.class);

	def copyFile(String filePath, String fileDestinationPath){
		def fileSourceStream = new File(filePath).newDataInputStream()
		writeFile(fileDestinationPath, fileSourceStream);
		fileSourceStream.close()
	}
	
	def printFile(String filePath){
		new FileInputStream( new File(filePath) ).eachLine { println it }
	}
	
	def String fileToString(String filePath){
		def fileSourceStream = new File(filePath).newDataInputStream();
		fileSourceStream.getText();
		fileSourceStream.close()
	}
	
	def writeFile(String fileDestinationPath, byte[] stream){
		def fileDestinationStream = new File(fileDestinationPath).newDataOutputStream();
		fileDestinationStream << stream;
		fileDestinationStream.close();
	}

	def getBytesFromFile(File file) {
		InputStream inputStream = null;
		byte[] buffer = null;
		try {
			inputStream = new FileInputStream(file);
			buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		buffer;
	}
}
