package jxlsimportation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

public class JXLSReader {

	public List<Entry> xlsReadFromFile(String xmlPath, String xlsPath) throws ParseException {

		InputStream xmlConfig = null;

		try {
			xmlConfig = new BufferedInputStream(new FileInputStream(xmlPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XLSReader xlsReader = null;

		try {
			xlsReader = ReaderBuilder.buildFromXML(xmlConfig);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<StupidEntry> stupidentries = new ArrayList<StupidEntry>();

		Map<String, List<StupidEntry>> beans = new HashMap<String, List<StupidEntry>>();

		beans.put("stupidentries", stupidentries);

		InputStream xlsStream = null;

		try {
			xlsStream = new BufferedInputStream(new FileInputStream(xlsPath));
			xlsReader.read(xlsStream, beans);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		stupidentries.remove(stupidentries.size() - 1);

		List<Entry> entries = new ArrayList<Entry>();

		for (int i = 0; i < stupidentries.size(); i++) {
			if(stupidentries.get(i).getFirstName()!=null&&stupidentries.get(i).getLastName()!=null&&stupidentries.get(i).getAgenceID()!=null){
				Entry entry = new Entry(stupidentries.get(i));
				entries.add(entry);
			}

		}

		return entries;

	}

}
