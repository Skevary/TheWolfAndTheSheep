package com.vk.native_code;

import java.util.ArrayList;

public class Contents {
    private static ArrayList<Sheep> sheepArr = new ArrayList<>();
    private Wolf wolf = new Wolf(300, 300);
    
    public void sheepCreator(int theNumber) {
	for (int i = 0; i <= theNumber; i++) {
	    int x = (int) Math.floor(Math.random() * 600);
	    int y = (int) Math.floor(Math.random() * 600);
	    sheepArr.add(new Sheep(x, y));
	}
    }
}
