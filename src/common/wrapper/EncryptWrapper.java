package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}

	/*password에 대한 암호화 처리를 진행할거임*/
	//request.getParameter("name");
	//request.getParameter("password");
	
	@Override
	public Object getAttribute(String name)
	{
		Object value="";
		if(name != null&&(name.equals("num")))
		{
			value=getSha512((String)super.getAttribute(name));
		}
		else
		{
			  value=super.getAttribute(name);
		}
		return value;
	}
	
	
	
	
	
	public String getParameter(String name) {
		//암호화값을 보관을 위한 변수
		String value="";
		if(name != null&&(name.equals("password")||name.equals("password_")||name.equals("password_new")))
		{
			value=getSha512(super.getParameter(name));
		}
		else
		{
			value=super.getParameter(name);
		}
		return value;
	}
	
	private static String getSha512(String key)
	{
		String encPwd=null;
		//암호화 객체
		MessageDigest md=null;
		
		try
		{
			//암호화 알고리즘 적용
			md=MessageDigest.getInstance("SHA-512");
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		byte[] bytes=key.getBytes(Charset.forName("UTF-8"));
		//byte배열로 바뀐 값을 암호화 알고리즘(SHA-512)을 이용하여 변경
		md.update(bytes);
		//웹어플리케이션에서 이해할수있도록 Base64방식으로 재 인코딩(문자열(String))
		encPwd=Base64.getEncoder().encodeToString(md.digest());
		return encPwd;
	}
}
