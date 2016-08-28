package com.gmail.ichglauben.pagegenerator.core;

import java.util.ArrayList;
import java.util.List;

public class GenericBootStrapPageGenerator {
	WebpageGenerator wg = new WebpageGenerator();
	String nav = "<nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">" +
			"<div class=\"container-fluid\">" +
				"<div class=\"navbar-header\">" +
					"<span class=\"navbar-brand\" id=\"navbarheadertop\">HTML Element Generator</span>" +
				"</div>" +
				"<ul class=\"nav navbar-nav\">" +
					"<li><a target=\"_blank\" id=\"about\" class=\"noanchor\" href=\"https://github.com/quauab?tab=repositories\">More Libraries</a></li>" +
				"</ul>" +					
			"</div>" +
		"</nav>";
	String content = "<main class=\"content\" id=\"content\">" +
			"<div class=\"row\">" +	
				"<div class=\"col-sm-12\">" +
					"<div class=\"jumbotron\">" + 
						"<h3>Generic Webpage Generator - Java Library</h3><br>" +
						"<p style=\"text-align:center\">Generate HTML elements that make up a webpage</p>" +
						"<h2>Dependencies</h2>" +
						"<ul>" +
							"<li><a target=\"_blank\" href=\"https://github.com/quauab/TextFileWriter\">TextfileWriter</a></li>" +
						"</ul>" +
					"</div>" +
				"</div>" +
			"</div>";
	String[] bottomElements = new String[] {
			"<link rel=\"stylesheet\" href=\"https://dl.dropboxusercontent.com/u/50203839/web/sites/quauab/css/style_a.css\">"				
	};
	String bodyElements[] = new String[] {nav,content};
	
	public String buildPage(String[] content, String[] bottomElements, String pageTitle) {
		List<String> bodySettings = new ArrayList<String>();
		bodySettings.add("class=\"container\"");
		
		List<String> pageHead = new ArrayList<String>();
		pageHead.add("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		pageHead.add("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
		pageHead.add("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");

		if (null != pageTitle && pageTitle.length() > 0)
			pageHead.add("<title>" + pageTitle + "</title>");
		
		String head = wg.makeHead(pageHead);
		
		String body = wg.makeBody(bodySettings, content);
		
		String page = wg.makePage(head, body, bottomElements);

		return page;
	}
	
	public String buildPage() {
		List<String> bodySettings = new ArrayList<String>();
		bodySettings.add("class=\"container\"");		
		String head = wg.makeHead(new String[] {
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">",
				"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>",
				"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>",
				"<title>A Java Webpage Generator</title>"
		});		
		String body = wg.makeBody(bodySettings, bodyElements);		
		String page = wg.makePage(head, body, bottomElements);
		return page;
	}
	
	public String toString() { return "BootStrap Page Generator"; }
}
