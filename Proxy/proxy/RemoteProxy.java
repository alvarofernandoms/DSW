package proxy;

import java.lang.reflect.*;

import video.Video;

public class RemoteProxy implements InvocationHandler {

	Video videoObject02;

	public RemoteProxy(Video videoObject01) {
		videoObject02 = videoObject01;
	}

	public Object invoke(Object aProxy, Method method, Object args[])
			throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(videoObject02, args);
			} else if (method.getName().equals("setCountry")) {
				throw new IllegalAccessException();

			} else if (method.getName().startsWith("set")) {
				return method.invoke(videoObject02, args);

			}
		} catch (InvocationTargetException aEx) {
			aEx.printStackTrace();
		}
		return null;
	}

}
