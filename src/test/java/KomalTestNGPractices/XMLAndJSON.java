package KomalTestNGPractices;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class XMLAndJSON {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter SparkReporter = new ExtentSparkReporter("file");

		extentReports.attachReporter(SparkReporter);

		// copy and paste the xml and json data using string format

		String xmlData = "<menu id=\"file\" value=\"File\">\n" + "  <popup>\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" + "  </popup>\n" + "</menu>";

		String jsonData = "{\"menu\": {\n" + "  \"id\": \"file\",\n" + "  \"value\": \"File\",\n" + "  \"popup\": {\n"
				+ "    \"menuitem\": [\n" + "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" + "    ]\n" + "  }\n" + "}}";
		
		List<String> listData=new ArrayList<String>();
		listData.add("abc");
		listData.add("xyz");
		listData.add("pqr");
		
		Map<Integer,String> mapData =new HashMap<Integer, String>();
		mapData.put(101, "Komal");
		mapData.put(102, "Sonal");
		mapData.put(103, "Raj");
		
		Set<Integer>setData=mapData.keySet();


		// Now log that above info into extent report using Markup helper class

		extentReports.createTest("xml based test").info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));

		extentReports.createTest("json based test").info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		
		extentReports.createTest("List Data").info(MarkupHelper.createOrderedList(listData));
		extentReports.createTest("List Data").info(MarkupHelper.createUnorderedList(listData));

		extentReports.createTest("Map Data").info(MarkupHelper.createUnorderedList(mapData));
		extentReports.createTest("List Data").info(MarkupHelper.createUnorderedList(mapData));

		extentReports.createTest("set Data").info(MarkupHelper.createOrderedList(setData));

     // for highlighting the message
		extentReports.createTest("Highlighting the error msg").info(MarkupHelper.createLabel("This is a first highlighting msg", ExtentColor.RED));
		
		
    //Exception using try catch block
	
		try {
			int a= 34/0;
		}catch(Exception e) {
		
			extentReports.createTest("exception test1").info(e);
			
		}
		
		//custom exception 
		Throwable t = new RuntimeException("this is a user defined exception");
		extentReports.createTest("Exception test2").info(t);

		extentReports.flush();

		Desktop.getDesktop().browse(new File("file").toURI());

	}

}
