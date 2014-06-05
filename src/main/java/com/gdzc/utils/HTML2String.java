package com.gdzc.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.regex.Pattern;


public class HTML2String extends TagSupport {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String content;//去除的内容
	private String length;//去除的内容后截取的长度
	private String subs;//省略后符号
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }


    public String getSubs() {
        return subs;
    }
    public void setSubs(String subs) {
        this.subs = subs;
    }
    @Override
    public int doAfterBody() throws JspException {
        return super.doAfterBody();
    }

	
    @Override
    public int doEndTag() throws JspException {
    	if (StringUtils.isEmpty(this.content)) {
            return EVAL_PAGE;
        }
    	//默认截取长度10
    	Integer size = 10;
    	if(StringUtils.isNotEmpty(this.length)) {
    	    size = Integer.parseInt(length);
    	}
    	JspWriter writer = pageContext.getOut();
    	//处理内容
        String string = html2String(this.content);
        StringBuffer sb = new StringBuffer(string);
        String writes ="";
        String shenglue = "...";
        if(StringUtils.isNotEmpty(this.subs)) {
            shenglue = this.subs;
        }
        if(size > 0){
        	if(size < sb.length()) {
        	    writes = sb.substring(0, size)+shenglue;
        	} else {
        	    writes = sb.toString();
        	}
        	   
        }
        try {
            writer.write(writes);
		} catch (IOException e) {
			throw new JspException(e);
		}
        return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag();
    }
    
    public String html2String(String inputString) {  
                String htmlStr = inputString; // 含html标签的字符串  
                String textStr = "";  
                Pattern p_script;
                java.util.regex.Matcher m_script;
                Pattern p_style;
                java.util.regex.Matcher m_style;
                Pattern p_html;
                java.util.regex.Matcher m_html;  
                try {  
                    String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script>]*?>[\s\S]*?<\/script>  
                    // }  
                    String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style>]*?>[\s\S]*?<\/style>  
                    // }  
                    String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
          
                    p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
                    m_script = p_script.matcher(htmlStr);  
                    htmlStr = m_script.replaceAll(""); // 过滤script标签  
          
                    p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
                    m_style = p_style.matcher(htmlStr);  
                    htmlStr = m_style.replaceAll(""); // 过滤style标签  
          
                    p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
                    m_html = p_html.matcher(htmlStr);  
                    htmlStr = m_html.replaceAll(""); // 过滤html标签  
          
                   textStr = htmlStr;  
          
                } catch (Exception e) {  
                    System.err.println("Html2Text: " + e.getMessage());  
                }  
          
                return textStr;  
        }
}
