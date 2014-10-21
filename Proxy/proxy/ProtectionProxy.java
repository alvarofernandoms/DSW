package proxy;

import java.lang.reflect.*;

import video.Video;

public class ProtectionProxy implements InvocationHandler {
	
	/*
	 * A clsse que representa o proxy dinâmico deve implementar a 
	 * interface InvocationHandler, que é a interface responsável 
	 * pela mágica. Ela define o método invoke, que é onde iremos 
	 * colocar nosso comportamento.
	 */
	
	Video videoObject02;
	
	public ProtectionProxy(Video videoObject01){
		videoObject02 = videoObject01;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws IllegalAccessException {
		try{
			 if(method.getName().startsWith("get")){
				 return method.invoke(videoObject02, args); 
			 }
			 else if (method.getName().equals("setView")){
				 throw new IllegalAccessException();
			 }
			 else if (method.getName().startsWith("set")){
				return method.invoke(videoObject02, args);
			 }
		}catch (InvocationTargetException aEx){
            aEx.printStackTrace();
		}
	return null;
	}	
}	
