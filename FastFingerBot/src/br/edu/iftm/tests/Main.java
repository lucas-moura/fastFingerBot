package br.edu.iftm.tests;

import br.edu.iftm.fastfingerbot.FastFingerBot;

public class Main {

	public static void main(String[] args) {
		FastFingerBot fastfingerBot = new FastFingerBot("mouulee", "123456789");
		fastfingerBot.start(100);
	}

}
