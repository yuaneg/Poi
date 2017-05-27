package com.xml.yuan;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 用dom4j读取xml
 */
@SuppressWarnings("unchecked")
public class AnalysisXml {

	/**
	 * 解析xml xmlName 需要解析的xml名
	 * 
	 * @author Future
	 * 
	 */
	public static List<Element> analysisXml(String xmlName) throws Exception {
		SAXReader reader = new SAXReader();
		InputStream input = AnalysisXml.class.getResourceAsStream("/"+xmlName);
		Document document = reader.read(input);
		Element root = document.getRootElement();
		List<Element> childElements = root.elements();
		return childElements;
	}

	/**
	 * 从xml中匹配数据 xmlName 
	 * data 比较的字符串
	 * contData xml 中被比较的
	 * @author Future
	 * 
	 */
	public static Map<String, String> cotainsDataForXML(String xmlName, String data, String contData) throws Exception {
		List<Element> childElements = analysisXml(xmlName);
		Map<String, String> bankCardMsg = new HashMap<String, String>();
		for (Element child : childElements) {
			List<Element> elementList = child.elements();
			if (data.contains(child.elementText(contData))) {
				for (Element ele : elementList) {
					bankCardMsg.put(ele.getName(), ele.getText());
				}
				break;
			}
		}
		return bankCardMsg;
	}

	/**
	 * 得到xml中数据 xmlName xml路径
	 * 
	 * @author Future
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static List<Map> getDataForXML(String xmlName) throws Exception {
		List<Element> childElements = analysisXml(xmlName);
		List<Map> list = new ArrayList<Map>();
		for (Element child : childElements) {
			List<Element> elementList = child.elements();
			Map<String, String> bankCardMsg = new HashMap<String, String>();
			for (Element ele : elementList) {
				bankCardMsg.put(ele.getName(), ele.getText());
			}
			list.add(bankCardMsg);
		}
		return list;
	}
}
