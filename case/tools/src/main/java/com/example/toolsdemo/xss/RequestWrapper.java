package com.example.toolsdemo.xss;

import org.owasp.validator.html.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 16:15 2020/3/10
 * @Modified By:
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }
    
    public Map<String,String[]> getParameterMap(){
        Map<String, String[]> requestParameters = super.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = requestParameters.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = iterator.next();
            String [] values  = (String[]) entry.getValue();
            for(int i=0;i<values.length;i++){
                System.out.println(values[i]);
                values[i] = xssClean(values[i]);
            }
        }
        return requestParameters;
    }

    public String getParameter(String name){
        String v = super.getParameter(name);
        if (v == null) {
            return null;
        }else{
            return xssClean(v);
        }
    }
    public String[] getParameterValues(String name) {
        String[] v=super.getParameterValues(name);
        if(v==null || v.length==0)
            return v;
        for(int i=0;i<v.length;i++){
            v[i]=xssClean(v[i]);
        }
        return v;
    }

    private String xssClean(String value) {
        AntiSamy antiSamy = new AntiSamy();
        try {
            Policy policy = Policy.getInstance("antisamy.xml");
            final CleanResults scan = antiSamy.scan(value, policy);
            System.out.println("clean:"+scan.getCleanHTML());
        } catch (PolicyException e) {
            e.printStackTrace();
        } catch (ScanException e) {
            e.printStackTrace();
        }
        return value;
    }


}
