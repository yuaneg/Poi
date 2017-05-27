package com.xml.yuan;

import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.junit.Assert;
import org.junit.Test;


public class XmlTest {

	@Test
	public void xmlInit() throws Exception{
		List<Element> list = AnalysisXml.analysisXml("fy_district.xml");
		Assert.assertTrue(null != list && list.size() > 0);
	}
	@Test
	public void xmlCotainsDataForXML() throws Exception{
		Map<String,String> map = AnalysisXml.cotainsDataForXML("fy_district.xml", "北京市", "city_name");
		Assert.assertTrue(map.size()>0);
	}

}
