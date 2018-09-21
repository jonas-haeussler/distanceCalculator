package calculator.ctrl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Map;

import javax.xml.parsers.SAXParser;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.openstreetmap.osmosis.core.container.v0_6.EntityContainer;
import org.openstreetmap.osmosis.core.domain.v0_6.Entity;
import org.openstreetmap.osmosis.core.domain.v0_6.Node;
import org.openstreetmap.osmosis.core.domain.v0_6.Relation;
import org.openstreetmap.osmosis.core.domain.v0_6.Way;
import org.openstreetmap.osmosis.core.task.v0_6.RunnableSource;
import org.openstreetmap.osmosis.core.task.v0_6.Sink;
import org.openstreetmap.osmosis.xml.common.CompressionActivator;
import org.openstreetmap.osmosis.xml.common.CompressionMethod;
import org.openstreetmap.osmosis.xml.common.SaxParserFactory;
import org.openstreetmap.osmosis.xml.v0_6.impl.OsmHandler;
import org.osm.schema.Osm;
import org.openstreetmap.osmosis.xml.v0_6.XmlReader;
import org.osm.schema.OsmNode;
import org.osmtools.spring.OsmAdapter;
import org.xml.sax.SAXException;

import calculator.data.Adress;
import jdk.nashorn.api.scripting.URLReader;


public class RawStreetMapData {
	private static URL adressDataUrl;
	private static File file;
	
	public static double[] getCoordinates(Adress adress){
//		try {
//			adressDataUrl = new URL("https://nominatim.openstreetmap.org/search/de/" + adress.getCity() + "/" + adress.getStreet() + "/" + adress.getHouseNumber() + "?format=xml&polygon=1&addressdetails=1");
//			URLConnection connection = adressDataUrl.openConnection();
//			InputStream is = connection.getInputStream();
//			
//			
//			SAXBuilder builder = new SAXBuilder();
//			Document doc = builder.build(is);
//			XMLOutputter out = new XMLOutputter();
//			
//			File file = new File("src/calculator/data/adress.xml");
//
//			OutputStream outStream = new FileOutputStream(file);
//			out.output(doc, outStream);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JDOMException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			adressDataUrl = new URL("https://nominatim.openstreetmap.org/search/de/" + adress.getCity() + "/" + adress.getStreet() + "/" + adress.getHouseNumber() + "?format=xml&polygon=1&addressdetails=1");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		URLConnection connection;
		try {
			connection = adressDataUrl.openConnection();
			InputStream is = connection.getInputStream();
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(is);
			
			
			org.jdom2.Element root = doc.getRootElement();
			org.jdom2.Element place = root.getChild("place");
			Attribute lat = place.getAttribute("lat");
			Attribute lon = place.getAttribute("lon");
			double i1 = lat.getDoubleValue();
			double i2 = lon.getDoubleValue();
			return new double[] {i1,i2};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new double[] {0,0};

	}
}
