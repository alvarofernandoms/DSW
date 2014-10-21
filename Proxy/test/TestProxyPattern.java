package test;

import java.lang.reflect.*;

import proxy.ProtectionProxy;
import proxy.RemoteProxy;

import context.ViewerFromBrazil;

import video.Video;

import db.VideoDB;

public class TestProxyPattern {
	VideoDB videoDB = new VideoDB();

	// Creates a new instance of TestProxyPattern
	public TestProxyPattern() {

		Video video01 = new ViewerFromBrazil();
		video01.setCountry("Brasil");
		video01.setViewVideoNerdOffice("Link para o vídeo do NerdOffice");

		Video video02 = new ViewerFromBrazil();
		video02.setCountry("EUA");
		video02.setViewVideoDessceALetra("Link para o vídeo do Desce A Letra");

		videoDB.addVideo(video01);
		videoDB.addVideo(video02);

	}

	public static void main(String[] args) {
		TestProxyPattern theProxyPattern = new TestProxyPattern();
		theProxyPattern.runExample();
	}

	public void runExample() {
		Video umPrimeiroVideo = videoDB.getCountry("Brazil");
		Video umPrimeiroVideoProxy = getFirstProxy(umPrimeiroVideo);
		umPrimeiroVideoProxy.setViewVideoNerdOffice("url para o vídeo do NerdOfiice");
		System.out.println("O vídeo está sendo acessado do Brazil ::"
				+ umPrimeiroVideo.getCountry());
		try {
			umPrimeiroVideoProxy
					.setViewVideoNerdOffice("Visualizar vídeo do NerdOffice");
		} catch (Exception theEx) {
			System.out
					.println("Este vídeo não está disponível no seu país. Desculpe.");
		}

		Video umSegundoVideo = videoDB.getCountry("EUA");
		Video umSegundoVideoProxy = getSecondProxy(umPrimeiroVideo);
		umSegundoVideoProxy.setCountry("EUA");
		System.out
				.println("Sua permissão de acesso foi alterada por um proxy no seguinte país (remotamente): "
						+ umSegundoVideoProxy.getCountry()
						+ "\nUrl: "
						+ umSegundoVideo.getViewVideoDesceALetra());
		try {
			umSegundoVideoProxy
					.setCountry("Usuário remoto tenta mudar o País do primeiro video.");
		} catch (Exception theEx) {
			System.out.println("Ninguém pode mudar o país um do outro, então,"
					+ "O País do primeiro video continua:"
					+ umPrimeiroVideo.getCountry());
		}
	}

	Video getFirstProxy(Video videoObject01) {
		return (Video)Proxy.newProxyInstance(
				videoObject01.getClass().getClassLoader(), 
				videoObject01.getClass().getInterfaces(),
				new ProtectionProxy(videoObject01));
	}

	Video getSecondProxy(Video videoObject02) {
		return (Video)Proxy.newProxyInstance(
				videoObject02.getClass().getClassLoader(), 
				videoObject02.getClass().getInterfaces(),
				new RemoteProxy(videoObject02));
	}

}
